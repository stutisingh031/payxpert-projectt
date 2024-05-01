package com.dao;

import java.sql.SQLException;
import java.util.List;
import com.exception.ResourceNotFoundException;
import com.dto.Employeedto;
import com.dto.Financialdto;
import com.model.Financial;


public interface FinancialDao {

	//get all employee
	List<Financial> getAllrecords() throws SQLException;
	
	//delete
	void deleteByid(int employee_id)throws SQLException,ResourceNotFoundException;
	
	// Financial records of employee
	List<Financial> getRecordOfEmployeeId(int employee_id) throws SQLException;
	boolean findOne(int employee_id) throws SQLException;
	List<Employeedto>findAll() throws SQLException;
	
	//Bonus amount of employee
	List<Financialdto> getBonusAmountEmployee()throws SQLException;
}
