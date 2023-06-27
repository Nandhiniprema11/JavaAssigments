package com.ams.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ams.entity.Ambulance;
import com.ams.service.AmbulanceService;

@RestController
public class AmbulanceController {

	@Autowired
	AmbulanceService ambulanceService;

	@GetMapping("/amb")
	public String Sample() {
		return "Testing";
	}
	//@PreAuthorize("hasAuthority('admin')")
	@PostMapping("/saveAmbulance")
	public Ambulance addAmbulanceDetails(@RequestBody Ambulance amb)  {
		return ambulanceService.addAmbulanceDetails(amb);
	}	
	
	public Ambulance updateAmbulanceStatus(Ambulance amb) {
		return ambulanceService.addAmbulanceDetails(amb);
	}
	@GetMapping("/listallAmbulance")
	public List<Ambulance> listAllAmbulance() {
		return ambulanceService.listAllAmbulance();
	}
	
	@GetMapping("/listAvailableAm")
	public List<Ambulance> availableAmb() {
		return ambulanceService.availableAmb();
	}
	
	@GetMapping("/listTopAmbulance")
	public Ambulance listTopAmbulance() {
		return ambulanceService.listTopAmbulance();
	}
	
	public Ambulance getAmbulanceDetailsById(int Id) {
		return ambulanceService.getAmbulanceDetailsById(Id);
	}

	
	}
