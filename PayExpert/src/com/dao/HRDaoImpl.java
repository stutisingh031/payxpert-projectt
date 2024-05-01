package com.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.dto.Employeedto;
import com.dto.HrEmpDto;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.utility.DBConnection;

public class HRDaoImpl implements HRDao{

	@Override
	public List<Employeedto> getAllemployee() throws SQLException {
		Connection con = (Connection) DBConnection.dbConnect();
	    String sql="select * from employee";
	    PreparedStatement pstmt = (PreparedStatement) con.prepareStatement(sql);
	    ResultSet rst = pstmt.executeQuery();
	    List<Employeedto> list = new ArrayList<>();
	while(rst.next() == true) {
		
		 int employee_id = rst.getInt("employee_id");
		 String name = rst.getString("name");
	     String gender = rst.getString("gender");
	     String email = rst.getString("email");
	     String phone_number = rst.getString("phone_number");
	     String address = rst.getString("address");
	     String position = rst.getString("position");
	     int user_id = rst.getInt("user_id");
	  
	     Employeedto employee = new Employeedto(employee_id,name,gender,email,phone_number,address,position,user_id);	
	     list.add(employee);
	}
	
	DBConnection.dbClose();	
	return list;
	}

	@Override
	public List<HrEmpDto> getSalary() throws SQLException {
		Connection con = (Connection) DBConnection.dbConnect();
		String sql=" select e.name,e.gender,e.email,e.phone_number"
				+ " from employee e"
				+ "  where e.employee_id NOT IN (select p.employee_id from payroll p)";
		PreparedStatement pstmt = (PreparedStatement) con.prepareStatement(sql);
	    ResultSet rst = pstmt.executeQuery();
	    List<HrEmpDto> list = new ArrayList<>();
	    while(rst.next() == true) {
			
	    	String name=rst.getString("name");
	    	String gender=rst.getString("gender");
	    	String email =rst.getString("email");
	    	String phone_number =rst.getString("phone_number");
	    	 
	    	 HrEmpDto salary=new HrEmpDto(name,gender,email,phone_number);
	    	 list.add(salary);
	    }
		
		DBConnection.dbClose();	
		return list;
	}

	@Override
	public List<Employeedto> getOInName() throws SQLException {
		Connection con = (Connection) DBConnection.dbConnect();
	    String sql=" select* "
	    		+ " from employee"
	    		+ " where name like '%o%'";
	    PreparedStatement pstmt = (PreparedStatement) con.prepareStatement(sql);
	    ResultSet rst = pstmt.executeQuery();
	    List<Employeedto> list = new ArrayList<>();
	while(rst.next() == true) {
		
		 int employee_id = rst.getInt("employee_id");
		 String name = rst.getString("name");
	     String gender = rst.getString("gender");
	     String email = rst.getString("email");
	     String phone_number = rst.getString("phone_number");
	     String address = rst.getString("address");
	     String position = rst.getString("position");
	     int user_id = rst.getInt("user_id");
	  
	     Employeedto employee = new Employeedto(employee_id,name,gender,email,phone_number,address,position,user_id);	
	     list.add(employee);
	}
	
	DBConnection.dbClose();	
	return list;
	}	
	}



		
