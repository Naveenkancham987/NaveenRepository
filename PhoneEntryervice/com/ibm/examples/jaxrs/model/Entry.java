package com.ibm.examples.jaxrs.model;

public class Entry {

	Integer id;
	Long phoneNumber;
	String firstName;
	String surName;
	String address;

	public Entry() {

	}

	public Entry(Long phoneNumber, String firstName, String surName, String address) {
		super();
		this.phoneNumber = phoneNumber;
		this.firstName = firstName;
		this.surName = surName;
		this.address = address;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Long getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(Long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getSurName() {
		return surName;
	}

	public void setSurName(String surName) {
		this.surName = surName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	
}
