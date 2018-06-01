package com.seamount.leaveprocess;

public enum LeaveProcessRunStateEnum {

	LEAVE_APPLY(2,"leaveApply","leaveApplyRole"),
	LEADER_REVIEW(3,"leaderReview","leaderReviewRole"),
	MANAGER_REVIEW(4,"managerApproval","managerReviewRole"),
	COMPLETE(0,"complete","processComplete"),
	CLOSE_PROCESS(-1,"close_process","closeProcess");
	
	private int state;
	private String processState;//流程状态  每个节点的  taskName
	private String roleName;//需要有这个角色权限的人才可以操作该流程状态
	public int getId() {
		return state;
	}
	
	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}

	public String getProcessState() {
		return processState;
	}

	public void setProcessState(String processState) {
		this.processState = processState;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	
	private LeaveProcessRunStateEnum(int state, String processState, String roleName) {
		this.state = state;
		this.processState = processState;
		this.roleName = roleName;
	}

	public static LeaveProcessRunStateEnum queryByProcessState(String processState) {
		LeaveProcessRunStateEnum[] values = values();
		for(LeaveProcessRunStateEnum leaveEnum : values){
			if(leaveEnum.getProcessState().equals(processState)){
				return leaveEnum;
			}
		}
		return null;
	}
	
}
