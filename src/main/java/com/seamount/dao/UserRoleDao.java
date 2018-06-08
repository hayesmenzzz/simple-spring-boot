package com.seamount.dao;
import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.Update;

import com.seamount.dao.model.UserRoleModel;

@Mapper
public interface  UserRoleDao{
	

																																																																																																																				
	public String columns="user_id,role_id";
	
	public String insert="user_id,role_id";
																																																																																																												
	public String property="#{userId},#{roleId}";
	
	public String insertProperty="#{userId},#{roleId}";
																																																																																																																				
	public String update="role_id=#{roleId}";
	
	@Select("select "+columns+" from user_role where ID=#{id}")
	@ResultMap(value="com.seamount.dao.UserRoleDao.UserRoleModelMap")
	public UserRoleModel getById(long id);
	
	@Insert("insert into user_role ("+insert+") values ("+insertProperty+")")
	@SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Long.class)
	public long insert(UserRoleModel userRole);

	@Update("update user_role set "+update+" where ID=#{id}")
	public long update(UserRoleModel userRole); 
	
	@Delete("delete from user_role where 1 = 1 and ID=#{id} ")
	public void delById(long id);

	//@SelectProvider(type=com.midai.car.provider.UserRoleProvider.class,method="fetchPageAdvance")
	//@ResultMap(value="com.midai.car.mapper.UserRoleMapper.UserRoleModelMap")
	//public List<UserRoleModel> fetchPageAdvance(UserRoleQuery query);  
	
	
	//@SelectProvider(type=com.midai.car.provider.UserRoleProvider.class,method="fetchPageAdvanceCount")
	//public int fetchPageAdvanceCount(UserRoleQuery query);
	
	
	
	
}