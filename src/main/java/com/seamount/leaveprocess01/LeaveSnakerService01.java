package com.seamount.leaveprocess01;

import java.util.List;
import java.util.Map;

import org.snaker.engine.entity.WorkItem;

/**
 * 请假流程snaker封装
 * @author Administrator
 *
 */
public interface LeaveSnakerService01 {

	/**
	 * 
	 * @param businessId 业务和工作流结合
	 * @param operator 具体操作人用于业务权限控制(谁登录的系统)
	 * @param variables 流程变量
	 */
	void startProcess(String businessId, String operator, Map<String,Object> variables);
	
	void runProcess(String taskId, String businessId, String operator, String roleName, Map<String, Object> variables, boolean approve, String nodeName);

	void closeProcess(String businessId, String operator);
	
	/**
	 * 获取待审任务数
	 * @param operator
	 * @return
	 */
	List<WorkItem> queryProcessList(String operator);
	
	void nodeJump(String taskId,String businessId, String operator, Map<String, Object> variables, String roleName, String nodeName);
}
