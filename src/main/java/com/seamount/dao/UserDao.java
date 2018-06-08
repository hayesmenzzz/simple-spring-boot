package com.seamount.dao;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;
import org.apache.ibatis.annotations.Update;

import com.seamount.dao.model.UserModel;

@Mapper
public interface  UserDao{
	

																																																																																																																				
	public String columns="id,name,password,phone,categary,delete";
	
	public String insert="name,password,phone,categary,delete";
																																																																																																												
	public String property="#{id},#{name},#{password},#{phone},#{categary},#{delete}";
	
	public String insertProperty="#{name},#{password},#{phone},#{categary},#{delete}";
																																																																																																																				
	public String update="name=#{name},password=#{password},phone=#{phone},categary=#{categary},delete=#{delete}";
	
	@Select("select "+columns+" from user where ID=#{id}")
	@ResultMap(value="com.seamount.dao.UserDao.UserModelMap")
	public UserModel getById(long id);
	
	@Insert("insert into user ("+insert+") values ("+insertProperty+")")
	@SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Long.class)
	public long insert(UserModel user);

	@Update("update user set "+update+" where ID=#{id}")
	public long update(UserModel user); 
	
	@Delete("delete from user where 1 = 1 and ID=#{id} ")
	public void delById(long id);

	//@SelectProvider(type=com.midai.car.provider.UserProvider.class,method="fetchPageAdvance")
	//@ResultMap(value="com.midai.car.mapper.UserMapper.UserModelMap")
	//public List<UserModel> fetchPageAdvance(UserQuery query);  
	
	
	//@SelectProvider(type=com.midai.car.provider.UserProvider.class,method="fetchPageAdvanceCount")
	//public int fetchPageAdvanceCount(UserQuery query);
	
	
	
	
}