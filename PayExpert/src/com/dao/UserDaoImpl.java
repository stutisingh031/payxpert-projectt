package com.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.model.User;
import com.utility.DBConnection;



public class UserDaoImpl implements UserDao{

	@Override
	public int store(User user) throws SQLException {
		Connection con = DBConnection.dbConnect();
		String sql = " Insert into User(User_id, UserName, Password, Role) values (?,?,?,?)";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setInt(1, user.getUser_id());
		ps.setString(2, user.getUsername());
		ps.setString(3, user.getPassword());
		ps.setString(4, user.getRole());
		int status = ps.executeUpdate();
		DBConnection.dbClose();
		return status;
	}
	 //override

	@Override
	public User login(String username, String password, String role) throws SQLException {
		Connection con = DBConnection.dbConnect();
		String sql="select * from user where username=? AND password=? AND role=?";
		//prepare the statement 
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setString(1, username);
		pstmt.setString(2, password);
		pstmt.setString(3, role);
		ResultSet rst  = pstmt.executeQuery();
		 
		if(rst.next()) {
			User user = new User();
			user.setUser_id(rst.getInt("user_id"));
			user.setUsername(username);
			user.setPassword(password);
			user.setRole(role);
			DBConnection.dbClose();
			return user;
		}
		else {
			DBConnection.dbClose();
			return null; 
		}
	}
	
}
