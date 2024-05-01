package com.dto;

public class HrEmpDto {
	
	private String name;
    private String gender;
    private String email ;
    private String phone_number ;
    
    
	public HrEmpDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public HrEmpDto(String name, String gender, String email, String phone_number) {
		super();
		this.name = name;
		this.gender = gender;
		this.email = email;
		this.phone_number = phone_number;
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

	

	

	@Override
	public String toString() {
		return "HrEmpDto [name=" + name + ", gender=" + gender + ", email=" + email + ", phone_number=" + phone_number
				+ ", net_salary=" +  "]";
	}
    
    

}
