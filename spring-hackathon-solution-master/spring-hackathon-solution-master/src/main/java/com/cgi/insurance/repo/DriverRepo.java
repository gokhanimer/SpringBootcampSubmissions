package com.cgi.insurance.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cgi.insurance.model.Driver;

@Repository
public interface DriverRepo extends JpaRepository<Driver, Integer>{
	
	Driver findByTelephoneNumber(int telephoneNumber);

}
