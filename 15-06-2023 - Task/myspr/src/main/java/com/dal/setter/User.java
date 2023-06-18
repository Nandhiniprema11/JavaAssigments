package com.dal.setter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import com.dal.setter.Car;
@Configuration
public class User {
	@Value("Nandhini Devi")
	private String Username ;
	@Autowired
	private Car car;
	
	public String getUsername() {
		return Username;
	}
	public void setUsername(String username) {
		Username = username;
	}
	public Car getCar() {
		return car;
	}
	public void setCar(Car car) {
		this.car = car;
	}
	@Override
	public String toString() {
		return "User [userName=" + Username + ", mycar=" + car + "]";
}
}

