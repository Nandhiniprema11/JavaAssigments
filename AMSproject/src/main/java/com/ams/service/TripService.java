package com.ams.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ams.entity.Trip;

@Service
public interface TripService  {


	public Trip addTripDetails(Trip tr);
	
	public List<Trip> listallTrips();
	public Trip getTripDetails(int id);
}




