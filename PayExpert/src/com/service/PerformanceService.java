package com.service;

import com.model.Performance;
import java.sql.SQLException;
import java.util.List;

import com.dao.EmployeeDao;
import com.dao.EmployeeDaoImpl;
import com.dao.PerformanceDao;
import com.dao.PerformanceDaoImpl;
import com.dto.AverageOvertimeDto;
import com.dto.HighEfficiencyLowSalaryEmployeesDto;
import com.dto.HighestEfficiencyDto;
import com.dto.PerformanceDto;
import com.exception.RemarkException;
import com.exception.ResourceNotFoundException;

public class PerformanceService {
	PerformanceDao dao = new PerformanceDaoImpl(); 
	EmployeeDao employeedao = new EmployeeDaoImpl();
	Performance performance = new Performance();
	public int save(Performance performance) throws SQLException {
		// TODO Auto-generated method stub
		return dao.save(performance);
	}

	public void deleteById(int id) throws ResourceNotFoundException, SQLException {
		// TODO Auto-generated method stub
		boolean isIdValid = dao.findOne(id);
		if(!isIdValid)
			throw new ResourceNotFoundException("Id given is invalid!....");
		dao.deleteById(id);
	}

	public void softDeleteById(int id) throws ResourceNotFoundException, SQLException {
		// TODO Auto-generated method stub
		boolean isIdValid = dao.findOne(id);
		if(!isIdValid)
			throw new ResourceNotFoundException("Id given is invalid!....");
		dao.softDeleteById(id);
	}

	public List<Performance> findAll() throws SQLException {
		// TODO Auto-generated method stub
		return dao.findAll();
	}

	public List<PerformanceDto> retrieveEmployeesWithLowEfficiency() throws SQLException {
		// TODO Auto-generated method stub
		return dao.retrieveEmployeesWithLowEfficiency();
	}

	public List<AverageOvertimeDto> avgOvertimeHoursPerPosition() throws SQLException {
		// TODO Auto-generated method stub
		return dao.avgOvertimeHoursPerPosition();
	}

	public List<HighestEfficiencyDto> findEmployeesWithHighestEfficiency() throws SQLException {
		// TODO Auto-generated method stub
		return dao.findEmployeesWithHighestEfficiency();
	}

	public List<HighEfficiencyLowSalaryEmployeesDto> findHighEfficiencyLowSalaryEmployees() throws SQLException {
		// TODO Auto-generated method stub
		return dao.findHighEfficiencyLowSalaryEmployees() ;
	}

	public List<Performance> displayEmployeePerformance(int employee_id) throws SQLException, ResourceNotFoundException {
		// TODO Auto-generated method stub
		boolean isEmployeeIdValid = employeedao.findOne(employee_id);
		if(!isEmployeeIdValid)
			throw new ResourceNotFoundException("Employee ID invalid");
	
        return dao.displayEmployeePerformance(employee_id);
	}

	public String remarks(int efficiency, int present_days, int employee_id) throws ResourceNotFoundException, SQLException, RemarkException {
		// TODO Auto-generated method stub
		Performance p1 = findById(employee_id);
		if(p1 != null ) {
			if(p1.getEfficiency() >= 8 && p1.getPresent_days() >= 26) {
				return "Excellent Performance";
			}
			if(p1.getEfficiency() >= 7 && p1.getPresent_days() >= 26) {
				return "Good Performance";
			}
			if(p1.getEfficiency() >= 6 && p1.getPresent_days() >= 26) {
				return "Satisfactory Performance";
			}
			if(p1.getPresent_days() < 26) {
				return"Loss of Pay";
			}
			
			return "Need Improvement";
		}
		else {
			throw new RemarkException("Invalid input");
		}
	}
	public Performance findById(int employee_id) throws SQLException, ResourceNotFoundException {
		boolean isEmployeeIdValid = dao.findOne(employee_id);
		if(!isEmployeeIdValid)
			throw new ResourceNotFoundException("Employee ID invalid");
		return dao.findById(employee_id);
	}




}
