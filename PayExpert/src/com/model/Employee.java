package com.model;

public class Employee {
	private int employeeId;
	private String name;
	private String dateOfBirth;
    private String gender;
    private String email;
    private String phoneNumber;
    private String address;
    private String position;
    private String joiningDate;
    private String terminationDate;
    private String userId;
	public Employee(int employee_id, String name, String dateOfBirth, String gender, String email, String phoneNumber,
			String address, String position, String joiningDate, String terminationDate, String userId) {
		super();
		this.employeeId = employee_id;
		this.name = name;
		this.dateOfBirth = dateOfBirth;
		this.gender = gender;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.address = address;
		this.position = position;
		this.joiningDate = joiningDate;
		this.terminationDate = terminationDate;
		this.userId = userId;
	}
	public Employee(int empID, String name) {
		// TODO Auto-generated constructor stub
		this.employeeId = empID;
		this.name = name;
	}
	public int getEmployee_id() {
		return employeeId;
	}
	public void setEmployee_id(int employee_id) {
		this.employeeId = employee_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
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
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
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
	public String getJoiningDate() {
		return joiningDate;
	}
	public void setJoiningDate(String joiningDate) {
		this.joiningDate = joiningDate;
	}
	public String getTerminationDate() {
		return terminationDate;
	}
	public void setTerminationDate(String terminationDate) {
		this.terminationDate = terminationDate;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	@Override
	public String toString() {
		return "Employee [employeeId=" + employeeId + ", name=" + name + "]";
	}
	
	
}
