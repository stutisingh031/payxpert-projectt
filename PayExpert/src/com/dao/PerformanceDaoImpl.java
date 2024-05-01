package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.dto.AverageOvertimeDto;
import com.dto.HighEfficiencyLowSalaryEmployeesDto;
import com.dto.HighestEfficiencyDto;
import com.dto.PerformanceDto;
import com.model.Performance;
import com.utility.DBConnection;

public class PerformanceDaoImpl implements PerformanceDao {
	//Work Done By Priyankka

	@Override
	public int save(Performance performance) throws SQLException {
		// TODO Auto-generated method stub
		Connection con = DBConnection.dbConnect();
		String sql = "INSERT INTO Performance (performance_id,present_days,absent_days,overtime_period,efficiency,employee_id)" + " values(?,?,?,?,?,?)";
		PreparedStatement pstmt = con.prepareStatement(sql);
		
		pstmt.setInt(1, performance.getPerformance_id());
		pstmt.setInt(2, performance.getPresent_days());
		pstmt.setInt(3, performance.getAbsent_days());
		pstmt.setString(4, performance.getOvertime_period());
		pstmt.setInt(5, performance.getEfficiency());
		pstmt.setInt(6, performance.getEmployee_id());
		int status = pstmt.executeUpdate();
		DBConnection.dbClose();
		return status;
	}

	@Override
	public void deleteById(int id) throws SQLException {
		// TODO Auto-generated method stub
		Connection con = DBConnection.dbConnect();
		String sql = "delete from Performance where performance_id =?";
		PreparedStatement pstmt = con.prepareStatement(sql);
		
		pstmt.setInt(1,id);
		pstmt.executeUpdate();
		DBConnection.dbClose();
		
	}

	@Override
	public boolean findOne(int id) throws SQLException {
		// TODO Auto-generated method stub
		Connection con = DBConnection.dbConnect();
		String sql = "Select performance_id from performance where performance_id =?";
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setInt(1,id);
		ResultSet rst = pstmt.executeQuery();
		boolean status = rst.next();
		DBConnection.dbClose();
		return status;
	}

	@Override
	public void softDeleteById(int id) throws SQLException {
		// TODO Auto-generated method stub
		Connection con = DBConnection.dbConnect();
		String sql = "update performance SET isActive='no' where performance_id =?";
		PreparedStatement pstmt = con.prepareStatement(sql);
		
		pstmt.setInt(1,id);
		pstmt.executeUpdate();
		DBConnection.dbClose();
		
	}

	@Override
	public List<Performance> findAll() throws SQLException {
		// TODO Auto-generated method stub
		Connection con = DBConnection.dbConnect();
		String sql = "select * from performance where isactive='yes'";
		PreparedStatement pstmt = con.prepareStatement(sql);
		ResultSet rst = pstmt.executeQuery();
		List<Performance> list= new ArrayList<>();
		while(rst.next()==true) {
			int id = rst.getInt("performance_id");
			int present_days = rst.getInt("present_days");
			int absent_days = rst.getInt("absent_days");
			String overtime_period = rst.getString("overtime_period");
			int efficiency = rst.getInt("efficiency");
			int employee_id = rst.getInt("employee_id");
			Performance performance = new Performance(id,present_days,absent_days,overtime_period,efficiency,employee_id);
			list.add(performance);
		}
		DBConnection.dbClose();
		return list;
	}

	@Override
	public List<PerformanceDto> retrieveEmployeesWithLowEfficiency() throws SQLException {
		// TODO Auto-generated method stub
		Connection con = DBConnection.dbConnect();
		String sql = "SELECT e.name, e.email, p.efficiency "
				+ " FROM performance p "
				+ " JOIN employee e on e.employee_id = p.employee_id "
				+ " WHERE p.efficiency <= 6 ";
		PreparedStatement pstmt = con.prepareStatement(sql);
		ResultSet rst = pstmt.executeQuery();
		List<PerformanceDto> list = new ArrayList<>();
		while(rst.next()==true) {
			String name = rst.getString("name");
			String email = rst.getString("email");
			int efficiency = rst.getInt("efficiency");
			PerformanceDto performancedto = new PerformanceDto(name,email,efficiency);
			list.add(performancedto);
		}
		DBConnection.dbClose();
		return list;
	}

