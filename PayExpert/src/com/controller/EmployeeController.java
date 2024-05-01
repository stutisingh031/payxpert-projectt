package com.controller;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import com.exception.EmployeeNotFoundException;
import com.model.Payroll;
import com.model.Performance;
import com.model.Tax;
import com.model.User;
import com.service.EmployeeService;

public class EmployeeController {
	public static void main(String[] args, User user) {
		Scanner sc = new Scanner(System.in);
		EmployeeService employeeService = new EmployeeService();
		// our 1st project
		while (true) {
			System.out.println("1. view Performance");
			System.out.println("2. View taxes");
			System.out.println("3. View payslip");
			System.out.println("0. To Exit");
			System.out.println("Enter: ");

			int input = sc.nextInt();
			if (input == 0) {
				System.out.println("Exiting Employee Module..");
				break;
			}
			int employeeId = -1;
			try {
				employeeId = employeeService.findEmpByUser(user.getUser_id());
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			} catch (EmployeeNotFoundException e) {
				System.out.println(e.getMessage());
			}

			switch (input) {
			case 1:

				try {
					List<Performance> performance = employeeService.showPerformance(employeeId);
					for (Performance p : performance)
						System.out.println(p);
				} catch (SQLException p) {
					System.out.println(p.getMessage());
				}

				break;

			case 2:

				List<Tax> taxes;
				try {
					taxes = employeeService.showTaxes(employeeId);
					for (Tax t : taxes)
						System.out.println(t);
				} catch (SQLException e) {
					System.out.println(e.getMessage());
				}

				break;
			case 3:

				try {
					List<Payroll> payroll = employeeService.showPayroll(employeeId);
					for (Payroll p : payroll)
						System.out.println(p);

				} catch (SQLException e) {
					System.out.println(e.getMessage());
				}
				break;

			}
		}

		//sc.close();
	}

	public static void employeeMenu(User u) {
		String args[] = { " " };
		main(args, u);
	}
}
