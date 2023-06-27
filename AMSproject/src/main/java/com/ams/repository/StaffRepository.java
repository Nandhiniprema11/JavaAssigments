package com.ams.repository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.ams.entity.Staff;

@Repository
public interface StaffRepository  extends CrudRepository<Staff, Integer> {
	Staff findAllByuserName(String usrName);
}
