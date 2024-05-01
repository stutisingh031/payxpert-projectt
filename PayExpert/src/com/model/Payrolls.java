package com.model;

public class Payroll {
	// private int payroll_id;
	// private int  pay_period_start_date; 
	 //private int  pay_period_end_date;
	 //private int basic_salary;
	 //private int  overtime_pay;
	 //private int  deductions; 
	 private int net_salary; 
	 @Override
	public String toString() {
		return "Payroll [net_salary=" + net_salary + ", employee_id=" + employee_id + "]";
	}
	public int getNet_salary() {
		return net_salary;
	}
	public void setNet_salary(int net_salary) {
		this.net_salary = net_salary;
	}
	public int getEmployee_id() {
		return employee_id;
	}
	public void setEmployee_id(int employee_id) {
		this.employee_id = employee_id;
	}
	public Payroll() {
		super();
	}
	public Payroll(int net_salary, int employee_id) {
		super();
		this.net_salary = net_salary;
		this.employee_id = employee_id;
	}
	private int employee_id;
	 

}
