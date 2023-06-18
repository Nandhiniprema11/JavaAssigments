package com.dal.xmlconfig;

import org.springframework.beans.factory.annotation.Value;

import org.springframework.context.annotation.Configuration;

@Configuration
public class GreetingServiceImpl implements GreetingService {
    public GreetingServiceImpl() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Value("Good Evening")
	private String greeting;
	
	public GreetingServiceImpl(String string) {
		// TODO Auto-generated constructor stub
	}
	public String getGreeting() {
		return greeting;
	}
	public void setGreeting(String greeting) {
		this.greeting = greeting;
	}
	@Override
	public void sayHi() {
		System.out.println("Hi " +greeting);
		
	}
	

}