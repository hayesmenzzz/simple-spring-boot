package com.seamount.dao.service;

import com.seamount.dao.model.UserRoleModel;
//import com.midai.car.query.UserRoleQuery;

import java.util.List;


public interface UserRoleService{
	
    /**
	 * 
	 * getById:(根据ID查询指定的数据). <br/>
	 * TODO(这里描述这个方法适用条件 – 可选).<br/>
	 * TODO(这里描述这个方法的执行流程 – 可选).<br/>
	 * TODO(这里描述这个方法的使用方法 – 可选).<br/>
	 * TODO(这里描述这个方法的注意事项 – 可选).<br/>
	 *
	 * @author 系统生成  
	 * @param id
	 * @return
	 * @since JDK 1.7
	 */
	public UserRoleModel getById(long id);
	
	/**
	 * 
	 * del:(根据ID删除). <br/>
	 * TODO(这里描述这个方法适用条件 – 可选).<br/>
	 * TODO(这里描述这个方法的执行流程 – 可选).<br/>
	 * TODO(这里描述这个方法的使用方法 – 可选).<br/>
	 * TODO(这里描述这个方法的注意事项 – 可选).<br/>
	 *
	 * @author 系统生成
	 * @param id
	 * @since JDK 1.7
	 */
	public void delById(long id);
	
	/**
	 * 
	 * insert:(新增并返回ID). <br/>
	 * TODO(这里描述这个方法适用条件 – 可选).<br/>
	 * TODO(这里描述这个方法的执行流程 – 可选).<br/>
	 * TODO(这里描述这个方法的使用方法 – 可选).<br/>
	 * TODO(这里描述这个方法的注意事项 – 可选).<br/>
	 *
	 * @author 系统生成   
	 * @param userRole
	 * @return
	 * @since JDK 1.7
	 */
	public long insert(UserRoleModel userRole);
	
	/**
	 * 
	 * update:(修改). <br/>
	 * TODO(这里描述这个方法适用条件 – 可选).<br/>
	 * TODO(这里描述这个方法的执行流程 – 可选).<br/>
	 * TODO(这里描述这个方法的使用方法 – 可选).<br/>
	 * TODO(这里描述这个方法的注意事项 – 可选).<br/>
	 *
	 * @author 系统生成 
	 * @param userRole
	 * @return
	 * @since JDK 1.7
	 */
	public long update(UserRoleModel userRole);
	
	/**
	 * 
	 * fetchPageAdvance:(高级查询带分页). <br/>
	 * TODO(这里描述这个方法适用条件 – 可选).<br/>
	 * TODO(这里描述这个方法的执行流程 – 可选).<br/>
	 * TODO(这里描述这个方法的使用方法 – 可选).<br/>
	 * TODO(这里描述这个方法的注意事项 – 可选).<br/>
	 *
	 * @author 系统生成   
	 * @param query
	 * @return
	 * @since JDK 1.7
	 */
	//public List<UserRoleModel> fetchPageAdvance(UserRoleQuery query);
	
		/**
	 * 
	 * fetchPageAdvanceCount:(高级查询总记录数). <br/>
	 * TODO(这里描述这个方法适用条件 – 可选).<br/>
	 * TODO(这里描述这个方法的执行流程 – 可选).<br/>
	 * TODO(这里描述这个方法的使用方法 – 可选).<br/>
	 * TODO(这里描述这个方法的注意事项 – 可选).<br/>
	 *
	 * @author 系统生成
	 * @param query
	 * @return
	 * @since JDK 1.7
	 */
	//public int fetchPageAdvanceCount(UserRoleQuery query);
	
	

}
