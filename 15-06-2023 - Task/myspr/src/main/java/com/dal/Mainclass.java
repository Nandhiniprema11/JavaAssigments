package com.dal;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Mainclass{
	public static void main(String[] args)
	{
		@SuppressWarnings("resource")
		ApplicationContext context =new ClassPathXmlApplicationContext("welcome.xml");
		Welcome wel =(Welcome)context.getBean("wel");
		System.out.println(wel.sayHi());
	}
}

