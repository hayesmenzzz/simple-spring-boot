package com.seamount.leaveprocess;

public enum LeaveApproveEnum {

	LEADER_AGREE(3,"leaderAgree",true),
	LEADER_DISAGREE(3,"leaderDisagree",false),
	MANAGER_AGREE(4,"managerAgree",true),
	MANAGER_DISAGREE(4,"managerDisagree",false);
	
	private int roleId;
	private String approveStr;
	private boolean approveFlag;
	
	public int getRoleId() {
		return roleId;
	}
	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}
	public String getApproveStr() {
		return approveStr;
	}
	public void setApproveStr(String approveStr) {
		this.approveStr = approveStr;
	}
	public boolean isApproveFlag() {
		return approveFlag;
	}
	public void setApproveFlag(boolean approveFlag) {
		this.approveFlag = approveFlag;
	}
	private LeaveApproveEnum(int roleId, String approveStr, boolean approveFlag) {
		this.roleId = roleId;
		this.approveStr = approveStr;
		this.approveFlag = approveFlag;
	}
	
	public static LeaveApproveEnum getId(int roleId,boolean approveFlag){
		LeaveApproveEnum[] values = values();
		for(LeaveApproveEnum leaveEnum : values){
			if(leaveEnum.getRoleId() == roleId && leaveEnum.isApproveFlag() == approveFlag ){
				return leaveEnum;
			}
		}
		return null;
	}
	
}
