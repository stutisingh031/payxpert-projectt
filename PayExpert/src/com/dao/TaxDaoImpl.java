package com.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.model.Tax;
import com.utility.DBConnect;
import com.dto.TaxDto;
import com.exceptions.InvalidInputException;
import com.exceptions.TaxCalculationException;
public class TaxDaoImpl implements TaxDao {
    @Override
    public Tax retrieveTaxRecord(int taxId) throws SQLException,InvalidInputException {
        Connection con = DBConnect.dbConnect();
        String sql = "SELECT * FROM tax WHERE tax_id = ?";
        PreparedStatement pstmt = con.prepareStatement(sql);
        pstmt.setInt(1, taxId);
        ResultSet rs = pstmt.executeQuery();

        
        if (rs.next()) {
        	Tax tax = new Tax();
            int tax_id = rs.getInt("tax_id");
            String taxYear = rs.getString("tax_year");
            double taxAmount = rs.getDouble("tax_amount");
            int employee_id = rs.getInt("employee_id");
            tax = new Tax(tax_id, taxYear, taxAmount, employee_id);
            return tax;
        }
        else {

        DBConnect.dbClose();
        return null;}
        
    }

	@Override
	public Tax retriveEtaxRecord(int employee_id) throws SQLException, InvalidInputException {
	     Connection con = DBConnect.dbConnect();
	        String sql = "SELECT * FROM tax  WHERE employee_id = ?";
	        PreparedStatement pstmt = con.prepareStatement(sql);
	        pstmt.setInt(1, employee_id);
	        ResultSet rs = pstmt.executeQuery();

	        
	        if (rs.next()) {
	        	Tax tax = new Tax();
	            int tax_id = rs.getInt("tax_id");
	            String taxYear = rs.getString("tax_year");
	            double taxAmount = rs.getDouble("tax_amount");
	            int employeeId = rs.getInt("employee_id");
	            tax = new Tax(tax_id, taxYear, taxAmount, employeeId);
	            return tax;
	        }
	        else {
	        DBConnect.dbClose();
	        return null;
	        }
	}

	@Override
	public Tax retriveEtaxRecord(int taxYear, int employeeId) throws SQLException, InvalidInputException {
		  Connection con = DBConnect.dbConnect();
	        String sql = "SELECT * FROM tax WHERE tax_year = ? AND employee_id = ?";
	        PreparedStatement pstmt = con.prepareStatement(sql);
	        pstmt.setInt(1, taxYear);
	        pstmt.setInt(2, employeeId);
	        ResultSet rs = pstmt.executeQuery();

	        
	        if (rs.next()) {
	        	Tax tax = new Tax();
	            int tax_id = rs.getInt("tax_id");
	            String taxyear = rs.getString("tax_year");
	            double taxAmount = rs.getDouble("tax_amount");
	            int employee_id = rs.getInt("employee_id");
	            tax = new Tax(tax_id, taxyear, taxAmount, employee_id);
	            return tax;
	        }
	        else {

	        DBConnect.dbClose();
	        return null;}
	}

	@Override
	public TaxDto calculateTax(int employeeId, int taxYear) throws SQLException, TaxCalculationException {
		 Connection con = DBConnect.dbConnect();
	        String sql = "select t.employee_id, p.net_salary, t.tax_amount, t.tax_year from tax t join payroll p on t.employee_id=p.employee_id "
	        		+ "where t.employee_id = ? and t.tax_year = ? "
	        		+ " group by t.employee_id";
	        PreparedStatement pstmt = con.prepareStatement(sql);
	        pstmt.setInt(1, employeeId);
	        pstmt.setInt(2, taxYear);
	        ResultSet rs = pstmt.executeQuery();

	        
	        if (rs.next()) {
	        	TaxDto taxDto = new TaxDto();
	            int empId = rs.getInt("employee_id");
	            Double netSalary = rs.getDouble("net_salary");
	            int taxAmount = rs.getInt("tax_amount");
	            int taxyear = rs.getInt("tax_year");
	            taxDto = new TaxDto(empId,netSalary,taxAmount,taxyear);
	            return taxDto;
	        }
	        else {

	        DBConnect.dbClose();
	        return null;}
	}
}