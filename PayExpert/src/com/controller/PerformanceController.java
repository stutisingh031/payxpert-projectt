package com.controller;

import java.sql.SQLException;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import com.dto.AverageOvertimeDto;
import com.dto.HighestEfficiencyDto;
import com.dto.PerformanceDto;
import com.exception.RemarkException;
import com.exception.ResourceNotFoundException;
import com.model.Employee;
import com.model.Performance;
import com.service.EmployeeService;
import com.service.PerformanceService;
import com.dto.HighEfficiencyLowSalaryEmployeesDto;

public class PerformanceController {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// Work Done by Priyankka
		Scanner sc = new Scanner(System.in);
		PerformanceService performanceService = new PerformanceService();
		EmployeeService employeeService = new EmployeeService();
		while (true) {
			System.out.println("1. Insert Performance ");
			System.out.println("2. Delete Performance ");
			System.out.println("3. De-Activate Performance ");
			System.out.println("4. Display Performance");
			System.out.println("5. Retrieve low efficiency employees");
			System.out.println("6. Average overtime work period based on position");
			System.out.println("7. Employees of Highest Efficiency");
			System.out.println("8. Employees of efficiency greater but with low salary");
			System.out.println("9. Display performance of employee using employee id (Accessible by employee)");
			System.out.println("10. Sort Employee on the basis of Efficiency");
			// System.out.println("10.Remarks on performance");
			System.out.println("Press 0 to exit");
			int input = sc.nextInt();
			if (input == 0) {
				System.out.println("You are welcome. Exited successfully");
				break;
			}
			switch (input) {
			case 1:

				try {
					// creating obj for performance
					Performance performance = new Performance();
					// creating id for the performance data
					Random random = new Random();
					int randomNumber = random.nextInt();
					int id = randomNumber < 0 ? randomNumber * -1 : randomNumber;
					performance.setPerformance_id(id);

					// read present days and assigning it to performance obj
					System.out.println("Enter the number of days present");
					performance.setPresent_days(sc.nextInt());

					// reading absent days and assigning it to performance obj
					System.out.println("Enter the number of days absent");
					performance.setAbsent_days(sc.nextInt());

					// reading the overtime period the employees work and assigning it to
					// performance obj
					System.out.println("Enter the number of hours the employee work over time");
					sc.nextLine();
					performance.setOvertime_period(sc.nextLine());

					// reading the efficiency of employee and assigning it to performance obj
					System.out.println("Enter the rate of efficiency for the work");
					performance.setEfficiency(sc.nextInt());

					// read it and assign it to performance obj
					System.out.println("Enter the Employee ID");
					performance.setEmployee_id(sc.nextInt());

					int status = performanceService.save(performance);
					if (status == 1)
						System.out.println("Performance has been added to DB");
					else
						System.out.println("Insertion Failed");

				} catch (SQLException e) {
					// TODO Auto-generated catch block
					System.out.println(e.getMessage());
				}
				break;
			case 2:
				System.out.println(" Enter Performance ID ");
				try {
					performanceService.deleteById(sc.nextInt());
					System.out.println("Deleted from DB successfully");
				} catch (ResourceNotFoundException e) {
					// TODO Auto-generated catch block
					System.out.println(e.getMessage());
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					System.out.println(e.getMessage());
				}
				break;
			case 3:
				System.out.println(" Enter Performance ID ");
				try {
					performanceService.softDeleteById(sc.nextInt());
					System.out.println("De-Activated from DB successfully");
				} catch (ResourceNotFoundException e) {
					// TODO Auto-generated catch block
					System.out.println(e.getMessage());
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					System.out.println(e.getMessage());
				}
				break;
			case 4:
				try {
					List<Performance> list = performanceService.findAll();
					for (Performance p : list)
						System.out.println(p);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					System.out.println(e.getMessage());
				}
				break;
			case 5:
				try {
					List<PerformanceDto> listperdto = performanceService.retrieveEmployeesWithLowEfficiency();
					for (PerformanceDto p : listperdto) {
						System.out.println(p);
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					System.out.println(e.getMessage());
				}
				break;
			case 6:
				try {
					List<AverageOvertimeDto> listavg = performanceService.avgOvertimeHoursPerPosition();
					for (AverageOvertimeDto avgdto : listavg) {
						System.out.println(avgdto);
					}
					listavg = performanceService.avgOvertimeHoursPerPosition();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					System.out.println(e.getMessage());
				}

				break;
			case 7:
				try {
					List<HighestEfficiencyDto> listeff = performanceService.findEmployeesWithHighestEfficiency();
					for (HighestEfficiencyDto hed : listeff) {
						System.out.println(hed);
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					System.out.println(e.getMessage());
				}
				break;
			case 8:
				try {
					List<HighEfficiencyLowSalaryEmployeesDto> listhelse = performanceService
							.findHighEfficiencyLowSalaryEmployees();
					for (HighEfficiencyLowSalaryEmployeesDto helse : listhelse) {
						System.out.println(helse);
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					System.out.println(e.getMessage());
				}
				break;
			case 9:
				System.out.println("Enter Employee ID");
				int employee_id = sc.nextInt();
				try {
					List<Performance> list = performanceService.displayEmployeePerformance(employee_id);
					for (Performance p : list) {
						System.out.println(p);
					}
				} catch (SQLException | ResourceNotFoundException e) {
					// TODO Auto-generated catch block
					System.out.println(e.getMessage());
				}
				break;
			case 10:
				try {
					Performance performance = new Performance();
					System.out.println("Enter Employee ID");
					int employeeid = sc.nextInt();
					String level = performanceService.remarks(performance.getEfficiency(),
							performance.getPresent_days(), employeeid);
					System.out.println(level);
				} catch (ResourceNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (RemarkException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
		}
		sc.close();

	}

}
