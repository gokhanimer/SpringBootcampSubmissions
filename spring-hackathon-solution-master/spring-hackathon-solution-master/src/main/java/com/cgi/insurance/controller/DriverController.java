package com.cgi.insurance.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cgi.insurance.exception.DriverIdAlreadyExistException;
import com.cgi.insurance.exception.DriverIdNotFoundException;
import com.cgi.insurance.model.Driver;
import com.cgi.insurance.service.DriverService;

@RestController("Driver Controller")
@RequestMapping("/insurance")
public class DriverController {

	@Autowired
	DriverService service;

	@GetMapping("getDrivers")
	public ResponseEntity<?> getDriver(){
		List<Driver> driver = service.getDriver();
		return new ResponseEntity<List<Driver>>(driver, HttpStatus.OK);
	}
		
	@PostMapping("/addDriver")
	public ResponseEntity<?> addDriver(@RequestBody Driver driverObj){
		Driver res;
		try {
			res = service.addDriver(driverObj);
			return new ResponseEntity<Driver>(res,HttpStatus.CREATED);
		} catch (DriverIdAlreadyExistException e){
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.CONFLICT);			
		}
	}
	
	@PutMapping("/updateDriver")
	public ResponseEntity<?> updateDriver(@RequestBody Driver driverUpdate){
		try {
			Driver res = service.updateDriver(driverUpdate);
			return new ResponseEntity<Driver>(res,HttpStatus.OK);
		} catch (DriverIdNotFoundException e) {
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.NOT_FOUND);
		}
		 
	}
	
	@DeleteMapping("/deleteDriver/{driverId}")
	public ResponseEntity<?> deleteDriver(@PathVariable("driverId") int driverId){
		try {
		boolean b = service.deleteDriver(driverId);
		return new ResponseEntity<String>("Deleted", HttpStatus.OK);
		} catch (DriverIdNotFoundException e) {
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.NOT_FOUND);		
	}
	}
	@GetMapping("/getByPhone/{telephoneNumber}")
	public ResponseEntity<?> driverByTelephoneNumber(@PathVariable("telephoneNumber") int telephoneNumber){
		Driver res = service.getDriverByTelephoneNumber(telephoneNumber);
		if (res == null)
			return new ResponseEntity("Telephone number not found", HttpStatus.NOT_FOUND);
		else
			return new ResponseEntity(res, HttpStatus.OK);
	}
	
}
