package com.seamount.dao.model;

import java.io.Serializable;

public class RoleModel implements Serializable{
	
	 
	 	 	private Long roleId;
	 	 	private String roleName;
	 	 	private String roleDes;
	 
			public void setRoleId(Long roleId){
			this.roleId=roleId;
		}
	
	
	    public Long getRoleId(){
          return roleId;
	    }
	
	
			public void setRoleName(String roleName){
			this.roleName=roleName;
		}
	
	
	    public String getRoleName(){
          return roleName;
	    }
	
	
			public void setRoleDes(String roleDes){
			this.roleDes=roleDes;
		}
	
	
	    public String getRoleDes(){
          return roleDes;
	    }
	
	
	
		
}