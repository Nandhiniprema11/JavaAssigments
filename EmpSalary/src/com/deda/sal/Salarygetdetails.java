package com.deda.sal;
import com.deda.sal.Salary;

import java.util.Scanner;

public class Salarygetdetails {
	Scanner sc =new Scanner (System.in);
	Salary sa=new Salary();
	
	public void addSalary()
	{
	
		System.out.println("Enter Salary");
		double sala=sc.nextDouble();
		sa.setBasic(sala);
	    sa.Setda(sala*0.05);
		sa.setPf(sala*0.12);
	    double s1=(sala+ (sala*0.05)- (sala*0.12));
		sa.setGross(s1);
		double s2=(sala+ (sala*0.05)+ (sala*0.12));
		sa.setNet(s2);
		//sa.toString(); 
		System.out.println(sa.toString());
	}
}

