package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.model.Financial;
import com.dto.Employeedto;
import com.dto.Financialdto;
import com.utility.DBConnection;


public class FinancialDaoImpl implements FinancialDao {
	

	//display all data of financial record table
	@Override
	public List<Financial> getAllrecords() throws SQLException {
		    Connection con = (Connection) DBConnection.dbConnect();
		    String sql="select *"
				  + "from financial_record";
		    PreparedStatement pstmt =  con.prepareStatement(sql);
		    ResultSet rst = pstmt.executeQuery();
		    List<Financial> list = new ArrayList<>();
		
		while(rst.next() == true) {
			 int record_id=rst.getInt("record_id");
			 String record_date=rst.getString("record_date");
			 String description=rst.getString("description");
			 double amount=rst.getDouble("amount");
			 String record_type=rst.getString("record_type");
		     int employee_id=rst.getInt("employee_id");
		     
		     Financial financial=new Financial(record_id,record_date,description,amount,record_type,employee_id);
		     list.add(financial);
		}
		
		DBConnection.dbClose();	
		return list;
	}
		

	// display all employee
	@Override
	public List<Employeedto> findAll() throws SQLException {
		
		    Connection con = (Connection) DBConnection.dbConnect();
		    String sql="select * from employee";
		    PreparedStatement pstmt = con.prepareStatement(sql);
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
	public boolean findOne(int employee_id) throws SQLException {
		Connection con = DBConnection.dbConnect();
		String sql= "select employee_id from employee where employee_id=?";
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setInt(1, (int) employee_id);
		ResultSet rst  = pstmt.executeQuery();
		boolean status = rst.next();
		DBConnection.dbClose();
		return status;
	}

// Bonus amount of employee
	@Override
	public List<Financialdto> getBonusAmountEmployee() throws SQLException {
		   Connection con = (Connection) DBConnection.dbConnect();
		   String sql="select * "
				    + " from financial_record f JOIN employee e ON f.employee_id=e.employee_id"
				    + " where f.record_type='bonus'";
		    PreparedStatement pstmt = (PreparedStatement) con.prepareStatement(sql);
		    ResultSet rst = pstmt.executeQuery();
		    List<Financialdto> list = new ArrayList<>();
		while(rst.next() == true) {
			
			String name = rst.getString("name");
		    int amount = rst.getInt("amount");
			String recordType = rst.getString("record_type");
			
			Financialdto Record=new Financialdto(name,amount,recordType);
			list.add(Record);
		}
		
		DBConnection.dbClose();	
		return list;
	}

// deletion

	@Override
	public void deleteByid(int employee_id) throws SQLException{
		Connection con = (Connection) DBConnection.dbConnect();
		String sql="delete from artists where employee_id =?";
		PreparedStatement pstmt = (PreparedStatement) con.prepareStatement(sql);
		pstmt.setInt(1, employee_id);
		pstmt.executeUpdate();
		DBConnection.dbClose();

		
	}


@Override
public List<Financial> getRecordOfEmployeeId(int employee_id) throws SQLException {
	 Connection con =  DBConnection.dbConnect();
     String sql="select * from financial_record where employee_id=?";
      PreparedStatement pstmt = con.prepareStatement(sql);
      pstmt.setInt(1,employee_id);
      ResultSet rst = pstmt.executeQuery();
      List<Financial> list = new ArrayList<>();

while(rst.next() == true) {
	
	int record_id=rst.getInt("record_id");
	String record_date=rst.getString("record_date");
	String description=rst.getString("description"); 
	double amount=rst.getDouble("amount");
	String record_type=rst.getString("record_type");
	// employee_id=rst.getInt("employee_id");
	   
	   
	   Financial employee=new Financial( record_id,  record_date, description,  amount,  record_type,employee_id);
	   list.add(employee);
}
      DBConnection.dbClose();		
      return list;

}
	
}
