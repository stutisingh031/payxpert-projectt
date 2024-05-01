package com.controller;
import com.service.UserService;
import com.model.User;
import java.util.Random;
import java.sql.SQLException;
import java.util.Scanner;


public class UserController {
	public static void main(String[] args) {
		UserService userService = new UserService();
		Scanner sc = new Scanner(System.in);
		while(true) {
			System.out.println("============USER OP============");
			System.out.println("Press 1----- Insert New User ");
			//System.out.println("Press 2. Delete Artist ");
			//System.out.println("Press 3. Deactivate Delete Artist[Soft delete] ");
			//System.out.println("Press 4. Display all artists");
			System.out.println("Press 0-----  Exit");
			int input = sc.nextInt();
			if(input == 0) {
				System.out.println("Exiting Please Wait....");
				break; 
			}
				
			switch (input) {
			case 1:
				Random random = new Random(); 
				int randomNumber = random.nextInt(); 
				int id =randomNumber<0?randomNumber*-1:randomNumber; 
				System.out.println("Enter User Name");
				sc.nextLine();
				String name = sc.nextLine();   
				System.out.println("Enter Password");
				String password=sc.nextLine();
				System.out.println("Enter Role ");
				String role=sc.nextLine();
				/* Attach values to Object  */
				User user = new User(id,name,password,role);
				try {
					int status = userService.insert(user);
					if(status == 1)
						System.out.println("User record added to DB..");
					else
						System.out.println("Opration failed");
				} catch (SQLException e) {
					System.out.println(e.getMessage());
				}
				
		
			}
			
		}
		
		//sc.close();
	}
	
	public static void adminMenu() {
		String[] sarry = {""};
		main(sarry);
		
	}

}

