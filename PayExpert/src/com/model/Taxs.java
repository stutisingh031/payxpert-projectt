package com.model;

public class Tax {
	 private  int taxId ;     
	 private  String taxYear ;   
	 private  double taxAmount;
	public int getTaxId() {
		return taxId;
	}
	public void setTaxId(int taxId) {
		this.taxId = taxId;
	}
	public Tax() {
		
		// TODO Auto-generated constructor stub
	}
	public String getTaxYear() {
		return taxYear;
	}
	public void setTaxYear(String taxYear) {
		this.taxYear = taxYear;
	}
	@Override
	public String toString() {
		return "Tax [taxId=" + taxId + ", taxYear=" + taxYear + ", taxAmount=" + taxAmount + "]";
	}
	public double getTaxAmount() {
		return taxAmount;
	}
	public void setTaxAmount(double taxAmount) {
		this.taxAmount = taxAmount;
	}
	public Tax(int taxId, String taxYear, double taxAmount) {
		super();
		this.taxId = taxId;
		this.taxYear = taxYear;
		this.taxAmount = taxAmount;
	}  
	 

}
