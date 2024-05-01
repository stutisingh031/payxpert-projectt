package com.dao;

import java.sql.SQLException;
import java.util.List;

import com.exception.EmployeeNotFoundException;
import com.model.Employee;
import com.model.Payroll;
import com.model.Performance;
import com.model.Tax;

public interface EmployeeDao {
	
	List<Tax>getAllTaxesByEmployeeId(int id) throws SQLException;
	boolean findOne(int id)throws SQLException;
	
	List<Performance>getAllPerformanceByEmployeeId(int id) throws SQLException;
	List<Payroll>getAllPayrollByEmployeeId(int id) throws SQLException;
	int save(Employee  employee) throws SQLException;
	void deleteById(int id) throws SQLException,EmployeeNotFoundException;
	void softDeleteById(int id) throws SQLException,EmployeeNotFoundException;
	List<Employee> findAll() throws SQLException;
}
