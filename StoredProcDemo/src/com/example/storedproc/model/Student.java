package com.example.storedproc.model;

public class Student {

	private int id;
	private String fName;
	private String lName;
	private int age;
	private int courseId;

	public Student() {

	}

	public Student(int id, String fName, String lName, int age, int courseId) {
		super();
		this.id = id;
		this.fName = fName;
		this.lName = lName;
		this.age = age;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getfName() {
		return fName;
	}

	public void setfName(String fName) {
		this.fName = fName;
	}

	public String getlName() {
		return lName;
	}

	public void setlName(String lName) {
		this.lName = lName;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getCourseId() {
		return courseId;
	}

	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}

public String toString(){
	return new StringBuilder().append(" \n Id: "+this.getId()+"\n").
			 append(" First Name: "+this.getfName()+"\n")
			.append(" Last Name: "+this.getlName()+"\n")
			.append(" Age: "+this.getAge()+"\n")
			.append(" Course Id: "+this.getCourseId()+"\n").toString();
}
}
