package com.seamount.dao.service.impl;

import com.seamount.dao.RoleDao;
import com.seamount.dao.model.RoleModel;
//import com.midai.car.query.RoleQuery;
import com.seamount.dao.service.RoleService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


    
//@Service(version="1.0.0",protocol="dubbo")
@Service
public class RoleServiceImpl implements RoleService{
	@Autowired
	private RoleDao roleDao;

	
	//根据ID查询指定的数据
	public RoleModel getById(long id){ 
		return roleDao.getById(id);
	}
	
	//删除 
	public void delById(long id){
		roleDao.delById(id);
	}
	
	//新增
	public long insert(RoleModel role){	
	    		return roleDao.insert(role);
		
	}
	
	//修改
	public long update(RoleModel role){
	    		return roleDao.update(role);
	}
	
	//高级查询 
	//@Override
	//public List<RoleModel> fetchPageAdvance(RoleQuery query) {
	    //		//return roleMapper.fetchPageAdvance(query);
//	}
	
	//高级查询总记录数
	//@Override
	//public int fetchPageAdvanceCount(RoleQuery query) {
	   // 	//	return roleMapper.fetchPageAdvanceCount(query);
	//}

	
	

}
