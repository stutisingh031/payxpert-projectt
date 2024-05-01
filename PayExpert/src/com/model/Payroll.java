package com.model;

public class Payroll {
	private int payrollId;
    
	private String payPeriodStartDate;
    private String payPeriodEndDate;
    private double basicSalary;
    private double overtimePay;
    private double deductions;
    private double netSalary;
   
	public Payroll(int payrollId, String payPeriodStartDate, String payPeriodEndDate, double basicSalary,
			double overtimePay, double deductions, double netSalary) {
		super();
		this.payrollId = payrollId;
		this.payPeriodStartDate = payPeriodStartDate;
		this.payPeriodEndDate = payPeriodEndDate;
		this.basicSalary = basicSalary;
		this.overtimePay = overtimePay;
		this.deductions = deductions;
		this.netSalary = netSalary;
	}
	public int getPayrollId() {
		return payrollId;
	}
	public void setPayrollId(int payrollId) {
		this.payrollId = payrollId;
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
	public Payroll() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	
	@Override
	public String toString() {
		return "Payroll [payrollId=" + payrollId + ", basicSalary=" + basicSalary + ", deductions=" + deductions
				+ ", netSalary=" + netSalary + "]";
	}
	public Payroll(int payrollId, double basicSalary, double deductions, double netSalary) {
		super();
		this.payrollId = payrollId;
		this.basicSalary = basicSalary;
		this.deductions = deductions;
		this.netSalary = netSalary;
	}
}
