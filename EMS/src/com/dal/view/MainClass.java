package com.dal.view;

import java.util.Scanner;
import com.dedalus.Employee;

import java.io.*;

import com.dal.controller.EmployeeController;

public class MainClass {

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
		Scanner sc = new Scanner(System.in);	
		String ch=null;
		do
		{
			System.out.println("Enter your choice");
			System.out.println("1. Add Employee");
			System.out.println("2. View Employee");
			System.out.println("3. Serialization");
			System.out.println("4. Deserialization");
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
	}
}