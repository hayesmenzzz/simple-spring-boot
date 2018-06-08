package com.seamount.dao.model;

import java.io.Serializable;

public class UserRoleModel implements Serializable{
	
	 
	 	 	private Long userId;
	 	 	private Integer roleId;
	 
			public void setUserId(Long userId){
			this.userId=userId;
		}
	
	
	    public Long getUserId(){
          return userId;
	    }
	
	
			public void setRoleId(Integer roleId){
			this.roleId=roleId;
		}
	
	
	    public Integer getRoleId(){
          return roleId;
	    }
	
	
	
		
}