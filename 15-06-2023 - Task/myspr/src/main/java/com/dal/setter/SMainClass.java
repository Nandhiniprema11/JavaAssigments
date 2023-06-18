package com.dal.setter;

import org.springframework.context.ApplicationContext;

import org.springframework.context.support.ClassPathXmlApplicationContext;


public class SMainClass {
	public static void main(String[] args)
	{
		ApplicationContext context =new ClassPathXmlApplicationContext("setter.xml");
		User u =(User) context.getBean("user");

		System.out.println(u.getUsername() + " has " + 
				u.getCar().getCarNumber()+ " " +u.getCar().getModel());				
	
	}	
}
