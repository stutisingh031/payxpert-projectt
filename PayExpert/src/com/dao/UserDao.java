package com.dao;
import java.sql.SQLException;
import com.model.User;

public interface UserDao {
	int store(User user) throws SQLException;
	User login(String username, String password, String role) throws SQLException;
	
	

}

