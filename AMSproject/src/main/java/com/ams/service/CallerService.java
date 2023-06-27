package com.ams.service;

import java.util.List;

import com.ams.entity.Caller;

public interface CallerService {
	public List<Caller> listAllAmbulanceCallers();
	public Caller addAmbulanceCallerDetails(Caller ac);
	public Caller getCallerDetails();
	public Caller getCallerDetailsById(int id);
}
