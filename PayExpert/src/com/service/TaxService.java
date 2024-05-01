package com.service;
import java.sql.SQLException;

import com.dto.TaxDto;
import com.dao.TaxDao;
import com.dao.TaxDaoImpl;
import com.exceptions.InvalidInputException;
import com.exceptions.TaxCalculationException;
import com.model.Tax;
public class TaxService {
     TaxDao taxDao = new TaxDaoImpl();

    public Tax retrieveTaxRecord(int taxId) throws SQLException,InvalidInputException {
         Tax tax =taxDao.retrieveTaxRecord(taxId);
         if(tax==null) {
        	 throw new InvalidInputException("Invalid taxId");
         }
       
         return tax;
         }
   

	public Tax retrieveEtaxRecord(int employee_id) throws SQLException,InvalidInputException {
		
		Tax tax = taxDao.retriveEtaxRecord(employee_id);
		if(tax==null) {
       	 throw new InvalidInputException("Invalid Employee_id");
       	 }
		return tax;
	}


	public Tax retriveTaxRec(int taxYear, int eId) throws SQLException, InvalidInputException{
		Tax tax = taxDao.retriveEtaxRecord(taxYear,eId);
		if(tax==null) {
			throw new InvalidInputException("No records found for given year");
		}
		return tax;
	}


	public TaxDto calculateTax(int emId, int tYear) throws SQLException, TaxCalculationException {
		TaxDto taxDto = new TaxDto();
		taxDto = taxDao.calculateTax(emId, tYear);
		if(taxDto==null) {
	
		 throw new TaxCalculationException("Tax calculation error check your inserts");
		 
		}
		return taxDto;
	}
	public double calculateTaxPercent(TaxDto taxDto) {
        double taxPercent = (taxDto.getTaxAmount() / taxDto.getNetSalary()) * 100;
        return taxPercent;
    }
	
}