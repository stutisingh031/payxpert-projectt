package com.model;

public class Taxs {
	 private  int taxId ;     
	 private  String taxYear ;   
	 private  double taxAmount;
	public int getTaxId() {
		return taxId;
		
	}
	public Taxs() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Taxs(int taxId, String taxYear, double taxAmount) {
		super();
		this.taxId = taxId;
		this.taxYear = taxYear;
		this.taxAmount = taxAmount;
	}
	public String getTaxYear() {
		return taxYear;
	}
	public void setTaxYear(String taxYear) {
		this.taxYear = taxYear;
	}
	public double getTaxAmount() {
		return taxAmount;
	}
	public void setTaxAmount(double taxAmount) {
		this.taxAmount = taxAmount;
	}
	public void setTaxId(int taxId) {
		this.taxId = taxId;
	}
	@Override
	public String toString() {
		return "Taxs [taxId=" + taxId + ", taxYear=" + taxYear + ", taxAmount=" + taxAmount + ", getTaxId()="
				+ getTaxId() + ", getTaxYear()=" + getTaxYear() + ", getTaxAmount()=" + getTaxAmount() + ", getClass()="
				+ getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}
	
}