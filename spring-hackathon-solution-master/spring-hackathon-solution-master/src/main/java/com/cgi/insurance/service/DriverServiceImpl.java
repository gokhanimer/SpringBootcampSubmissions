package com.cgi.insurance.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cgi.insurance.exception.DriverIdAlreadyExistException;
import com.cgi.insurance.exception.DriverIdNotFoundException;
import com.cgi.insurance.model.Driver;
import com.cgi.insurance.repo.DriverRepo;

@Service
public class DriverServiceImpl implements DriverService{
	
	@Autowired
	DriverRepo repo;
	@Override
	public Driver addDriver(Driver driverObj) throws DriverIdAlreadyExistException {
		Optional<Driver> optDriver = repo.findById(driverObj.getDriverId());
		if(optDriver.isEmpty()) {
			repo.save(driverObj);
			return driverObj;
		}
		else throw new DriverIdAlreadyExistException("Driver ID already exists");
	}

	@Override
	public List<Driver> getDriver() {
		return repo.findAll();
	}

	@Override
	public boolean deleteDriver(int driverId) throws DriverIdNotFoundException {
		Optional<Driver> optDriver = repo.findById(driverId);
		if(optDriver.isPresent()) {
			repo.deleteById(driverId);
			return true;
		}
		else throw new DriverIdNotFoundException("Not able to find Driver ID");
	}

	@Override
	public Driver updateDriver(Driver driverUpdate) throws DriverIdNotFoundException {
		Optional<Driver> optDriver = repo.findById(driverUpdate.getDriverId());
		if (optDriver.isPresent()) {
			repo.save(driverUpdate);
			return driverUpdate;
		}
		else throw new DriverIdNotFoundException("Not able to find Driver ID");
	}

	@Override
	public Driver getDriverByTelephoneNumber(int telephoneNumber) {
		Driver driverPhone=repo.findByTelephoneNumber(telephoneNumber);
		return driverPhone;
	}

}
