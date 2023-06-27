package com.ams.repository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.ams.entity.Trip;

@Repository
public interface TripRepository extends CrudRepository<Trip, Integer> {
	Trip findAllBytripid(int ID);
}

