package com.example.storedproc.main;

import java.util.List;

import com.example.storedproc.db.DBService;
import com.example.storedproc.model.Student;

public class MainApplication {

	public static void main(String[] args) {

		// TODO Auto-generated method stub
		DBService dbService = DBService.getDBServiceInstance();
		//dbService.createStudents();
		for(int i=4;i<22;i++){
			dbService.deleteStudent(i);
		}
		//dbService.updateStudent(22, "Abel", "Tilaye", 23, 1234);
		List<Student> allStudents = dbService.getAllStudents();
		System.out.println(allStudents);
		//System.out.println(dbService.getStudent(2));
		//System.out.println("New Student id : "+ dbService.createStudent("John","Doe",21,1021));
	}

}
