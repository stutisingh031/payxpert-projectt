package com.dao;

import java.sql.SQLException;
import java.util.List;

import com.dto.AverageOvertimeDto;
import com.dto.HighEfficiencyLowSalaryEmployeesDto;
import com.dto.HighestEfficiencyDto;
import com.dto.PerformanceDto;
import com.model.Performance;

public interface PerformanceDao {

	int save(Performance performance) throws SQLException;

	void deleteById(int id) throws SQLException;

	boolean findOne(int id) throws SQLException;

	void softDeleteById(int id) throws SQLException;

	List<Performance> findAll() throws SQLException;

	List<PerformanceDto> retrieveEmployeesWithLowEfficiency() throws SQLException;

	List<AverageOvertimeDto> avgOvertimeHoursPerPosition() throws SQLException;

	List<HighestEfficiencyDto> findEmployeesWithHighestEfficiency() throws SQLException;

	List<HighEfficiencyLowSalaryEmployeesDto> findHighEfficiencyLowSalaryEmployees() throws SQLException;

	List<Performance> displayEmployeePerformance(int employee_id) throws SQLException;

    Performance findById(int employee_id) throws SQLException;


}
