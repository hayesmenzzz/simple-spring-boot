package com.seamount.dao.service.impl;

import com.seamount.dao.UserRoleDao;
import com.seamount.dao.model.UserRoleModel;
//import com.midai.car.query.UserRoleQuery;
import com.seamount.dao.service.UserRoleService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


    
//@Service(version="1.0.0",protocol="dubbo")
@Service
public class UserRoleServiceImpl implements UserRoleService{
	@Autowired
	private UserRoleDao userRoleDao;

	
	//根据ID查询指定的数据
	public UserRoleModel getById(long id){ 
		return userRoleDao.getById(id);
	}
	
	//删除 
	public void delById(long id){
	    		userRoleDao.delById(id);
	}
	
	//新增
	public long insert(UserRoleModel userRole){	
	    		return userRoleDao.insert(userRole);
		
	}
	
	//修改
	public long update(UserRoleModel userRole){
	    		return userRoleDao.update(userRole);
	}
	
	//高级查询 
	//@Override
	//public List<UserRoleModel> fetchPageAdvance(UserRoleQuery query) {
	    //		//return userRoleDao.fetchPageAdvance(query);
	//}
	
	//高级查询总记录数
	//@Override
	//public int fetchPageAdvanceCount(UserRoleQuery query) {
	   // 	//	return userRoleMapper.fetchPageAdvanceCount(query);
	//}

	
	

}
