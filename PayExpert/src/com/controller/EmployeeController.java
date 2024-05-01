package com.controller;

import java.sql.SQLException;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import com.exception.EmployeeNotFoundException;
import com.model.Employee;
import com.model.Payroll;
import com.model.Performance;
import com.model.Tax;
import com.service.EmployeeService;

public class EmployeeController {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		EmployeeService employeeService = new EmployeeService();
		// our 1st project
		while (true) {
			System.out.println("1. view Performance");
			System.out.println("2. View taxes");
			System.out.println("3. View payslip");
			System.out.println("4. Insert Employee");
			System.out.println("5. Delete Employee");
			System.out.println("6. Deactivate  Employee");
			System.out.println("7. Dispaly all Employee");
			System.out.println("0. To Exit");
			System.out.println("Enter: ");
			
			int input = sc.nextInt();
			if(input == 0) {
				System.out.println("Exiting Employee Module..");
				break; 
			}
			
			
			int empId = 2;

			switch (input) {
			case 1:
				
				List<Performance> performance;
				try {

					performance = employeeService.showPerformance(empId);
					for (Performance p : performance)
						System.out.println(p);
				} catch (SQLException p) {
					System.out.println(p.getMessage());
				}

				break;

			case 2:
				
				List<Tax> taxes;
				try {
					taxes = employeeService.showTaxes( empId);
					for (Tax t : taxes)
						System.out.println(t);
				} catch (SQLException e) {
					System.out.println(e.getMessage());
				}

				break;
			case 3:

				
				try {
					List<Payroll> payroll = employeeService.showPayroll(empId);
					for (Payroll p : payroll)
						System.out.println(p);

				} catch (SQLException e) {
					System.out.println(e.getMessage());
				}
				break;
			case 4: 
				
				Random random = new Random(); 
				int randomNumber = random.nextInt(); 
				int id =randomNumber<0?randomNumber*-1:randomNumber; 
				System.out.println("Enter Name");
				sc.nextLine();
				String name = sc.nextLine();   
				System.out.println("Enter Date of Birth");
				String dateOfBirth=sc.nextLine(); //email
				System.out.println("Enter Gender");
				String gender=sc.nextLine();
				System.out.println("Enter Email");
				String email=sc.nextLine();		
				System.out.println("Enter Phone Number");
				String phoneNumber=sc.nextLine();
				System.out.println("Enter Address");
				String address=sc.nextLine();
				System.out.println("Enter Position");
				String position=sc.nextLine();
				System.out.println("Enter Joining Date");
				String joiningDate=sc.nextLine();
				System.out.println("Enter termination Date");
				String terminationDate=sc.nextLine();
				System.out.println("Enter User Id");
				String userId=sc.nextLine();
				
				Employee employee = new Employee(id, name,dateOfBirth,gender,email,phoneNumber,address,position,joiningDate,terminationDate,userId);

				try {
					int status = employeeService.insert(employee);
					if(status == 1)
						System.out.println("Employee record added to DataBase..");
					else
						System.out.println("Insert op failed");
				} catch (SQLException e) {
					System.out.println(e.getMessage());
				}
				
				break; 
			case 5: 
				System.out.println("Enter Employee ID");
				try {
					employeeService.deleteByid(sc.nextInt());
					System.out.println("Employee record deleted..");
				} catch (SQLException e) {
					 System.out.println(e.getMessage());
				} catch (EmployeeNotFoundException e) {
					 System.out.println(e.getMessage());
				}				
				break; 
			case 6: 
				System.out.println("Enter Employee ID");
				try {
					employeeService.softDeleteByid(sc.nextInt());
					System.out.println("Employee record de-activated..");
				} catch (EmployeeNotFoundException e) {
					System.out.println(e.getMessage());
				} catch (SQLException e) {
					System.out.println(e.getMessage());
				}				
				break; 
			case 7: 	 
				try {
					List<Employee> list =employeeService.findAll();
					for(Employee e : list) {
						System.out.println(e);
					}
				} catch (SQLException e) {
					System.out.println(e.getMessage());
				}
				break; 
				
			}

		}
		sc.close();
	}

}
