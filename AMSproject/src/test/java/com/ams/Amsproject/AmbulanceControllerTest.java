package com.ams.Amsproject;

//import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.intThat;


import static org.junit.jupiter.api.Assertions.assertEquals;

import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import org.springframework.beans.factory.annotation.Autowired;

import com.ams.controller.*;
import com.ams.entity.Ambulance;
import com.ams.service.AmbulanceService;
import com.ams.service.AmbulanceServiceImpl;
public class AmbulanceControllerTest {
	
	@InjectMocks
	AmbulanceController ambulanceController;
	
	@Mock
	AmbulanceService ambulanceService;
	
	@Mock
	AmbulanceServiceImpl ambulanceServiceImpl;
	//
	 @BeforeEach
	    public void setUp() {
	        MockitoAnnotations.openMocks(this);
	      
	    }
	 
	 @Test
	public void testSample(){
		 String result = ambulanceController.Sample();
		 
		 assertEquals("Testing", result);
	 }
	 
	

	@Test
	public void testgetAmbulanceDetailsById() {
		Ambulance ambulanceExpected=new Ambulance();
		ambulanceExpected.setAmbid(2);
		ambulanceExpected.setCapacity(4);
		ambulanceExpected.setModel("aaa"); 
		ambulanceExpected.setReg_no(1);
		ambulanceExpected.setStatus("A");
		
		Ambulance ambulanceresult = ambulanceController.getAmbulanceDetailsById(102);
		
		
		
		
		assertEquals(ambulanceExpected, ambulanceresult);
	}
	
}
