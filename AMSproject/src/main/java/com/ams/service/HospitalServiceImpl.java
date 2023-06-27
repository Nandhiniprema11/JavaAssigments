package com.ams.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ams.entity.Hospital;
import com.ams.repository.HospitalRepository;

@Service
public class HospitalServiceImpl implements HospitalService {
	
	@Autowired
	HospitalRepository hospitalRepository;
	
	@Override
	public Hospital addHospitalDetails(Hospital hd)
	{
		return hospitalRepository.save(hd);
	}
	@Override
	public List<Hospital> listAllHospital() {	
		
		return (List<Hospital>) hospitalRepository.findAll();
	}
	
	
}
