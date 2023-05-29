package com.deda.sal;

import java.util.Scanner;
import com.deda.sal.Salary;
import com.deda.sal.Salarygetdetails;

class Employee {

	int empno;
	String ename = "Asha";

	Salary sal;
	
	public Employee() {

	  System.out.println("From Employee Constructor");
	}
	
	public Employee(int x) {
		  this("Mani");
		  this.empno=x;
			  System.out.println("From Employee Constructor" + x);
	}
	
	public Employee(String str) {
		  
		  System.out.println("From Employee Constructor" + str);
	}
	public String getDetails() {
		return (empno + " -- " + ename + " --- " + sal);
	}

}

class Manager extends Employee {
	String dept = "IT";
	

	public Manager() {
		super(888);  // used to invoke base clas constructor
		System.out.println("From Mgr Constr");
		
	}
	public String getDetails() {
		 return super.getDetails()+ "--  " + dept;
	}

}

public class MainClass {

	public static void main(String[] args) {
		Employee emp = new Employee();
		System.out.println(emp.getDetails());

		Manager mgr = new Manager();
		System.out.println(mgr.getDetails());
		
		Salarygetdetails a = new Salarygetdetails();
		a.addSalary();
		//System.out.println(emp.sal);
		
		Employee e1 = new Manager();//polymorphic method
		System.out.println(emp.getDetails());
	
		
		//e1.showidcard;
		
		if (emp instanceof Manager)
		{
			System.out.println("Iam a Employee");}
		
			else {
				System.out.println("Iam a Manager");
			}
		}
		}
			
		//First base 

//	}

