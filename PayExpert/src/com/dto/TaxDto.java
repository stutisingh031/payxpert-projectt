package com.dto;


public class TaxDto {
	private int employeeId;
	private double netSalary;
	private int taxAmount;
	private int taxYear;
	public TaxDto(int employeeId, double netSalary, int taxAmount, int taxYear) {
		super();
		this.employeeId = employeeId;
		this.netSalary = netSalary;
		this.taxAmount = taxAmount;
		this.taxYear = taxYear;
		
	}
	public TaxDto() {
		super();
	}
	public int getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}
	public double getNetSalary() {
		return netSalary;
	}
	public void setNetSalary(double netSalary) {
		this.netSalary = netSalary;
	}
	public int getTaxAmount() {
		return taxAmount;
	}
	public void setTaxAmount(int taxAmount) {
		this.taxAmount = taxAmount;
	}
	public int getTaxYear() {
		return taxYear;
	}
	public void setTaxYear(int taxYear) {
		this.taxYear = taxYear;
	}
	
	@Override
	public String toString() {
		return "TaxDto [employeeId=" + employeeId + ", netSalary=" + netSalary + ", taxAmount=" + taxAmount
				+ ", taxYear=" + taxYear + "]";
	}
	
	
	
}