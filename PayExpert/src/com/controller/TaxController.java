package com.controller;
import java.sql.SQLException;
import com.exception.InvalidInputException;
import com.exception.TaxCalculationException;
import java.util.Scanner;
import com.model.Tax;
import com.dto.TaxDto;
import com.service.TaxService;

public class TaxController {
    public static void main(String[] args) {
        TaxService taxService = new TaxService();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("==========TAX MENU==========");
            System.out.println("Press 1. Retrieve Tax record by tax_id ");
            System.out.println("Press 2. Retrive Tax record  by employee_id");
            System.out.println("Press 3. Retrive Tax record for Year");
            System.out.println("Press 4. Calculate Tax");
            System.out.println("Press 0. to Exit");

            int input = sc.nextInt();
            if (input == 0) {
                System.out.println("Exiting Tax Module...");
                break;
            }

            switch (input) {
                case 1:      //Showing tax details on the basis of Tax_ID
                    System.out.print("Enter Tax ID: ");
                    int taxId = sc.nextInt();
                    try {
                        Tax tax = taxService.retrieveTaxRecord(taxId);
                        
                            System.out.println("Tax Record Found:");
                            System.out.println(tax);
                        } 
                     catch (SQLException e) {
                     
                        System.out.println(e.getMessage()); 
                    }
                    
                       catch (InvalidInputException e) {
                    	 System.out.println(e.getMessage());
                     }
                    break;
                case 2: // tax details on the basis of employeeId
                	System.out.println("Enter Employee Id");
                	int employeeId = sc.nextInt();
                	try {
                	Tax tax = taxService.retrieveEtaxRecord(employeeId);
                     System.out.println("Tax Record Found:");
                        System.out.println(tax);
                
                   
                	}
                 catch (SQLException e) {
                    System.out.println(e.getMessage()); 
                }
                 catch (InvalidInputException e) {
                	 System.out.println(e.getMessage());
                 }
                break;
                case 3://Tax details of employee on the basis of financial year
                	System.out.println("Enter the financial Year");
                	int taxYear = sc.nextInt();
                	System.out.println("Enter your Id");
                	int eId = sc.nextInt();
			
				try {
					Tax tax = taxService.retriveTaxRec(taxYear,eId);
					System.out.println("Record Found");
                	System.out.println(tax);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					System.out.println(e.getMessage());
				} catch (InvalidInputException e) {
					// TODO Auto-generated catch block
					System.out.println(e.getMessage());
				}
				break;
                case 4:// calculating tax percent of netSalary
                	System.out.println("Enter your Employee Id");
                	int emId = sc.nextInt();
                	System.out.println("Enter the tax tear");
                	int tYear = sc.nextInt();
                	
				try {
					TaxDto taxDto = taxService.calculateTax(emId,tYear);
					double taxPercent = taxService.calculateTaxPercent(taxDto);
                    System.out.println(taxDto);
                    System.out.println("Tax Percent: " + taxPercent + "%");
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					System.out.println(e.getMessage());
				} catch (TaxCalculationException e) {
					// TODO Auto-generated catch block
					System.out.println(e.getMessage());
				}
				break;
			
				default:
					System.out.println("Invalid choice");
               
                	
                	
                	
               
            }
        }

        sc.close();
    }
}
