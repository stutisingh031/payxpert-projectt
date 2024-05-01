package com.dto;

public class PayrollDto {

	private String name;
	private double netSalary;
	
	@Override
	public String toString() {
		return "PayrollDto [name=" + name + ", netSalary=" + netSalary + "]";
	}
	public PayrollDto(String name, double netSalary) {
		super();
		this.name = name;
		this.netSalary = netSalary;
	}
	public double getNetSalary() {
		return netSalary;
	}
	public void setNetSalary(double netSalary) {
		this.netSalary = netSalary;
	} 
	
	
	
	

}
