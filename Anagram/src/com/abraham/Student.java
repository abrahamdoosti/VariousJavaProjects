package com.abraham;

import java.util.Date;

public class Student implements Cloneable {
	private String name;
	private Date birthdate;
	private Address address;

	public Student() {
		
	}

	public Student(String name2, Date birthdate2) {
		// TODO Auto-generated constructor stub
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}	

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getBirthdate() {
		return birthdate;
	}

	public void setBirthdate(Date birthdate) {
		this.birthdate = birthdate;
	}

	@Override
	public Object clone() throws CloneNotSupportedException {
		Student stu=new Student(this.name,this.birthdate);
		Address address=new Address(this.getAddress().getStreet(), this.getAddress().getZipcode());
		stu.setAddress(address);
		return stu;
	}

}
