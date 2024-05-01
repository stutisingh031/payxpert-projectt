package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.dto.PayrollDto;
import com.model.Payroll;
import com.utility.DBConnection;

public class PayrollDaoImpl implements PayrollDao {
	
	@Override
	public  boolean  save(Payroll payroll) throws SQLException {
		// insert artist record in DB
		Connection con = DBConnection.dbConnect();
		String sql="INSERT INTO payroll(payroll_id, PayPeriodStartDate, PayPeriodEndDate, BasicSalary,Deductions,OvertimePay,employee_id) "
				+ " VALUES (?,?,?,?,?,?)";
		//prepare the statement 
		PreparedStatement pstmt = con.prepareStatement(sql);
		//attach the data
		pstmt.setInt(1, payroll.getPayroll_id());
		pstmt.setString(2, payroll.getPayPeriodStartDate());
		pstmt.setString(3, payroll.getPayPeriodEndDate());
		pstmt.setDouble(4, payroll.getEmployee_id());
		pstmt.setDouble(5, payroll.getBasicSalary());
		pstmt.setDouble(6, payroll.getDeductions());
		pstmt.setDouble(7, payroll.getNetSalary());
		pstmt.setDouble(8, payroll.getOvertimePay());
		
		
		//execute the query 
	    boolean  status = pstmt.executeUpdate()==1?true:false; //1: if all good., 0 - if op fails 
		DBConnection.dbClose();
		return status;		
	}
	
	 public static List<PayrollDto> findEmployeesWithNetSalaryGreaterThan60000throws() throws SQLException {
		    Connection con = DBConnection.dbConnect();
	        List<PayrollDto> resultList = new ArrayList<>();
	        String sql = "SELECT * FROM payroll p JOIN employee e ON p.employee_id = e.employee_id WHERE p.net_salary > 60000";
	        try (PreparedStatement pstmt = con.prepareStatement(sql);
	             ResultSet rst = pstmt.executeQuery()) {
	            while (rst.next()) {
	                String name= rst.getString("name");
	                double netSalary = rst.getDouble("net_salary");
	                PayrollDto p = new PayrollDto(name,netSalary);
	                resultList.add(p);
	            }
	        }
	        return resultList;
	    }

	    public static void getEmployeeNamesWithPayrollInformation() throws SQLException {
	    	Connection con = DBConnection.dbConnect();
	    	String sql ="SELECT p.*, e.employee_name FROM payroll p INNER JOIN employees e ON p.employee_id = e.employee_id";
	    	PreparedStatement pstmt = con.prepareStatement(sql);
	    	ResultSet rst = pstmt.executeQuery();

	        while (rst.next()) {
	            int employeeId = rst.getInt("employee_id");
	            String employeeName = rst.getString("employee_name");
	            double netSalary = rst.getDouble("net_salary");
	            System.out.println("Employee ID: " + employeeId + ", Employee Name: " + employeeName + ", Net Salary: " + netSalary);
	        }

	       return ;
	    }

	    public static void calculateAverageNetSalaryByDepartment(Connection conn) throws SQLException {
	    	Connection con = DBConnection.dbConnect();
	    	String sql = "SELECT e.department, AVG(p.net_salary) AS avg_net_salary FROM payroll p INNER JOIN employees e ON p.employee_id = e.employee_id GROUP BY e.department";
	    	PreparedStatement pstmt = con.prepareStatement(sql);
	    	ResultSet rst = pstmt.executeQuery();

	        while (rst.next()) {
	            String department = rst.getString("department");
	            double avgNetSalary = rst.getDouble("avg_net_salary");
	            System.out.println("Department: " + department + ", Average Net Salary: " + avgNetSalary);
	        }

	        rst.close();
	        pstmt.close();
	    }

	    public static void listPayrollRecordsByNetSalaryDescendingOrder(Connection conn) throws SQLException {
	    	Connection con = DBConnection.dbConnect();
	    	String sql = "SELECT * FROM payroll ORDER BY net_salary DESC";
	    	PreparedStatement pstmt = con.prepareStatement(sql);
	    	ResultSet rst = pstmt.executeQuery();

	        while (rst.next()) {
	            int employeeId = rst.getInt("employee_id");
	            double netSalary = rst.getDouble("net_salary");
	            System.out.println("Employee ID: " + employeeId + ", Net Salary: " + netSalary);
	        }

	        rst.close();
	        pstmt.close();
	    }

	    public static void findEmployeesWithOvertimePayGreaterThanDeductions(Connection conn) throws SQLException {
	    	Connection con = DBConnection.dbConnect();
	    	String sql = "SELECT * FROM payroll WHERE overtime_pay > deductions";
	    	PreparedStatement pstmt = con.prepareStatement(sql);
	    	ResultSet rst = pstmt.executeQuery();

	        while (rst.next()) {
	            int employeeId = rst.getInt("employee_id");
	            double overtimePay = rst.getDouble("overtime_pay");
	            double deductions = rst.getDouble("deductions");
	            System.out.println("Employee ID: " + employeeId + ", Overtime Pay: " + overtimePay + ", Deductions: " + deductions);
	        }

	        rst.close();
	        pstmt.close();
	    }

		@Override
		public List<PayrollDto> getPayrollStats() {
			
			return null;
		}

		@Override
		public List<Payroll> getBasiceSalaryOfEmployee() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public List<Payroll> getPayrollByEmployeeId() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public List<Payroll> getAllPayrolls() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public Payroll findPayrollById() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public Payroll updatePayroll() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public double calculateOvertimePay() {
			// TODO Auto-generated method stub
			return 0;
		}
    }

	
	


