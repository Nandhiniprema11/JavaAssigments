package com.ams.controller;

import java.util.List;

import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ams.entity.Ambulance;
import com.ams.entity.Caller;
import com.ams.service.CallerService;

@RestController
public class CallerController {

	@Autowired
	CallerService callerService;
	@Autowired
	AmbulanceController ambController;
	
	
	@PostMapping("/saveCaller")
	public Caller addAmbulanceCallerDetails(@RequestBody Caller ac) {
		Ambulance amb = ambController.listTopAmbulance();
		ac.setAmbcaller(amb);		
		amb.setStatus("NA");
		ambController.updateAmbulanceStatus(amb);
		return callerService.addAmbulanceCallerDetails(ac);
	}
	
	
	@GetMapping("/listallCaller")
	public List<Caller> listAllAmbulanceCallers() {
		return callerService.listAllAmbulanceCallers();
	}
	
	@GetMapping("/ActiveCaller")
	public Caller getCallerDetails() {
		return callerService.getCallerDetails();
	}
	
	public Caller getCallerDetailsById(int Id) {
		return callerService.getCallerDetailsById(Id);	
				
	}
	
	
	
}
