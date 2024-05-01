package com.service;

import java.sql.SQLException;
import java.util.List;

import com.dao.EmployeeDao;
import com.dao.EmployeeDaoImpl;
import com.exception.EmployeeNotFoundException;
import com.model.Employee;
import com.model.Payroll;
import com.model.Performance;
import com.model.Tax;

public class EmployeeService {

	EmployeeDao employeeDao = new EmployeeDaoImpl();

	public List<Tax> showTaxes(int id) throws SQLException {
		// TODO Auto-generated method stub
		return employeeDao.getAllTaxesByEmployeeId(id);

	}

	public List<Payroll> showPayroll(int id) throws SQLException {
		
		return employeeDao.getAllPayrollByEmployeeId(id);

	}

	public List<Performance> showPerformance(int id) throws SQLException {
		// TODO Auto-generated method stub
		return employeeDao.getAllPerformanceByEmployeeId(id);
	}

	public int findEmpByUser(int user_id) throws SQLException, EmployeeNotFoundException{
		// TODO Auto-generated method stub
		return employeeDao.findEmpByUser(user_id) ;
	}

	public List<Employee> findAll() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	
	
	

	
}
