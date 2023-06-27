package com.ams.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ams.entity.Staff;
import com.ams.service.*;

@RestController
public class StaffController {

	@Autowired
	StaffService staff_service;
	
	@PostMapping("/saveStaff")
	public Staff addStaffDetails(@RequestBody Staff sd) {
		return staff_service.addStaffDetails(sd);
	}
	
	@GetMapping("/listallStaff")
	public List<Staff> listAllStaffs(){
		return staff_service.listAllStaffs();
	}
	
}
