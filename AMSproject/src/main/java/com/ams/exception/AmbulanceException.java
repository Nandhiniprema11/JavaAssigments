package com.ams.exception;

import org.springframework.http.HttpStatus;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString

public class AmbulanceException {
	
	private final String message;
	private Throwable throwable;
	private HttpStatus httpStatus;
	
	public AmbulanceException(String message, Throwable throwable, HttpStatus httpStatus) {
		super();
		this.message = message;
		this.throwable = throwable;
		this.httpStatus = httpStatus;
	}

	

}
