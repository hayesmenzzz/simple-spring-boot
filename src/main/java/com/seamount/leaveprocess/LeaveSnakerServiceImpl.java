package com.seamount.leaveprocess;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.snaker.engine.access.Page;
import org.snaker.engine.access.QueryFilter;
import org.snaker.engine.entity.Order;
import org.snaker.engine.entity.Process;
import org.snaker.engine.entity.Task;
import org.snaker.engine.entity.WorkItem;
import org.snaker.engine.model.TaskModel.TaskType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.seamount.dao.model.LeaveApplyProcess;
import com.seamount.snaker.SnakerEngineFacets;

@Service("leaveSnakerServiceImpl")
public class LeaveSnakerServiceImpl implements LeaveSnakerService {

	private final static Logger log = LoggerFactory.getLogger(LeaveSnakerServiceImpl.class);

	@Autowired
	private SnakerEngineFacets snakerEngineFacets;

	@Autowired
	private LeaveApplyProcessService leaveApplyProcessService;

//	@Autowired
//	private MobileContentDao mobileContentDao;

	private final ExecutorService fixedThreadPool = Executors.newFixedThreadPool(3);

	@Override
	public void startProcess(String businessId, String operator, Map<String, Object> variables) {

		try {
			String processId = "";
			Process processByName = snakerEngineFacets.getProcessService().getProcessByVersion("leaveProcess", 0);
			if(processByName != null){
				processId = processByName.getId();
			}else{
				processId = snakerEngineFacets.initFlows("static/leave.snaker");
			}

			// 定义流程变量,部署流程的流程变量全局可用,故在此处定义好流程操作员
			variables.put("businessId", businessId);
			variables.put("leaveApply", LeaveProcessRunStateEnum.LEAVE_APPLY.getRoleName());
			variables.put("leaderReview", LeaveProcessRunStateEnum.LEADER_REVIEW.getRoleName());
			variables.put("managerApproval", LeaveProcessRunStateEnum.MANAGER_REVIEW.getRoleName());

			Order order = snakerEngineFacets.startAndExecute(processId, operator, variables);
			log.info("借款流程启动成功！");
			// 更新流程业务表
			List<Task> activeTasks = snakerEngineFacets.getEngine().query()
					.getActiveTasks(new QueryFilter().setOrderId(order.getId()));
			if (activeTasks != null && activeTasks.size() > 0) {
				Task task = activeTasks.get(0);
				String taskId = task.getId();
				String taskName = task.getTaskName();
				log.info("======================>>>>>  taskName:" + taskName + "     taskId:" + taskId);
				LeaveApplyProcess queryforBusinessId = leaveApplyProcessService.queryforBusinessId(businessId);
				if (queryforBusinessId == null) {
					queryforBusinessId = new LeaveApplyProcess();
				}
				queryforBusinessId.setBusinessId(businessId);
				queryforBusinessId.setDefKey(LeaveProcessRunStateEnum.queryByProcessState(taskName).getState() + "");
				queryforBusinessId.setOperator(operator);
				queryforBusinessId.setTaskId(taskId);
				queryforBusinessId.setProcessKey(
						snakerEngineFacets.getEngine().process().getProcessById(order.getProcessId()).getName());
				queryforBusinessId.setProcessOrderId(order.getId());
				queryforBusinessId.setRoleName(LeaveProcessRunStateEnum.queryByProcessState(taskName).getRoleName());
				leaveApplyProcessService.insert(queryforBusinessId);

				List<String> list = leaveApplyProcessService.queryCurrentProcessMobiles(
						String.valueOf(LeaveProcessRunStateEnum.queryByProcessState(taskName).getState()));
				final String content = "您好！申请编号为[" + businessId + "]的请假申请已经流转至您的审批节点，请尽快审批！";
				for (int i = 0; i < list.size(); i++) {
					// 获取流程下一个操作人并发短信
					final String mobile = list.get(i);
					fixedThreadPool.submit(new Runnable() {
						public void run() {
							try {
//								boolean sendMobiMessage = SendMessageUtils.sendMobiMessage(mobile, content);
//								if (sendMobiMessage) {
//									// 插入手机短信audit表
//									mobileContentDao.insertMobileMessageAudit(0, mobile, content);
//								}
							} catch (Exception e) {
								log.info("短信发送失败,请假审批流程通知失败,手机号: [" + mobile + "] " + e.getMessage());
								e.printStackTrace();
							}
						}
					});
				}

			}

		} catch (Exception e) {
			log.info("申请编号：[" + businessId + "] 启动请假申请流程失败！");
			log.error(e.getMessage());
			e.printStackTrace();
		}

	}

