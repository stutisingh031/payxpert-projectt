package com.model;

public class Financial {
	
	private int record_id;
	private String record_date;
	private String description;
	private double amount;
	private String record_type;
	private int employee_id;
	
	
	public int getRecord_id() {
		return record_id;
	}
	public void setRecord_id(int record_id) {
		this.record_id = record_id;
	}
	public String getRecord_date() {
		return record_date;
	}
	public void setRecord_date(String record_date) {
		this.record_date = record_date;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public String getRecord_type() {
		return record_type;
	}
	public void setRecord_type(String record_type) {
		this.record_type = record_type;
	}
	public int getEmployee_id() {
		return employee_id;
	}
	public void setEmployee_id(int employee_id) {
		this.employee_id = employee_id;
	}
	@Override
	public String toString() {
		return "Financial [record_id=" + record_id + ", record_date=" + record_date + ", description=" + description
				+ ", amount=" + amount + ", record_type=" + record_type + ", employee_id=" + employee_id + "]";
	}
	
	public Financial() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Financial(int record_id, String record_date, String description, double amount, String record_type,
			int employee_id) {
		super();
		this.record_id = record_id;
		this.record_date = record_date;
		this.description = description;
		this.amount = amount;
		this.record_type = record_type;
		this.employee_id = employee_id;
	}
	
}
