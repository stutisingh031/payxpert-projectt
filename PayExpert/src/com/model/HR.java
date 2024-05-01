package com.model;

public class HR {
	 private int hr_id ;
	 private String name;
	 private String email;
	 private String department;
	 
	 private int User_id;

	 
	public HR() {
		super();
		// TODO Auto-generated constructor stub
	}


	public int getHr_id() {
		return hr_id;
	}


	public void setHr_id(int hr_id) {
		this.hr_id = hr_id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getDepartment() {
		return department;
	}


	public void setDepartment(String department) {
		this.department = department;
	}


	public int getUser_id() {
		return User_id;
	}


	public void setUser_id(int user_id) {
		User_id = user_id;
	}


	@Override
	public String toString() {
		return "User [hr_id=" + hr_id + ", name=" + name + ", email=" + email + ", department=" + department
				+ ", User_id=" + User_id + "]";
	}
	 
	

}