	@Override
	public void runProcess(String taskId, String businessId, String operator, String roleName,
			Map<String, Object> variables, boolean approve, String nodeName) {
		try {
			if (StringUtils.isEmpty(taskId)) {
				log.info("taskId 不能为空");
				return;
			}

			List<Task> tasks = null;
			String task_id = "";
			String taskName = "";

			if (approve) {
				tasks = snakerEngineFacets.execute(taskId, roleName, variables);
			} else {
				// 退回
				tasks = snakerEngineFacets.executeAndJump(taskId, roleName, variables, nodeName);
			}

			if (tasks != null && tasks.size() > 0) {
				Task task = tasks.get(0);
				task_id = task.getId();
				taskName = task.getTaskName();
				if (!"complete".equals(taskName) || !"close_process".equals(taskName)) {
					List<String> list = leaveApplyProcessService.queryCurrentProcessMobiles(
							String.valueOf(LeaveProcessRunStateEnum.queryByProcessState(taskName).getState()));
					final String content = "您好！申请编号为[" + businessId + "]的请假申请已经流转至您的审批节点，请尽快审批！";
					for (int i = 0; i < list.size(); i++) {
						// 获取流程下一个操作人并发短信
						final String mobile = list.get(i);
						fixedThreadPool.submit(new Runnable() {
							public void run() {
								try {
//									boolean sendMobiMessage = SendMessageUtils.sendMobiMessage(mobile, content);
//									if (sendMobiMessage) {
//										// 插入手机短信audit表
//										mobileContentDao.insertMobileMessageAudit(0, mobile, content);
//									}
								} catch (Exception e) {
									log.info("短信发送失败,请假审批流程通知失败,手机号: [" + mobile + "] " + e.getMessage());
									e.printStackTrace();
								}
							}
						});
					}
				}
			}

			// 更新业务表数据
//			TblLeaveApplyProcessBean queryforBusinessId = leaveApplyProcessService.queryforBusinessId(businessId);
			//只增
			LeaveApplyProcess queryforBusinessId = new LeaveApplyProcess();
			queryforBusinessId.setBusinessId(businessId);
			queryforBusinessId.setTaskId(StringUtils.isEmpty(task_id) ? "" : task_id);
			// 如果任务编号为空，就设置RunState为【 流程结束】
			queryforBusinessId.setDefKey(
					StringUtils.isEmpty(task_id) ? String.valueOf(LeaveProcessRunStateEnum.COMPLETE.getState())
							: LeaveProcessRunStateEnum.queryByProcessState(taskName).getRoleName());
			// 如果任务编号为空，就设置RoleName为【 流程结束】
			queryforBusinessId.setRoleName(
					StringUtils.isEmpty(task_id) ? String.valueOf(LeaveProcessRunStateEnum.COMPLETE.getState())
							: LeaveProcessRunStateEnum.queryByProcessState(taskName).getRoleName());
			queryforBusinessId.setOperator(operator);
			leaveApplyProcessService.update(queryforBusinessId);
		} catch (Exception e) {
			log.info("请假流程流转失败,申请编号：" + businessId + " taskId:" + taskId);
			e.printStackTrace();
		}
	}

	@Override
	public void closeProcess(String businessId, String operator) {

		//更新业务表数据 tbl_leave_apply_process
		LeaveApplyProcess queryforBusinessId = leaveApplyProcessService.queryforBusinessId(businessId);
		if(queryforBusinessId != null){
			snakerEngineFacets.closeProcess(queryforBusinessId.getProcessOrderId());
			queryforBusinessId.setBusinessId(businessId);
			queryforBusinessId.setDefKey(LeaveProcessRunStateEnum.COMPLETE.toString());
			
			//TODO 其实在上面已经做过处理了,
		}
	}

	@Override
	public List<WorkItem> queryProcessList(String operator) {
		Page<WorkItem> page = new Page<WorkItem>();
		String[] array = operator.split(",");
		String[] assignees = new String[]{operator};
		return snakerEngineFacets.getEngine().query().getWorkItems(page, new QueryFilter().setOperators(array).setTaskType(TaskType.Major.ordinal()));
	}

	@Override
	public void nodeJump(String taskId,String businessId, String operator, Map<String, Object> variables, String roleName, String nodeName) {
		List<Task> executeAndJump = snakerEngineFacets.executeAndJump(taskId, operator, variables, nodeName);
		if(executeAndJump != null && executeAndJump.size() > 0){
			Task task = executeAndJump.get(0);
			//处理业务
			LeaveApplyProcess queryforBusinessId = leaveApplyProcessService.queryforBusinessId(businessId);
			queryforBusinessId.setDefKey(LeaveProcessRunStateEnum.queryByProcessState(task.getTaskName()).getProcessState());
			queryforBusinessId.setOperator(operator);
			queryforBusinessId.setRoleName(roleName);
			queryforBusinessId.setTaskId(task.getId());
			leaveApplyProcessService.update(queryforBusinessId);
			
		}
		
	}

}
