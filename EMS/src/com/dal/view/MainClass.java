package com.dal.view;

import java.io.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.function.BiPredicate;
import java.io.Serializable;
import com.dal.controller.EmployeeController;
import com.dal.controller.UserNotFoundException;

public class MainClass implements Serializable {

	public static void main(String[] args) throws IOException {
		 System.out.println("Logging in...");
		 
		 try {
	            System.out.print("Loading");
	            for (int i = 0; i < 5; i++) {
	                Thread.sleep(1000); // Sleep for 1 second
	                System.out.print(".");
	          }
		 } catch (InterruptedException e) {
	               e.printStackTrace();
	        }

	        System.out.println("\nLogin successful!");
	        
	   	System.out.println("Welcome EMS");
		EmployeeController ec = new  EmployeeController();
		//EmployeeDao ed = new EmployeeDao();
		Scanner sc = new Scanner(System.in);	
		String ch=null;
		try {
			String un = null;
			String pwd = null;

			BiPredicate<String, String> validateUsernamePassword = (username, password) ->
		    username.equals("Nan") && password.equals("pass");


			InputStreamReader isr = new InputStreamReader(System.in);
			BufferedReader br = new BufferedReader(isr);
		    System.out.println("Enter Username");
		    un = br.readLine();
		    System.out.println("Enter Password");
		    pwd = br.readLine();

		    if (validateUsernamePassword.test(un, pwd)) {
		        System.out.println("Welcome " + un);
		        // Rest of the code remains unchanged
		    } 
		
		    else {
		        throw new UserNotFoundException();
		    }
		    
					
		do
		{
			System.out.println("Enter your choice");
			System.out.println("1. Add Employee");
			System.out.println("2. View Employee");
			System.out.println("3. Serialization");
			System.out.println("4. Deserialization");
			System.out.println("5. Insertion in DB");
			System.out.println("6. Updation in DB");
			System.out.println("7. Deletion in DB");
			
			int choice = sc.nextInt();
			switch(choice) {
			case 1 : {
			ec.addEmployee();
			break;
			}
			case 2 : 
			{
				ec.viewEmployee();
				break;
			}
			case 3 : 
			{
				ec.SeriEmployee();
				break;
			}
			case 4:
				
			{
				ec.DeseEmployee();
				break;
			}
			
	      case 5:
				
			{
				ec.InsertEmployee();
				break;
			}
	      case 6:
				
	 			{
	 				ec.updateEmployee();
	 				break;
	 			}
	      case 7:
				
			{
				ec.deleteEmployee();
				break;
			}
		
	    default : {
		System.out.println("Enter a valid number");
		break;
	}}
		
	    System.out.println("Do u want to continue Y | y");
		ch=sc.next();
		
		}
	while(ch.equals("Y") || ch.equals("y"));
		System.out.println("Thanks for using our system.");
		System.exit(0);
		
		} catch (UserNotFoundException unf) {
		    unf.printStackTrace();
		} catch (Exception ae) {
		    System.out.println("IO");
		} finally {
		    System.out.println("Finally .....");
		}
}
	}



