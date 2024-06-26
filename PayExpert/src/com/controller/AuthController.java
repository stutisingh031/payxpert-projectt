package com.controller;

import java.sql.SQLException;
import java.util.Scanner;
import com.exception.InvalidCredentialsException;
import com.model.User;
import com.service.UserService;

public class AuthController {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		UserService userService = new UserService();
		while (true) {
			System.out.println("==========Welcome to PayXpert==========");
			System.out.println("Press 1. Login");
			System.out.println("Press 0. Exit");
			int input = sc.nextInt();
			if (input == 0) {
				System.out.println("Exiting PayXpert..");
				break;
			}
			switch (input) {
			case 1:
				try {

					System.out.println("Enter username");
					sc.nextLine();
					String username = sc.nextLine();
					System.out.println("Enter password");
					String password = sc.nextLine();
					System.out.println("role");
					String role = sc.nextLine();

					User userObj = userService.login(username, password, role);

					if (userObj.getRole().equalsIgnoreCase("HR")) {
						// load customer menu
						System.out.println("=====HR MENU=====");
						System.out.println("Welcome " + username);
<<<<<<< HEAD
						HRController.menu();
=======
						HRController.adminMenu();
>>>>>>> eb732ce83a3cb6c00573269ad242e7f11bdce7a3
					} else {
						System.out.println("=====EMPLOYEE MENU=====");
						System.out.println("Welcome " + username);
<<<<<<< HEAD
						EmployeeController.employeeMenu(userObj);
=======
						//EmployeeController.employeeMenu();
>>>>>>> eb732ce83a3cb6c00573269ad242e7f11bdce7a3
					}
				} catch (SQLException e) {
					System.out.println(e.getMessage());

				} catch (InvalidCredentialsException e) {
					System.out.println(e.getMessage());
				}
				break;
			default:
				System.out.println("Invalid input given, try again!!!");

			}
		}
		sc.close();
	}

}
