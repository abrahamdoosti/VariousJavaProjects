package com.example.enumerator;

public class Student {
	
	private String firstName;
	private String lastName;
	private Weekday day;
	public Student(String firstName, String lastName, Weekday day) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.day = day;
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
	public Weekday getDay() {
		return day;
	}
	public void setDay(Weekday day) {
		this.day = day;
	}
	@Override
	public String toString() {
		return "Student [firstName=" + firstName + ", lastName=" + lastName + ", day=" + day + "]";
	}
	
	

}
