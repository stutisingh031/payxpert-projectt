package com.dao;

import java.sql.SQLException;
import com.model.Tax;
import com.dto.TaxDto;
import com.exception.InvalidInputException;
import com.exception.TaxCalculationException;

public interface TaxDao {
	Tax retrieveTaxRecord(int taxId) throws SQLException, InvalidInputException;

	Tax retriveEtaxRecord(int employee_id) throws SQLException, InvalidInputException;

	Tax retriveEtaxRecord(int taxYear, int employeeId) throws SQLException, InvalidInputException;

	TaxDto calculateTax(int employeeId, int taxYear) throws SQLException, TaxCalculationException;
}