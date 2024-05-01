package com.model;

public class Payroll {
	
	private int payroll_id;
	private String payPeriodStartDate;
	private String payPeriodEndDate;
	private double basicSalary;
	private double overtimePay;
	private double deductions;
	private double netSalary;
	private double employee_id;
	
	
	public Payroll(int payroll_id, String payPeriodStartDate, String payPeriodEndDate, double basicSalary,
			double overtimePay, double deductions, double netSalary, double employee_id) {
		super();
		this.payroll_id = payroll_id;
		this.payPeriodStartDate = payPeriodStartDate;
		this.payPeriodEndDate = payPeriodEndDate;
		this.basicSalary = basicSalary;
		this.overtimePay = overtimePay;
		this.deductions = deductions;
		this.netSalary = netSalary;
		this.employee_id = employee_id;
	}
	
	
	
	@Override
	public String toString() {
		return "Payroll [payroll_id=" + payroll_id + ", payPeriodStartDate=" + payPeriodStartDate
				+ ", payPeriodEndDate=" + payPeriodEndDate + ", basicSalary=" + basicSalary + ", overtimePay="
				+ overtimePay + ", deductions=" + deductions + ", netSalary=" + netSalary + ", employee_id="
				+ employee_id + "]";
	}



	public Payroll() {
		super();
		// TODO Auto-generated constructor stub
	}



	public int getPayroll_id() {
		return payroll_id;
	}
	public void setPayroll_id(int payroll_id) {
		this.payroll_id = payroll_id;
	}
	public String getPayPeriodStartDate() {
		return payPeriodStartDate;
	}
	public void setPayPeriodStartDate(String payPeriodStartDate) {
		this.payPeriodStartDate = payPeriodStartDate;
	}
	public String getPayPeriodEndDate() {
		return payPeriodEndDate;
	}
	public void setPayPeriodEndDate(String payPeriodEndDate) {
		this.payPeriodEndDate = payPeriodEndDate;
	}
	public double getBasicSalary() {
		return basicSalary;
	}
	public void setBasicSalary(double basicSalary) {
		this.basicSalary = basicSalary;
	}
	public double getOvertimePay() {
		return overtimePay;
	}
	public void setOvertimePay(double overtimePay) {
		this.overtimePay = overtimePay;
	}
	public double getDeductions() {
		return deductions;
	}
	public void setDeductions(double deductions) {
		this.deductions = deductions;
	}
	public double getNetSalary() {
		return netSalary;
	}
	public void setNetSalary(double netSalary) {
		this.netSalary = netSalary;
	}
	public double getEmployee_id() {
		return employee_id;
	}
	public void setEmployee_id(double employee_id) {
		this.employee_id = employee_id;
	}

}
