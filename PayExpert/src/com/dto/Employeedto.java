package com.dto;

public class Employeedto {
	
	  private int employee_id;
	  private String name;
      private String gender;
      private String email ;
      private String phone_number ;
      private String address ;
      private String position;
      private int user_id ;
      
	public Employeedto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Employeedto(int employee_id, String name, String gender, String email, String phone_number, String address,
			String position, int user_id) {
		super();
		this.employee_id = employee_id;
		this.name = name;
		this.gender = gender;
		this.email = email;
		this.phone_number = phone_number;
		this.address = address;
		this.position = position;
		this.user_id = user_id;
	}

	public int getEmployee_id() {
		return employee_id;
	}

	public void setEmployee_id(int employee_id) {
		this.employee_id = employee_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone_number() {
		return phone_number;
	}

	public void setPhone_number(String phone_number) {
		this.phone_number = phone_number;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	@Override
	public String toString() {
		return "Employeedto [employee_id=" + employee_id + ", name=" + name + ", gender=" + gender + ", email=" + email
				+ ", phone_number=" + phone_number + ", address=" + address + ", position=" + position + ", user_id="
				+ user_id + "]";
	}
      
      
      
      
	
}
