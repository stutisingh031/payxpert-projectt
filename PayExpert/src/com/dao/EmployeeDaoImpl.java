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
	public boolean findOne(int id) throws SQLException {
		// TODO Auto-generated method stub
		return false;
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
			int employee_id = rst.getInt("ëmployee_id");
			Performance performance = new Performance(performanceId, presentDays, absentDays, overtimePeriod, efficiency,employee_id);
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
			double deductions = rst.getDouble("deductions");
			double basicSalary = rst.getDouble("basic_salary");
			double netSalary = rst.getDouble("net_salary");
			Payroll payroll = new Payroll(payId, basicSalary, deductions, netSalary);
			list.add(payroll);
		}
		DBConnection.dbClose();
		return list;

	}

	@Override
	public int save(Employee employee) throws SQLException {
		Connection con = DBConnection.dbConnect();
		String sql="INSERT INTO  Employee(employee_id , name,date_of_birth,gender,email,"
				+ "phone_number,address,position,joining_date,termination_date, user_id) VALUES"
				+ " (?,?,?,?,?,?,?,?,?,?)";
		//prepare the statement 
		PreparedStatement pstmt = con.prepareStatement(sql);
		//attach the data
		pstmt.setInt  (1,  employee.getEmployee_id());
		pstmt.setString(2, employee.getName());
		pstmt.setString(3, employee.getDateOfBirth());
		pstmt.setString(4, employee.getGender());
		pstmt.setString(5, employee.getEmail());
		pstmt.setString(6, employee.getPhoneNumber());
		pstmt.setString(7, employee.getAddress());
		pstmt.setString(8, employee.getPosition());
		pstmt.setString(9, employee.getJoiningDate());
		pstmt.setString(10, employee.getTerminationDate());
		pstmt.setString(11, employee.getUser_Id());
		
		int status = pstmt.executeUpdate(); 
		DBConnection.dbClose();
		return status;
		
	}

	@Override
	public void deleteById(int id) throws SQLException {
	Connection con = DBConnection.dbConnect();
	String sql="delete from employee where employeeID =?";
	//prepare the statement 
	PreparedStatement pstmt = con.prepareStatement(sql);
	pstmt.setInt(1, id);
	pstmt.executeUpdate();
	DBConnection.dbClose();// TODO Auto-generated method stub
		
	}

	@Override
	public void softDeleteById(int id) throws SQLException, EmployeeNotFoundException {
		Connection con = DBConnection.dbConnect();
		String sql="update employee set is_active = 'no'  where employee_id =?";
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setInt(1, id);
		pstmt.executeUpdate();
		DBConnection.dbClose();	
		
	}

	@Override
	public List<Employee> findAll() throws SQLException {
		Connection con = DBConnection.dbConnect();
		String sql="select * from employee where is_active = 'yes'";
		PreparedStatement pstmt = con.prepareStatement(sql);
		
		ResultSet rst = pstmt.executeQuery();
		List<Employee> list = new ArrayList<>();
		while(rst.next() == true) {
			int employeeId  = rst.getInt("employee_id");
			String name = rst.getString("name");
			String dateOfBirth = rst.getString("date_of_birth");	
			String gender = rst.getString("gender");
			String email = rst.getString("email");
			String phoneNumber = rst.getString("phone_number");
			String address = rst.getString("address");
			String position = rst.getString("position");
			String joiningDate = rst.getString("joining_date");
			String terminationDate = rst.getString("termination_date");
			String userId = rst.getString("user_id");
			Employee employee = new Employee(employeeId,  name,  dateOfBirth,  gender,  email,  phoneNumber,
					 address,  position,  joiningDate,  terminationDate,  userId); //100X 200X 300X
			list.add(employee);
		}
		DBConnection.dbClose();		
		return list;
		
	}

	
		
	}

