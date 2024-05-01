package com.dao;

import java.sql.SQLException;
import java.util.List;

import com.dto.Employeedto;
import com.dto.HrEmpDto;

public interface HRDao {

	List<Employeedto>getAllemployee() throws SQLException;
	List<HrEmpDto> getSalary() throws SQLException;
	List<Employeedto> getOInName()throws SQLException;
		 
}
