package com.seamount.leaveprocess;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.seamount.dao.model.LeaveApplyProcess;
import com.seamount.dao.service.TblLeaveApplyProcessDaoService;

@Service("leaveApplyProcessServiceImpl")
public class LeaveApplyProcessServiceImpl implements LeaveApplyProcessService {

	@Autowired
	private TblLeaveApplyProcessDaoService tblLeaveApplyProcessDaoService;
	
	@Override
	public void insert(LeaveApplyProcess bean) {
		tblLeaveApplyProcessDaoService.insert(bean);
	}

	@Override
	public void update(LeaveApplyProcess bean) {
		tblLeaveApplyProcessDaoService.update(bean);
	}

	@Override
	public LeaveApplyProcess queryforBusinessId(String businessId) {
		return tblLeaveApplyProcessDaoService.queryforBusinessId(businessId);
	}

	@Override
	public List<String> queryCurrentProcessMobiles(String roleId) {
		return tblLeaveApplyProcessDaoService.queryCurrentProcessMobiles(roleId);
	}

}
