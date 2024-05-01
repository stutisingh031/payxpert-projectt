package com.dao;

import java.sql.SQLException;
import java.util.List;

import com.exception.EmployeeNotFoundException;
import com.model.Employee;
import com.model.Payroll;
import com.model.Performance;
import com.model.Tax;

public interface EmployeeDao {

	List<Tax> getAllTaxesByEmployeeId(int id) throws SQLException;

	boolean findOne(int id) throws SQLException;

	List<Performance> getAllPerformanceByEmployeeId(int id) throws SQLException;

	List<Payroll> getAllPayrollByEmployeeId(int id) throws SQLException;

	int findEmpByUser(int user_id) throws SQLException , EmployeeNotFoundException;

	boolean findOne(double employee_id);

}
