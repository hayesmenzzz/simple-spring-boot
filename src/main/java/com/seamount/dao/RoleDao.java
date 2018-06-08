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

import com.seamount.dao.model.RoleModel;

@Mapper
public interface  RoleDao{
	

																																																																																																																				
	public String columns="role_id,role_name,role_des";
	
	public String insert="role_id,role_name,role_des";
																																																																																																												
	public String property="#{roleId},#{roleName},#{roleDes}";
	
	public String insertProperty="#{roleId},#{roleName},#{roleDes}";
																																																																																																																				
	public String update="role_name=#{roleName},role_des=#{roleDes}";
	
	@Select("select "+columns+" from role where ID=#{id}")
	@ResultMap(value="com.seamount.dao.RoleDao.RoleModelMap")
	public RoleModel getById(long id);
	
	@Insert("insert into role ("+insert+") values ("+insertProperty+")")
	@SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Long.class)
	public long insert(RoleModel role);

	@Update("update role set "+update+" where ID=#{id}")
	public long update(RoleModel role); 
	
	@Delete("delete from role where 1 = 1 and ID=#{id} ")
	public void delById(long id);

	//@SelectProvider(type=com.midai.car.provider.RoleProvider.class,method="fetchPageAdvance")
	//@ResultMap(value="com.midai.car.mapper.RoleMapper.RoleModelMap")
	//public List<RoleModel> fetchPageAdvance(RoleQuery query);  
	
	
	//@SelectProvider(type=com.midai.car.provider.RoleProvider.class,method="fetchPageAdvanceCount")
	//public int fetchPageAdvanceCount(RoleQuery query);
	
	
	
	
}