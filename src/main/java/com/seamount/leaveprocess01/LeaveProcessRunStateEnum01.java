package com.seamount.leaveprocess01;

public enum LeaveProcessRunStateEnum01 {

	TASK1(1,"task1","employee"),
	TASK2(2,"task2","leader"),
	TASK3(3,"task3","manager"),
	TASK4(4,"task4","chairman"),
	TASK5(5,"task5","hr"),
	REJECT(-1,"reject","processReject"),
	GOBACK(-2,"return","processReturn"),
	COMPLETE(0,"complete","processComplete");
	
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

	
	private LeaveProcessRunStateEnum01(int state, String processState, String roleName) {
		this.state = state;
		this.processState = processState;
		this.roleName = roleName;
	}

	public static LeaveProcessRunStateEnum01 queryByProcessState(String processState) {
		LeaveProcessRunStateEnum01[] values = values();
		for(LeaveProcessRunStateEnum01 leaveEnum : values){
			if(leaveEnum.getProcessState().equals(processState)){
				return leaveEnum;
			}
		}
		return null;
	}
	
}
