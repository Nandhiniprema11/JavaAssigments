package com.ams.service;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ams.entity.Ambulance;
import com.ams.exception.AmbulanceNotFoundException;
import com.ams.repository.AmbulanceRepository;//To implement the operation

@Service
public class AmbulanceServiceImpl implements AmbulanceService {

	@Autowired
	AmbulanceRepository ambulanceRepository;

	@Override
	public Ambulance addAmbulanceDetails(Ambulance amb) {

		return ambulanceRepository.save(amb);
	}

	@Override
	public List<Ambulance> listAllAmbulance() {
		return (List<Ambulance>) ambulanceRepository.findAll();
	}

	
	public List<Ambulance> listAvailableAmbulance() {
		List<Ambulance> li = new ArrayList<>();
		li = (List<Ambulance>) ambulanceRepository.findAllBystatus("NA");
		if (li.isEmpty())
			throw new AmbulanceNotFoundException("Ambulance11 List is not Available", null);	
		System.out.println(li);
		return (List<Ambulance>) ambulanceRepository.findAllBystatus("NA");

	}
	
	@Override
	public List<Ambulance>  availableAmb() {
		List<Ambulance> amblist= ambulanceRepository.findAllBystatus("A");
		if (amblist.isEmpty())
			throw new AmbulanceNotFoundException("Ambulance List is not Available", null);		
		System.out.println(amblist);
		return amblist;
	}

	@Override
	public Ambulance listTopAmbulance() {
		// TODO Auto-generated method stub
		List<Ambulance> amblist= ambulanceRepository.findAllBystatus("A");
		System.out.println(amblist);
		Ambulance amb = amblist.stream().filter(x->x.getCapacity()>0).findFirst().orElse(null);
		return amb;
	}

	@Override
	public Ambulance getAmbulanceDetailsById(int Id) {
		// TODO Auto-generated method stub
		Ambulance ambulance = ambulanceRepository.findAllByambid(Id);
		return ambulance ;
	}
	
	

}
