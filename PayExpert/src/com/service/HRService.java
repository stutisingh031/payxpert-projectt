package com.service;

import java.sql.SQLException;
import java.util.List;

import com.dto.HrEmpDto;
import com.dao.HRDao;
import com.dao.HRDaoImpl;

import com.dto.Employeedto;

public class HRService {
	
	 HRDao dao=new HRDaoImpl();
	
	// display all employee
	 public List<Employeedto> getAllemployee() throws SQLException{
		return dao.getAllemployee();
	}

//get salary
	public List<HrEmpDto> getSalary() throws SQLException{
		
		return dao.getSalary();
	}

	public List<Employeedto> getOInName() throws SQLException{
		return dao.getOInName();
	}
	

	
}