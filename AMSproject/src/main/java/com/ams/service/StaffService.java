package com.ams.service;


import java.util.List;

import com.ams.entity.Staff;

public interface StaffService {

	public Staff addStaffDetails(Staff sd);
	
	public List<Staff> listAllStaffs();
}

