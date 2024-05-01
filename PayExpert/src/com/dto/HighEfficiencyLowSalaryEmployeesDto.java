package com.dto;

public class HighEfficiencyLowSalaryEmployeesDto {
	private String name;
	private String position;
	private int efficiency;
	private double net_salary;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}
	public int getEfficiency() {
		return efficiency;
	}
	public void setEfficiency(int efficiency) {
		this.efficiency = efficiency;
	}
	public double getNet_salary() {
		return net_salary;
	}
	public void setNet_salary(double net_salary) {
		this.net_salary = net_salary;
	}
	public HighEfficiencyLowSalaryEmployeesDto(String name, String position, int efficiency, double net_salary) {
		super();
		this.name = name;
		this.position = position;
		this.efficiency = efficiency;
		this.net_salary = net_salary;
	}
	public HighEfficiencyLowSalaryEmployeesDto() {
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "HighEfficiencyLowSalaryEmployeesDto [name=" + name + ", position=" + position + ", efficiency="
				+ efficiency + ", net_salary=" + net_salary + "]";
	}
	
}
