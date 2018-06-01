package com.seamount.dao.model;

import java.util.Date;

public class LeaveApplyProcess {

	private int id;
	private String processKey;
	private String processOrderId;
	private String businessId;
	private String taskId;
	private String roleName;
	private String defKey;
	private String operator;
	private Date createTime;
	private Date updateTime;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getProcessKey() {
		return processKey;
	}
	public void setProcessKey(String processKey) {
		this.processKey = processKey;
	}
	public String getProcessOrderId() {
		return processOrderId;
	}
	public void setProcessOrderId(String processOrderId) {
		this.processOrderId = processOrderId;
	}
	public String getBusinessId() {
		return businessId;
	}
	public void setBusinessId(String businessId) {
		this.businessId = businessId;
	}
	public String getRoleName() {
		return roleName;
	}
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	public String getDefKey() {
		return defKey;
	}
	public void setDefKey(String defKey) {
		this.defKey = defKey;
	}
	public String getOperator() {
		return operator;
	}
	public void setOperator(String operator) {
		this.operator = operator;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public Date getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
	

	public String getTaskId() {
		return taskId;
	}
	public void setTaskId(String taskId) {
		this.taskId = taskId;
	}
	/**
	 * bean 必须带无参的构造函数 不然会报初始化错误 被误认为abstractClass
	 */
	public LeaveApplyProcess() {
		super();
	}
	public LeaveApplyProcess(int id, String processKey, String processOrderId, String businessId, String taskId,
			String roleName, String defKey, String operator, Date createTime, Date updateTime) {
		super();
		this.id = id;
		this.processKey = processKey;
		this.processOrderId = processOrderId;
		this.businessId = businessId;
		this.taskId = taskId;
		this.roleName = roleName;
		this.defKey = defKey;
		this.operator = operator;
		this.createTime = createTime;
		this.updateTime = updateTime;
	}
	@Override
	public String toString() {
		return "TblLeaveApplyProcessBean [id=" + id + ", processKey=" + processKey + ", processOrderId="
				+ processOrderId + ", businessId=" + businessId + ", taskId=" + taskId + ", roleName=" + roleName
				+ ", defKey=" + defKey + ", operator=" + operator + ", createTime=" + createTime + ", updateTime="
				+ updateTime + "]";
	}
	
	
	
}
