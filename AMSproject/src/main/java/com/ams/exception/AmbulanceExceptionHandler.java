package com.ams.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;


@ControllerAdvice
public class AmbulanceExceptionHandler {

	@ExceptionHandler(value = {AmbulanceNotFoundException.class})
	public ResponseEntity<Object> handleAmbulanceNotFoundException
	(AmbulanceNotFoundException ambulanceNotFoundException)

	{

		AmbulanceException ambulanceException = new AmbulanceException(
				ambulanceNotFoundException.getMessage(),
				ambulanceNotFoundException.getCause(),
				HttpStatus.NOT_FOUND);

		return new ResponseEntity<>(ambulanceException, HttpStatus.NOT_FOUND);

	}

}
