package com.dto;

public class PerformanceDto {
	private String name;
	private String email;
	private int efficiency;
	public PerformanceDto() {
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "PerformanceDto [name=" + name + ", email=" + email + ", efficiency=" + efficiency + "]";
	}
	public PerformanceDto(String name, String email, int efficiency) {
		super();
		this.name = name;
		this.email = email;
		this.efficiency = efficiency;
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
	public int getEfficiency() {
		return efficiency;
	}
	public void setEfficiency(int efficiency) {
		this.efficiency = efficiency;
	}

}

