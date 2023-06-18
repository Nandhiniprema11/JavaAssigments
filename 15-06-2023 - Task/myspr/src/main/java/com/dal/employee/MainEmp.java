package com.dal.employee;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainEmp {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("spr-employee.xml");
		
		MyConn con = (MyConn) context.getBean("con");
		System.out.println(con.getDbname() + "  " + con.getUname() + "  " + con.getPassword());
		
		Employee emp = (Employee) context.getBean("emp");
		System.out.println(emp.getEname() + "  " + emp.getEid() + "  " + emp.toString());
		
	}

}

