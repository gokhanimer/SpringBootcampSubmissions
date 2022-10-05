package com.cgi.insurance.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Driver {
	
	@Id
	private int driverId;
	private String firstName;
	private int telephoneNumber;
	private String address;
	private String city;
	private String engineSize;
	private long quoteAmount;
	
	public Driver(int driverId, String firstName, int telephoneNumber, String address, String city,
			String engineSize, long quoteAmount) {
		this.driverId = driverId;
		this.firstName = firstName;
		this.telephoneNumber = telephoneNumber;
		this.address = address;
		this.city = city;
		this.engineSize = engineSize;
		this.quoteAmount = quoteAmount;
	}
	
	public Driver() {
		super();
	}

	public int getDriverId() {
		return driverId;
	}

	public void setDriverId(int driverId) {
		this.driverId = driverId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public int getTelephoneNumber() {
		return telephoneNumber;
	}

	public void setTelephoneNumber(int telephoneNumber) {
		this.telephoneNumber = telephoneNumber;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getEngineSize() {
		return engineSize;
	}

	public void setEngineSize(String engineSize) {
		this.engineSize = engineSize;
	}

	public long getQuoteAmount() {
		return quoteAmount;
	}

	public void setQuoteAmount(long quoteAmount) {
		this.quoteAmount = quoteAmount;
	}

	@Override
	public String toString() {
		return "Insurance [driverId=" + driverId + ", firstName=" + firstName + ", telephoneNumber=" + telephoneNumber
				+ ", address=" + address + ", city=" + city + ", engineSize=" + engineSize + ", quoteAmount="
				+ quoteAmount + "]";
	}
	

}
