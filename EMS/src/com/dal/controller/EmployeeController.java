package com.dal.controller;

import java.io.BufferedReader;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectOutputStream;
import java.io.OutputStreamWriter;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import java.io.Serializable;

import com.dal.model.Employee1;
//import com.dedalus.Employee;
import com.dedalus.Employee;

public class EmployeeController implements EmployeeInterface {
	
	//Scanner sc = new Scanner(System.in);
	InputStreamReader isr = new InputStreamReader(System.in);
	BufferedReader br = new BufferedReader(isr);
	
	Employee1 emp;
	List emplist = new ArrayList<>(); 
	public void addEmployee()
	{	
    try {
		int x = 0;
		String y = null;
		
		emp = new Employee1();
		System.out.println("Enter Eno");
	    x= Integer.parseInt(br.readLine());
	    int eno =x;
		emp.setEmpno(eno);		
		System.out.println(emp.getEmpno());
	
		
		
		System.out.println("Enter Ename");
		y= br.readLine();
		
		String ename = y;
		emp.setEname(ename);
		
		System.out.println(emp.getEname());
		
		/*Iterator<Employee1> i = elist.iterator();
		while (i.hasNext()) {
			System.out.println(i.next());*/
		
		emplist.add(emp);
		
		System.out.println("Employee Added Successfully");
		
	}
    catch(Exception e) 
    {
		System.out.println ("Invalid Value");
		e.printStackTrace();
	}
    finally {
    	System.out.println("Finally .....");
	}
	}
	
	public void viewEmployee() {
		System.out.println(emp.getEmpno());
		System.out.println(emp.getEname());
		
		System.out.println(emplist);
	}
	
public void SeriEmployee() throws IOException
	{
   
        //Demo object = new Demo(1, "serialized");
        String filename = "dedalus.txt";
         
        // Serialization
        try
        {  
            //Saving of object in a file
            FileOutputStream fis1 = new FileOutputStream(filename);
            ObjectOutputStream ois1 = new ObjectOutputStream(fis1);
            
    		
    		//Employee1 emp = new Employee1();
            
    		System.out.println(emp.getEmpno());
    		System.out.println(emp.getEname());
    		
    		System.out.println("0111111111111");
    		
    		System.out.println(emplist);
    	
    		ois1.writeObject(emp.getEmpno());
    		ois1.writeObject(emp.getEname());
    				
    		//ois1.writeObject(emplist);
    		//ois1.writeObject(emp.getEname());
    		
    		System.out.println("33333333333");
    		
    		
    		System.out.println("Serialized from file dedalus.txt");
    		System.out.println(emp.getEmpno());
    		System.out.println(emp.getEname());
    		
             
            // Method for serialization of object
            //out.writeObject(object);
             
    		ois1.close();
            fis1.close();
             
            System.out.println("Object has been serialized");
 
        }
         
        catch(IOException ex)
        {
            System.out.println("IOException is caught");
        }
 
		
	}
	
	public void DeseEmployee() throws IOException
	{
		
		try{
			
			System.out.println("0111111111111");
		
	
		FileInputStream fis = new FileInputStream("dedalus.txt");
		ObjectInputStream ois = new ObjectInputStream(fis);		
	
		System.out.println("0222222222222222222");
		
		System.out.println(emp.getEmpno());
		System.out.println(emp.getEname());
		
		Serializable emp = (Serializable)ois.readObject();
		
		//ois.readObject(emp.getEmpno());
		//ois.readObject(emp.getEname());
		
		System.out.println("666666666666666");
		
		System.out.println("DeSerilized from file dedalus.txt");
		//System.out.println(emp.getEmpno());
		//System.out.println(emp.getEname());
		ois.close();
		fis.close();
		}
		catch(FileNotFoundException fnf)
		{
			System.out.println("No file");
		}
		catch(ClassNotFoundException cnf)
		{
			System.out.println("No Emp class");
		}

	
	}

}