	@Override
	public List<AverageOvertimeDto> avgOvertimeHoursPerPosition() throws SQLException {
		// TODO Auto-generated method stub
		Connection con = DBConnection.dbConnect();
		String sql = " select e.position,avg(p.overtime_period) as avg_overtime_period "
				+ " from employee e join performance p on e.employee_id = p.employee_id "
				+ " group by e.position ";
		PreparedStatement pstmt = con.prepareStatement(sql);
		ResultSet rst = pstmt.executeQuery();
		List<AverageOvertimeDto> list = new ArrayList<>();
		while(rst.next()==true) {
			String position = rst.getString("position");
			String avg_overtime_period = rst.getString("avg_overtime_period");
			AverageOvertimeDto averageOvertimeDto = new AverageOvertimeDto(position,avg_overtime_period);
			list.add(averageOvertimeDto);
		}
		DBConnection.dbClose();
		return list;
	}

	@Override
	public List<HighestEfficiencyDto> findEmployeesWithHighestEfficiency() throws SQLException {
		// TODO Auto-generated method stub
		Connection con = DBConnection.dbConnect();
		String sql = " select e.name,e.position,p.efficiency "
				+ " from employee e join performance p on e.employee_id = p.employee_id "
				+ " where p.efficiency = (select max(efficiency) from performance) ";
		PreparedStatement pstmt = con.prepareStatement(sql);
		ResultSet rst = pstmt.executeQuery();
		List<HighestEfficiencyDto> list = new ArrayList<>();
		while(rst.next()==true) {
			String name = rst.getString("name");
			String position = rst.getString("position");
			int efficiency = rst.getInt("efficiency");
			HighestEfficiencyDto highestEfficiencyDto = new HighestEfficiencyDto(name,position,efficiency);
			list.add(highestEfficiencyDto);
		}
		DBConnection.dbClose();
		return list;
	}

	@Override
	public List<HighEfficiencyLowSalaryEmployeesDto> findHighEfficiencyLowSalaryEmployees() throws SQLException {
		// TODO Auto-generated method stub
		Connection con = DBConnection.dbConnect();
		String sql = " select e.name, e.position, pe.efficiency, pr.net_salary "
				+ " from employee e join performance pe on e.employee_id = pe.employee_id "
				+ " join payroll pr on e.employee_id = pr.employee_id "
				+ " where pe.efficiency > 7 and pr.net_salary < 50000 ";
		PreparedStatement pstmt = con.prepareStatement(sql);
		ResultSet rst = pstmt.executeQuery();
		List<HighEfficiencyLowSalaryEmployeesDto> list = new ArrayList<>();
		while(rst.next()==true) {
			String name = rst.getString("name");
			String position = rst.getString("position");
			int efficiency = rst.getInt("efficiency");
			double net_salary = rst.getDouble("net_salary");
			HighEfficiencyLowSalaryEmployeesDto highEfficiencyLowSalaryEmployeesDto = new HighEfficiencyLowSalaryEmployeesDto(name,position,efficiency,net_salary);
			list.add(highEfficiencyLowSalaryEmployeesDto);
		}
		DBConnection.dbClose();
		return list;
	}

	@Override
	public List<Performance> displayEmployeePerformance(int employee_id) throws SQLException {
		// TODO Auto-generated method stub
		Connection con = DBConnection.dbConnect();
		String sql="select * from performance p join employee e ON p.employee_id=e.employee_id  "
				+ " where e.employee_id = ? AND p.isactive='yes'";
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setInt(1, employee_id);
		ResultSet rst = pstmt.executeQuery();
		List<Performance> list = new ArrayList<>();
		while(rst.next() == true) {
			int id = rst.getInt("performance_id");
			int present_days = rst.getInt("present_days");
			int absent_days = rst.getInt("absent_days");
			String overtime_period = rst.getString("overtime_period");
			int efficiency = rst.getInt("efficiency");
			int employee_Id = rst.getInt("employee_id");
			Performance performance = new Performance(id,present_days,absent_days,overtime_period,efficiency,employee_Id);
			list.add(performance);
		}
		DBConnection.dbClose();		
		return list;
	}

	public Performance findById(int employee_id) throws SQLException {
		// TODO Auto-generated method stub
		Performance performance = null;
	    Connection con = DBConnection.dbConnect();
	    String sql = " SELECT efficiency,present_days FROM Performance WHERE employee_id =? ";
	    PreparedStatement pstmt = con.prepareStatement(sql);
	    pstmt.setInt(1, employee_id);
	    ResultSet rst = pstmt.executeQuery();
	    if (rst.next()) {
	        performance = new Performance();
	        performance.setEfficiency(rst.getInt("efficiency"));
	        performance.setPresent_days(rst.getInt("present_days"));
	    }
	    DBConnection.dbClose();
	    return performance;
	}

}
