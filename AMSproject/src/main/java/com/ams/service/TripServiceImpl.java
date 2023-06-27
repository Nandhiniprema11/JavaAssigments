package com.ams.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ams.entity.Trip;
import com.ams.repository.TripRepository;

@Service
public class TripServiceImpl implements TripService {

	@Autowired
	TripRepository tripRepository;
	
	
	@Override
	public Trip addTripDetails(Trip tr)
	{		
		return tripRepository.save(tr);
	}
	
	@Override
	public List<Trip> listallTrips(){
		return (List<Trip>)tripRepository.findAll();
}

	@Override
	public Trip getTripDetails(int id) {
		// TODO Auto-generated method stub
		
		return tripRepository.findAllBytripid(id);
	}
	
}
