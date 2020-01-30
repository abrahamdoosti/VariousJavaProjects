package com.abraham;

import java.util.Date;

public class ShallowCopy {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Student student1 = new Student();
		Address address1=new Address("1234 test dr  ",23412);
		Address address2=new Address("1235 xyz St  ",23456);
		student1.setName("Abebe");		
		student1.setBirthdate(new Date());
		student1.setAddress(address1);
		System.out.println("Before clone\nstudent1 Address "+ student1.getAddress().getZipcode());
		
		try {
			Thread.sleep(1000);
			Student student2 = (Student) student1.clone();
			//student2.setBirthdate(new Date());
			student2.getAddress().setZipcode(1111);
			System.out.println("student1 Address "+ student1.getAddress().getZipcode());
			System.out.println("student2 Address "+ student2.getAddress().getZipcode());
		} catch (CloneNotSupportedException | InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
