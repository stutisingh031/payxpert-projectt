package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.exception.EmployeeNotFoundException;
import com.model.Employee;
import com.model.Payroll;
import com.model.Performance;
import com.model.Tax;
import com.utility.DBConnection;

public class EmployeeDaoImpl implements EmployeeDao {

	@Override
	public List<Tax> getAllTaxesByEmployeeId(int id) throws SQLException {
		Connection con = DBConnection.dbConnect();
		String sql = "select * from tax where employee_id = ?";

		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setInt(1, id);
		ResultSet rst = pstmt.executeQuery();
		List<Tax> list = new ArrayList<>();
		while (rst.next() == true) {
			int taxId = rst.getInt("tax_id");
			double taxAmount = rst.getDouble("tax_amount");
			String taxYear = rst.getString("tax_year");
			Tax tax = new Tax(taxId, taxYear, taxAmount);
			list.add(tax);
		}
		DBConnection.dbClose();
		return list;
	}

	@Override
	public List<Performance> getAllPerformanceByEmployeeId(int id) throws SQLException {
		Connection con = DBConnection.dbConnect();
		String sql = "select * from performance where employee_id = ?";

		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setInt(1, id);
		ResultSet rst = pstmt.executeQuery();
		List<Performance> list = new ArrayList<>();
		while (rst.next() == true) {
			int performanceId = rst.getInt("performance_id");
			int presentDays = rst.getInt("present_days");
			int absentDays = rst.getInt("absent_days");
			String overtimePeriod = rst.getString("overtime_period");
			int efficiency = rst.getInt("efficiency");
			int employee_id = rst.getInt("employee_id");
			Performance performance = new Performance(performanceId, presentDays, absentDays, overtimePeriod,
					efficiency, employee_id);
			list.add(performance);
		}
		DBConnection.dbClose();
		return list;
	}

	@Override
	public List<Payroll> getAllPayrollByEmployeeId(int id) throws SQLException {
		Connection con = DBConnection.dbConnect();
		String sql = "select * from payroll where employee_id = ? ";

		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setInt(1, id);
		ResultSet rst = pstmt.executeQuery();
		List<Payroll> list = new ArrayList<>();
		while (rst.next() == true) {
			int payId = rst.getInt("payroll_id");
			String startdate = rst.getString("pay_period_start_date");
			String enddate = rst.getString("pay_period_end_date");
			double deductions = rst.getDouble("basic_salary");
			double basicSalary = rst.getDouble("overtime_pay");
			double netSalary = rst.getDouble("deductions");
			double overtimepay = rst.getDouble("net_salary");
			double employee_id = rst.getDouble("employee_id");

			Payroll payroll = new Payroll(payId, startdate, enddate, deductions, basicSalary, netSalary, overtimepay,
					employee_id);
			list.add(payroll);
		}
		DBConnection.dbClose();
		return list;

	}

	@Override
	public boolean findOne(int id) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int findEmpByUser(int user_id) throws SQLException, EmployeeNotFoundException {
		Connection con = DBConnection.dbConnect();
		String sql = "select * from employee where user_id=?";
		// prepare the statement
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setInt(1, user_id);

		ResultSet rst = pstmt.executeQuery();

		if (rst.next()) {
			int empId = rst.getInt("employee_id");
			DBConnection.dbClose();
			return empId;
		} else {
			DBConnection.dbClose();
			return -1;
		}
	}

	@Override
	public boolean findOne(double employee_id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Employee> findAll() throws SQLException {
		Connection con = DBConnection.dbConnect();
		String sql = "select * from employee";

		PreparedStatement pstmt = con.prepareStatement(sql);

		ResultSet rst = pstmt.executeQuery();
		List<Employee> list = new ArrayList<>();
		while (rst.next() == true) {
			int empID = rst.getInt("employee_id");
			String name = rst.getString("name");	
			double salary = rst.getDouble("");

			Employee emp = new Employee(empID, name);
			list.add(emp);
		}
		DBConnection.dbClose();
		return list;

	}

}
