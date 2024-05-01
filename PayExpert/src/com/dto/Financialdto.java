package com.dto;

public class Financialdto {
	private String name;
	private int amount;
	private String record_type;
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public String getRecordType() {
		return record_type;
	}
	public void setRecordType(String recordType) {
		this.record_type = recordType;
	}
	@Override
	public String toString() {
		return "Financialdto [name=" + name + ", amount=" + amount + ", recordType=" + record_type + "]";
	}
	public Financialdto(String name, int amount, String recordType) {
		super();
		this.name = name;
		this.amount = amount;
		this.record_type = recordType;
	}
	public Financialdto() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

}
