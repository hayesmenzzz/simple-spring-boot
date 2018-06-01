package com.seamount.dao;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;

import com.seamount.dao.model.LeaveApplyProcess;


@Mapper
public interface LeaveProcessDao {

	public String columns = "id,process_key,process_order_id,task_id,business_id,role_name,def_key,operator,create_time,update_time";
	public String insert = "process_key,process_order_id,task_id,business_id,role_name,def_key,operator,create_time";
	public String insertProperty = "#{id},#{processKey},#{processOrderId},#{businessId},#{taskId},#{roleName},#{defKey},#{operator},now()";
	public String update = "id,process_key,process_order_id,task_id,business_id,role_name,def_key,operator,update_time";
	
	@Select("select "+columns+" from tbl_leave_apply_process where business_id=#{businessId}" )
	@ResultMap(value="com.seamount.dao.LeaveProcessDao.LeaveProcessMap")
	public LeaveApplyProcess queryforBusinessId(String businessId);

	@Insert("insert into tbl_leave_apply_process ("+insert+") values ("+insertProperty+")")
	void insert(LeaveApplyProcess bean);

//	void update(LeaveApplyProcess bean);
//
//	List<String> queryCurrentProcessMobiles(String roleId);
}
