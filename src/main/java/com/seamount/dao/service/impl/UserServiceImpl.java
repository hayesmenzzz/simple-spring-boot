package com.seamount.dao.service.impl;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.seamount.dao.UserDao;
import com.seamount.dao.model.UserModel;

//import com.midai.car.query.UserQuery;
import com.seamount.dao.service.UserService;

    
//@Service(version="1.0.0",protocol="dubbo")
@Service
public class UserServiceImpl implements UserService{
	@Autowired
	private UserDao userDao;

	
	//根据ID查询指定的数据
	public UserModel getById(long id){ 
		return userDao.getById(id);
	}
	
	//删除 
	public void delById(long id){
		userDao.delById(id);
	}
	
	//新增
	public long insert(UserModel user){	
	    		return userDao.insert(user);
		
	}
	
	//修改
	public long update(UserModel user){
	    		return userDao.update(user);
	}
	
	//高级查询 
	//@Override
	//public List<UserModel> fetchPageAdvance(UserQuery query) {
	    //		//return userMapper.fetchPageAdvance(query);
//	}
	
	//高级查询总记录数
	//@Override
	//public int fetchPageAdvanceCount(UserQuery query) {
	   // 	//	return userMapper.fetchPageAdvanceCount(query);
	//}
	

}
