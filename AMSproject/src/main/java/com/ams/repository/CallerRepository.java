package com.ams.repository;
import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.ams.entity.Caller;

@Repository
public interface CallerRepository extends CrudRepository<Caller, Integer>{
   List<Caller> findAllByStatus(String S);
   
   Caller findAllBycallid(int call_id);
}

