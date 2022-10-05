package com.cgi.insurance.service;

import java.util.List;

import com.cgi.insurance.exception.DriverIdAlreadyExistException;
import com.cgi.insurance.exception.DriverIdNotFoundException;
import com.cgi.insurance.model.Driver;

public interface DriverService {
	
	public Driver addDriver(Driver driverObj) throws DriverIdAlreadyExistException;
	
	public List<Driver> getDriver();
	
	public boolean deleteDriver(int driverId) throws DriverIdNotFoundException;
	
	public Driver updateDriver(Driver driverUpdate) throws DriverIdNotFoundException;
	
	public Driver getDriverByTelephoneNumber(int telephoneNumber);
}
