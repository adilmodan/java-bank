package com.beans;

public class Customer {
	private String ssn, firstName, lastName, address1,
		address2, state, city, dob, lastUpdated, zipCode;
	private String id;
	private String status = "A";
	
	public String getLastUpdated() {
		return lastUpdated;
	}
	
	public void setLastUpdated(String lastUpdated) {
		this.lastUpdated = lastUpdated;
	}
	
	public String getFirstName() {
		return firstName;
	}
	
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public String getDob() {
		return dob;
	}
	
	public void setDob(String dob) {
		this.dob = dob;
	}
	
	public String getStatus() {
		return status;
	}
	
	public void setStatus(String status) {
		this.status = status;
	}
	
	public String getCity() {
		 return city;
	}
	
	public void setCity(String city) {
		this.city = city;
	}
	
	public String getId() {
		return id;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	
	public String getSsn() {
		return ssn;
	}

	
	public void setSsn(String ssn) {
		this.ssn = ssn;
	}

	public String getAddress1() {
		return address1;
	}


	public void setAddress1(String address1) {
		this.address1 = address1;
	}


	public String getAddress2() {
		return address2;
	}


	public void setAddress2(String address2) {
		this.address2 = address2;
	}


	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}


	public String getZipCode() {
		return zipCode;
	}


	public void setZip(String zipCode) {
		this.zipCode = zipCode;
	}


	// Testing purposes, delete after
	public String toString() {
		return "Details: [ ID: " + id + ", SSN: " + ssn + ", First Name: " + firstName + ", Last Name: " + lastName +
				", Date of Birth: " + dob + ", Address 1: " + address1 + ", Address 2: " + address2 +
				", State: " + state + ", city " + city + ", Zip: " + zipCode + ", Status: " + status + ", Last Updated: " + lastUpdated + "]";
	}
}
