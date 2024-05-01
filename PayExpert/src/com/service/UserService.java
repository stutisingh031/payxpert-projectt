package com.service;

import java.sql.SQLException;

import com.dao.UserDao;
import com.dao.UserDaoImpl;
import com.exception.InvalidCredentialsException;
import com.model.User;

public class UserService {

	UserDao userDao = new UserDaoImpl();

	public int insert(User user) throws SQLException {
		return userDao.store(user);
		
		
	}

	public User login(String username, String password,String role) throws SQLException, InvalidCredentialsException {
		 
		User user = userDao.login(username,password,role);
		if(user == null) {
			throw new InvalidCredentialsException("Invalid Credentials");
		}
		return user;
	}
	
	
}
