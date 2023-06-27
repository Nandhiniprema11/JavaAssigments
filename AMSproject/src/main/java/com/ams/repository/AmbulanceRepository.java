package com.ams.repository;
import java.util.List;

import org.springframework.data.repository.CrudRepository;



import org.springframework.stereotype.Repository;

import com.ams.entity.Ambulance;

@Repository
public interface AmbulanceRepository extends CrudRepository<Ambulance, Integer>{
	List<Ambulance> findAllBystatus(String status);
	Ambulance findAllByambid(int ambid);
}


