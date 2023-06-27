package com.ams.repository;

import org.springframework.data.repository.CrudRepository;


import org.springframework.stereotype.Repository;

import com.ams.entity.Hospital;

@Repository
public interface HospitalRepository extends CrudRepository<Hospital, Integer>{

}
