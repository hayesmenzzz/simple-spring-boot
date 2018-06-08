package com.seamount.dao.service.impl;

import java.sql.Types;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.stereotype.Service;

import com.seamount.dao.LeaveProcessDao;
import com.seamount.dao.model.LeaveApplyProcess;
import com.seamount.dao.service.TblLeaveApplyProcessDaoService;

@Service
public class TblLeaveApplyProcessDaoServiceImpl implements TblLeaveApplyProcessDaoService {

	@Autowired
	private LeaveProcessDao leaveProcessDao;
	
	@Override
	public LeaveApplyProcess queryforBusinessId(String businessId) {
		return leaveProcessDao.queryforBusinessId(businessId);
	}

	@Override
	public void insert(LeaveApplyProcess bean) {
		leaveProcessDao.insert(bean);
	}

	@Override
	public void update(LeaveApplyProcess bean) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<String> queryCurrentProcessMobiles(String roleId) {
		// TODO Auto-generated method stub
		return null;
	}


}
