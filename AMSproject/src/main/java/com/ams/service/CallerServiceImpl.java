package com.ams.service;
import java.time.LocalTime;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ams.entity.Ambulance;
import com.ams.entity.Caller;
import com.ams.entity.Hospital;
import com.ams.exception.AmbulanceNotFoundException;
import com.ams.repository.CallerRepository;
import com.ams.repository.HospitalRepository;

@Service
public class CallerServiceImpl implements CallerService{
		
	@Autowired
	CallerRepository ambulanceCallerRepository;
	
		@Override
		public Caller addAmbulanceCallerDetails(Caller ac) {
		
			return ambulanceCallerRepository.save(ac);
		}
		
		@Override
		public List<Caller> listAllAmbulanceCallers() {
			
			return (List<Caller>) ambulanceCallerRepository.findAll();
		}

		@Override
		public Caller getCallerDetails() {
			List<Caller> callerList = ambulanceCallerRepository.findAllByStatus("A");
			System.out.println(callerList);
			if (callerList.isEmpty())
				throw new AmbulanceNotFoundException("Caller List is not Available", null);
			
			Caller cal = callerList.stream().filter(x->x.getStatus()=="A").findFirst().orElse(null);
			System.out.println(cal);
			cal = callerList.stream().findAny().orElse(null);
			System.out.println(cal);
			return cal;
		}
		@Override
		public Caller getCallerDetailsById(int id) {
			Caller caller= ambulanceCallerRepository.findAllBycallid(id);					
					return caller;
		}
		
	}

