package com.controller;

import com.exception.ResourceNotFoundException;
import com.model.Employee;

import java.sql.SQLException;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import com.model.Payroll;
import com.service.EmployeeService;
import com.service.PayrollService;

public class PayrollController {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		PayrollService payrollService = new PayrollService();
		EmployeeService employeeService = new EmployeeService();

		while (true) {
			System.out.println("1. Insert Payroll");
			System.out.println("2. Display basic salary of Employee");
//			System.out.println("3. Display overtime pay");
//			System.out.println("4. Display payroll info of employees");
//			System.out.println("5. Update payroll by id");
//			System.out.println("6. Delete payroll by id");
			System.out.println("Press 0. to Exit");
			int input = sc.nextInt();
			if (input == 0) {
				System.out.println("Exiting Payroll Module..");
				break;
			}
			switch (input) {
			case 1:
				Payroll payroll = new Payroll();
				/* Generating and assigning id to payroll obj */
				Random random = new Random();
				int randomNumber = random.nextInt();
				int id = randomNumber < 0 ? randomNumber * -1 : randomNumber;
				payroll.setPayroll_id(id);

				System.out.println("Enter Pay period start date");
				sc.nextLine();
				payroll.setPayPeriodStartDate(sc.nextLine());

				System.out.println("Enter Pay period start date");

				payroll.setPayPeriodEndDate(sc.nextLine());

				System.out.println("Enter Basic Salary");

				payroll.setBasicSalary(sc.nextDouble());

				System.out.println("Enter Overtime pay");

				payroll.setOvertimePay(sc.nextDouble());

				System.out.println("Enter Deductions");

				payroll.setDeductions(sc.nextDouble());

				System.out.println("Enter net Salary");

				payroll.setNetSalary(sc.nextDouble());

				try {
					payrollService.save(payroll);
				} catch (SQLException e) {
					System.out.println(e.getMessage());
				} catch (ResourceNotFoundException e) {
					System.out.println(e.getMessage());
				}

				System.out.println("Payroll added successfully");
				break;

			case 2:

				try {
					List<Employee> list = employeeService.findAll();
					for (Employee e : list) {
						System.out.println(e);
					}
				} catch (SQLException e) {
					System.out.println(e.getMessage());
				}

				System.out.println("Enter Employee ID");
				int employee_Id = sc.nextInt();

				List<Payroll> listPayroll = payrollService.getBasiceSalaryOfEmployee(employee_Id);
				for (Payroll p : listPayroll) {
					System.out.println(p);
				}
				break;

			case 3:
				// Logic to display overtime pay

				try {
					List<Employee> empList = employeeService.findAll();
					for (Employee emp : empList) {
						double overtimePay = payrollService.calculateOvertimePay(emp);
						System.out.println("Employee ID: " + emp.getUserId() + ", Overtime Pay: " + overtimePay);
					}
				} catch (SQLException e) {
					System.out.println(e.getMessage());
				}

				break;

			case 4:
				// Logic to display payroll info of employees
				List<Payroll> payrollList = payrollService.getAllPayrolls();
				for (Payroll p : payrollList) {
					System.out.println("Payroll ID: " + p.getPayroll_id());
					System.out.println("Pay Period Start Date: " + p.getPayPeriodStartDate());
					System.out.println("Pay Period End Date: " + p.getPayPeriodEndDate());
					System.out.println("Basic Salary: " + p.getBasicSalary());
					System.out.println("Overtime Pay: " + p.getOvertimePay());
					System.out.println("Deductions: " + p.getDeductions());
					System.out.println("Net Salary: " + p.getNetSalary());
					System.out.println("Employee ID: " + p.getEmployee_id());
				}
				break;

			case 5:
				// Logic to update payroll
				System.out.println("Enter Payroll ID to update");
				int updatePayrollId = sc.nextInt();
				Payroll updatePayroll = payrollService.findPayrollById(updatePayrollId);
				if (updatePayroll != null) {
					// Update payroll fields as needed
					System.out.println("Enter new Basic Salary");
					updatePayroll.setBasicSalary(sc.nextDouble());

					System.out.println("Enter new Overtime pay");
					updatePayroll.setOvertimePay(sc.nextDouble());

					System.out.println("Enter new Deductions");
					updatePayroll.setDeductions(sc.nextDouble());

					System.out.println("Enter new Net Salary");
					updatePayroll.setNetSalary(sc.nextDouble());

					payrollService.updatePayroll(updatePayroll);
					System.out.println("Payroll updated successfully!");
				} else {
					System.out.println("Payroll not found with ID: " + updatePayrollId);
				}
				break;

			case 6:
				// Logic to delete payroll
				System.out.println("Enter Payroll ID to delete");
				int deletePayrollId = sc.nextInt();
				Payroll deletePayroll = payrollService.findPayrollById(deletePayrollId);
				if (deletePayroll != null) {
					payrollService.updatePayroll(deletePayroll);
					System.out.println("Payroll deleted successfully!");
				} else {
					System.out.println("Payroll not found with ID: " + deletePayrollId);
				}
				break;

			default:
				System.out.println("Invalid option selected. Please try again.");
				break;

			}
		}
		sc.close();
	}

}
