package com.ams.service;

import java.util.List;
import org.springframework.stereotype.Service;
import com.ams.entity.Ambulance;


@Service
public interface AmbulanceService {
	
    public Ambulance addAmbulanceDetails(Ambulance amb);
    public List<Ambulance> listAllAmbulance();
	public List<Ambulance>  availableAmb();
	public Ambulance listTopAmbulance();
	public Ambulance getAmbulanceDetailsById(int Id);
}


