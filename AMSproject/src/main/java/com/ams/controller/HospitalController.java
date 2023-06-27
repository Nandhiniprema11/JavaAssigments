package com.ams.controller;

import java.util.List;


import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.ams.entity.Hospital;
import com.ams.service.HospitalService;

@RestController
public class HospitalController {
		@Autowired
		HospitalService hospitalService;

		@PostMapping("/savehospital")
		public Hospital addHospitalDetails(@RequestBody Hospital hd) {
			return hospitalService.addHospitalDetails(hd);
		}

			@GetMapping("/listallHospital")
		public List<Hospital> listAllHospital() {
			return hospitalService.listAllHospital();
		}

			}


