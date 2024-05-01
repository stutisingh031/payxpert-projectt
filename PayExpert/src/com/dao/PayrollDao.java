package com.dao;

import java.sql.SQLException;
import java.util.List;

import com.dto.PayrollDto;
import com.model.Payroll;

public interface PayrollDao {

	public boolean save(Payroll payroll) throws SQLException;

	public List<PayrollDto> getPayrollStats();

	public List<Payroll> getBasiceSalaryOfEmployee();

	public List<Payroll> getPayrollByEmployeeId();

	public List<Payroll> getAllPayrolls();

	public Payroll findPayrollById();

	public Payroll updatePayroll();

	public double calculateOvertimePay();
}
