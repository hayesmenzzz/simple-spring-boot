package com.seamount.dao.model;

import java.io.Serializable;

public class UserModel implements Serializable {

	private Long id;
	private String name;
	private String password;
	private String phone;
	private Integer categary;
	private Integer delete;

	public void setId(Long id) {
		this.id = id;
	}

	public Long getId() {
		return id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPassword() {
		return password;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getPhone() {
		return phone;
	}

	public void setCategary(Integer categary) {
		this.categary = categary;
	}

	public Integer getCategary() {
		return categary;
	}

	public void setDelete(Integer delete) {
		this.delete = delete;
	}

	public Integer getDelete() {
		return delete;
	}

}