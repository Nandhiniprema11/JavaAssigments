package com.ams.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ams.entity.Staff;
import com.ams.repository.StaffRepository;

@Service
public class StaffServiceImpl implements StaffService{
	
	
	@Autowired
	StaffRepository sr;
	
	@Override
	public Staff addStaffDetails(Staff sd) {
		return sr.save(sd);
	}
	
	@Override
	public List<Staff> listAllStaffs(){		
		return (List<Staff>) sr.findAll();
	}


}



