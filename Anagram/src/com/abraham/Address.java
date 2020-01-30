package com.abraham;

public class Address {
	private String Street;
	private int zipcode;

	public Address() {
	}

	public Address(String street, int zipcode) {
		super();
		Street = street;
		this.zipcode = zipcode;
	}

	public String getStreet() {
		return Street;
	}

	public void setStreet(String street) {
		Street = street;
	}

	public int getZipcode() {
		return zipcode;
	}

	public void setZipcode(int zipcode) {
		this.zipcode = zipcode;
	}
}
