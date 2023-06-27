package com.ams.controller;

import java.sql.Timestamp;

import java.sql.Date;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.core.Local;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ams.entity.Ambulance;
import com.ams.entity.Caller;
import com.ams.entity.Trip;
import com.ams.service.TripService;

@RestController
public class TripController {

	@Autowired
	TripService tripService;
	@Autowired
	CallerController callerCont;
	@Autowired
	AmbulanceController ambcont;
	
	int tripid;
	
	@PostMapping("/StartTrip")
	public Trip addTripDetails(@RequestBody Trip tr)
	{
		Caller call = callerCont.getCallerDetails();
		System.out.println(call);
		tr.setCallerId(call); 
		tr.setCall_timestamp(call.getCall_timestamp());
		tr.setSttimestamp(call.getCall_timestamp()); //need to add +5min
		tr.setAmbtrip(call.getAmbcaller());
		return tripService.addTripDetails(tr);
	}
	
	@PostMapping("/EndTrip")
	public Trip EndTripDetails(int id,int toT) {
		Trip tr= tripService.getTripDetails(id);
		Timestamp tmpp=Timestamp.valueOf(tr.getCall_timestamp().toString());
		tmpp.setTime(tmpp.getTime()+TimeUnit.MINUTES.toMillis(toT));
		//LocalTime eTime = LocalTime.parse(tr.getCall_timestamp().toString()).plusMinutes(toT);
		tr.setEdimestamp(tmpp);
		tr.setTripstatus("C");
		Caller caller = callerCont.getCallerDetailsById(tr.getCallerId().getCallid());
		caller.setStatus("C");
		
		Ambulance ambulance = ambcont.getAmbulanceDetailsById(tr.getAmbtrip().getAmbid());
		ambulance.setStatus("A");
		ambcont.addAmbulanceDetails(ambulance);
		callerCont.addAmbulanceCallerDetails(caller);
		return tripService.addTripDetails(tr);
	}
	
	
	@GetMapping("/listAllTrips")
	public List<Trip> listallTrips(){
		return tripService.listallTrips();

	}
	
}
