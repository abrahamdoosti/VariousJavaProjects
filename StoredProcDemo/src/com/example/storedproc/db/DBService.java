package com.example.storedproc.db;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.example.storedproc.model.Student;

public class DBService {
	private Connection connection;
	private PreparedStatement stmt;
	private CallableStatement callStmt;
	private ResultSet rs;
	private static DBService dbService = null;
	private String url = "jdbc:sqlserver://localhost:1433;databaseName=StoredProcDemo";
	private String user = "sa";
	private String password = "mumsql";

	public static DBService getDBServiceInstance() {
		if (dbService != null) {
			return dbService;
		}
		return new DBService();
	}

	private DBService() {
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			connection = DriverManager.getConnection(url, user, password);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public List<Student> getAllStudents() {
		List<Student> studentList = new ArrayList<>();
		String sql = "select * from tbl_student";
		try {
			stmt = connection.prepareStatement(sql);
			rs = stmt.executeQuery();
			while (rs.next()) {
				Student student = new Student();
				student.setId(rs.getInt(1));
				student.setfName(rs.getString(2));
				student.setlName(rs.getString(3));
				student.setAge(rs.getInt(4));
				student.setCourseId(rs.getInt(5));
				studentList.add(student);

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return studentList;

	}

	public Student getStudent(int id) {
		Student student = null;
		String sql = "{call getStudentById(?)}";
		try {
			callStmt = connection.prepareCall(sql);
			callStmt.setInt(1, 2);
			rs = callStmt.executeQuery();
			student = new Student();
			if (rs.next()) {
				student.setId(rs.getInt(1));
				student.setfName(rs.getString(2));
				student.setlName(rs.getString(3));
				student.setAge(rs.getInt(4));
				student.setCourseId(rs.getInt(5));
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return student;
	}

	public void createStudents() {
		String sql = "insert into tbl_student (fName,lName,age,courseId) values(?,?,?,?)";

		try {
			stmt = connection.prepareStatement(sql);
			stmt.setString(1, "Abel");
			stmt.setString(2, "Tilaye");
			stmt.setInt(3, 19);
			stmt.setInt(4, 1001);
			stmt.executeUpdate();
			stmt.setString(1, "Kebede");
			stmt.setString(2, "Demisew");
			stmt.setInt(3, 39);
			stmt.setInt(4, 1011);
			stmt.executeUpdate();
			stmt.setString(1, "Saron");
			stmt.setString(2, "Chala");
			stmt.setInt(3, 29);
			stmt.setInt(4, 1012);
			stmt.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public int createStudent(Student student) {
		String sql = "{call insertNewStudent(?,?,?,?)}";
		int newStudentId = 0;
		try {
			callStmt.registerOutParameter(1, newStudentId);
			callStmt = connection.prepareCall(sql);
			callStmt.setString(1, student.getfName());
			callStmt.setString(2, student.getlName());
			callStmt.setInt(3, student.getAge());
			callStmt.setInt(4, student.getCourseId());
			callStmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return newStudentId;
	}

	public int createStudent(String firstName, String lastName, int age, int courseCode) {
		// TODO Auto-generated method stub
		String sql = "{call insertNewStudent(?,?,?,?,?)}";
		int newStudentId=-1;
		try {			
			callStmt = connection.prepareCall(sql);			
			callStmt.setString(1, firstName);
			callStmt.setString(2, lastName);
			callStmt.setInt(3, age);
			callStmt.setInt(4, courseCode);
			callStmt.registerOutParameter(5, java.sql.Types.INTEGER);
			callStmt.execute();
			newStudentId=callStmt.getInt(5);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return newStudentId;
		
	}
	
	public boolean updateStudent(int id,String firstName, String lastName, int age, int courseCode) {
		// TODO Auto-generated method stub
		String sql = "{call updateStudenById(?,?,?,?,?)}";
		 boolean updateStatus=false;
		try {			
			callStmt = connection.prepareCall(sql);	
			callStmt.setInt(1, id);
			callStmt.setString(2, firstName);
			callStmt.setString(3, lastName);
			callStmt.setInt(4, age);
			callStmt.setInt(5, courseCode);			
			updateStatus=callStmt.execute();			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return updateStatus;
		
	}
	
	public boolean deleteStudent(int id) {
		// TODO Auto-generated method stub
		String sql = "{call deleteStudentById(?)}";
		 boolean updateStatus=false;
		try {			
			callStmt = connection.prepareCall(sql);	
			callStmt.setInt(1, id);					
			updateStatus=callStmt.execute();			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return updateStatus;
		
	}
}
