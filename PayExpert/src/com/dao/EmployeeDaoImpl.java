package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.exception.EmployeeNotFoundException;
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
			Performance performance = new Performance(performanceId, presentDays, absentDays, overtimePeriod,efficiency,employee_id);
			list.add(performance);
		}
		DBConnection.dbClose();
		return list;
	}

	@Override
	public List<Payroll> getAllPayrollByEmployeeId(int id) throws SQLException {
		Connection con = DBConnection.dbConnect();
		String sql = "select * from payroll where employee_id = ?";

		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setInt(1, id);
		ResultSet rst = pstmt.executeQuery();
		List<Payroll> list = new ArrayList<>();
		while (rst.next() == true) {
			int payId = rst.getInt("payroll_id");
			String startdate = rst.getString("payPeriodStartDate");
			String enddate = rst.getString("payPeriodEndDate");
			double deductions = rst.getDouble("deductions");
			double basicSalary = rst.getDouble("basicSalary");
			double netSalary = rst.getDouble("netSalary");
			double overtimepay = rst.getDouble("overtimePay");
			double employee_id = rst.getDouble("employee_id");
			
			Payroll payroll = new Payroll(payId,startdate,enddate, deductions,basicSalary, netSalary,overtimepay,employee_id);
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
	public int findEmpByUser(int user_id) throws SQLException ,EmployeeNotFoundException{
		Connection con = DBConnection.dbConnect();
		String sql="select * from user where username=? AND password=? AND role=?";
		//prepare the statement 
		PreparedStatement pstmt = con.prepareStatement(sql);
		//pstmt.setString(1, username);
		//pstmt.setString(2, password);
		//pstmt.setString(3, role);
		ResultSet rst  = pstmt.executeQuery();
		 
		if(rst.next()) {
			int empId = rst.getInt("employee_id");	
			DBConnection.dbClose();
			return empId ;
		}
		else {
			DBConnection.dbClose();
			
		//	return throw new EmployeeNotFoundException("employee not found") ; 
		}
		return 0;
	}

	@Override
	public boolean findOne(double employee_id) {
		// TODO Auto-generated method stub
		return false;
	}

	

	

}
