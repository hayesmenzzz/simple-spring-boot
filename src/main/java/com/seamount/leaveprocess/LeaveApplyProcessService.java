package com.seamount.leaveprocess;

import java.util.List;

import com.seamount.dao.model.LeaveApplyProcess;

public interface LeaveApplyProcessService {

	LeaveApplyProcess queryforBusinessId(String businessId);
	
	void insert(LeaveApplyProcess bean);

	void update(LeaveApplyProcess bean);
	
	List<String> queryCurrentProcessMobiles(String roleId);
}
