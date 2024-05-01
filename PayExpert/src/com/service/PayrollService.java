package com.service;

import java.sql.SQLException;
import java.util.List;

import com.dao.EmployeeDao;
import com.dao.EmployeeDaoImpl;
import com.dao.PayrollDao;
import com.dao.PayrollDaoImpl;
import com.dto.PayrollDto;
import com.exception.ResourceNotFoundException;
import com.model.Employee;
import com.model.Payroll;


public class PayrollService {
	PayrollDao dao = new PayrollDaoImpl();
	EmployeeDao employeeDao = new EmployeeDaoImpl();
	
	
	public void save(Payroll payroll) throws SQLException, ResourceNotFoundException {
		/* 
		 * validate categoryId and artistId given 
		 * */  
		
		//artistId validation
		boolean isEmployeeIdValid = employeeDao.findOne(payroll.getEmployee_id());
		if(!isEmployeeIdValid)
			throw new ResourceNotFoundException();
		
	
		dao.save(payroll);
	}

	public List<Payroll> getPayrollByEmployeeIdId(int employeeId) {
		// TODO Auto-generated method stub
		return dao.getPayrollByEmployeeId();
	}

	public List<PayrollDto> getPayrollStats() throws SQLException {
		return dao.getPayrollStats();
	}

	public List<Payroll> getBasiceSalaryOfEmployee(int employee_Id) {
		// TODO Auto-generated method stub
		return dao.getBasiceSalaryOfEmployee();
	}

	public List<Payroll> getAllPayrolls() {
		// TODO Auto-generated method stub
		return dao.getAllPayrolls();
	}

	public Payroll findPayrollById(int updatePayrollId) {
		// TODO Auto-generated method stub
		return dao.findPayrollById();
	}

	public Payroll updatePayroll(Payroll updatePayroll) {
		// TODO Auto-generated method stub
		return dao.updatePayroll();
	}

	public double calculateOvertimePay(Employee emp) {
		// TODO Auto-generated method stub
		return dao.calculateOvertimePay() ;
	}

}
