package com.controller;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;
import com.dto.Employeedto;
import com.dto.HrEmpDto;
import com.service.HRService;

public class HRController {

	public static void main(String[] args) {
		HRService hRService = new HRService();
		Scanner sc = new Scanner(System.in);
		while (true) {
			System.out.println("============HR Menu============");
			System.out.println("Press 1 : Display Employee ");
			System.out.println("Press 2 : Employee Not Have Salary");
			System.out.println("Press 3 : Having o in name");
			System.out.println("Press 4 : Insert Employee");
			System.out.println("Press 0 : To exits");
			int input = sc.nextInt();
			if (input == 0) {
				System.out.println("Exit HR Module.");
				break;
			}

			switch (input) {

			case 1:
				try {
					List<Employeedto> employee = hRService.getAllemployee();
					for (Employeedto e : employee) {
						System.out.println(e);
					}
				} catch (SQLException e) {
					System.out.println(e.getMessage());
				}
				break;

			case 2:
				try {
					List<HrEmpDto> salary = hRService.getSalary();
					for (HrEmpDto s : salary) {
						System.out.println(s);
					}
				} catch (SQLException e) {
					System.out.println(e.getMessage());
				}
				break;

			case 3:
				try {
					List<Employeedto> employee = hRService.getOInName();
					for (Employeedto e : employee) {
						System.out.println(e);
					}

				} catch (SQLException e) {
					System.out.println(e.getMessage());
				}
				break;

			case 4:

				break;
			}
		}
		//sc.close();
	}

	public static void menu() {
		String args[] = { " " };
		main(args);
	}
}
