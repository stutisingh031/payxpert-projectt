package com.controller;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import com.dto.Employeedto;
import com.dto.Financialdto;
import com.exception.ResourceNotFoundException;
import com.model.Financial;
import com.service.FinancialService;

public class FinancialController {
	public static void main(String[] args) {
		FinancialService financialService =new FinancialService();	
		Scanner sc = new Scanner(System.in);
		while(true) {
			System.out.println("============FinancialMenu============");
			System.out.println("Press 1 : All Financial Records ");
			System.out.println("Press 2 : Delete");
			System.out.println("Press 3 : Financial records of employee");
			System.out.println("Press 4 : Bonus amount of employee");
			System.out.println("Press 0 : to exits");
			int input = sc.nextInt();
			if(input == 0) {
				System.out.println("Exiting Financial Record Module.");
				break;
			}
		
			
			switch (input) {
			
			case 1:
				try {
					List<Financial> financial=financialService.getAllrecords();
					for(Financial a : financial) {
						System.out.println(a);
					}
				}
					catch(SQLException e) {
					System.out.println(e.getMessage());
				}
				break;
			
			
			case 2:
				System.out.println("Enter Employee Id");
				try {
					financialService.deleteByid(sc.nextInt());
					System.out.println("Employee record deleted.");
				} catch (SQLException e) {
					 System.out.println(e.getMessage());
				} catch (ResourceNotFoundException e) {
					 System.out.println(e.getMessage());
				}		
				
			break;
			
		case 3:
				try {
					
					List<Employeedto> list = financialService.findAll();
					for(Employeedto a : list) {
						System.out.println(a);
					}
					
					System.out.println("Enter Employee ID");
					int employee_id = sc.nextInt();
					List<Financial> Record = financialService.getRecordOfEmployeeId(employee_id);
					for( Financial a : Record) {
						System.out.println(a);
					}
				}
				
				catch(SQLException e) {
				System.out.println(e.getMessage());
			    }catch (ResourceNotFoundException e) {
					System.out.println(e.getMessage());
				}
		break;
				
		case 4:
			try {

				List<Employeedto> list = financialService.findAll();
				for(Employeedto a : list) {
					System.out.println(a);
				}
				System.out.println("Enter Employee ID");
				int employee_id = sc.nextInt();
				List<Financialdto> list1 = financialService.getBonusAmountEmployee(employee_id);
				for(Financialdto f:list1) {
					System.out.println(f);
				}
			}
	           catch(SQLException e) {
				System.out.println(e.getMessage());
	           }
		break;
		
		}
		}
	
		sc.close();
}
}