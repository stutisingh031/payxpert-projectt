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
	public int insert(Employee employee) throws SQLException {
		return employeeDao.save(employee);
	}
	public void deleteByid(int id) throws SQLException, EmployeeNotFoundException {
		boolean isIdValid = employeeDao.findOne(id);
		if(!isIdValid)
			throw new EmployeeNotFoundException("Id given is Invalid!!");
		 
		employeeDao.deleteById(id);
	}
	public void softDeleteByid(int id) throws EmployeeNotFoundException, SQLException {
		boolean isIdValid = employeeDao.findOne(id);
		if(!isIdValid)
			throw new EmployeeNotFoundException("Id given is Invalid!!");
		 
		employeeDao.softDeleteById(id);
		
	}
	
	public List<Employee> findAll() throws SQLException {
		return employeeDao.findAll();
	}

	
}
