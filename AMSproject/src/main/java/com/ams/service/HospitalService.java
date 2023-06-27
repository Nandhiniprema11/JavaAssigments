package com.ams.service;
import com.ams.entity.Hospital;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public interface HospitalService {
	public Hospital addHospitalDetails(Hospital hd);
	public List<Hospital> listAllHospital();
}



