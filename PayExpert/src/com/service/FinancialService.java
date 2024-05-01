package com.service;

import com.dao.FinancialDaoImpl;
import com.dto.Employeedto;
import com.dto.Financialdto;
import com.exception.ResourceNotFoundException;
import com.model.Financial;
import com.dao.FinancialDao;
import java.sql.SQLException;
import java.util.List;


public class FinancialService {
	       FinancialDao dao =new FinancialDaoImpl();
	       
	       public List<Employeedto> findAll() throws SQLException {
		   return dao.findAll();	
        }
	       
	//get record of employee

	public  List<Financial > getRecordOfEmployeeId(int employee_id) throws SQLException, ResourceNotFoundException {
		   boolean isEmployee_idValid = dao.findOne(employee_id);
		   if(!isEmployee_idValid)
			throw new ResourceNotFoundException("Employee ID invalid");
	
           return dao.getRecordOfEmployeeId(employee_id);
}

//get bonus amount of employee
	 public List<Financialdto> getBonusAmountEmployee(int employee_id) throws SQLException {
		    return  dao.getBonusAmountEmployee();
	}

// all financial record
	public List<Financial> getAllrecords() throws SQLException {
		   return dao.getAllrecords();
	}

// for deletion
	public void deleteByid(int employee_id)throws SQLException, ResourceNotFoundException {
		   boolean isIdValid = dao.findOne(employee_id);
		   if(!isIdValid)
			  throw new ResourceNotFoundException("Id given is Invalid!!");
		 
		  dao.deleteByid(employee_id); {
		 
		  }
	}

}
