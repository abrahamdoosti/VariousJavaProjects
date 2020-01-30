package jdbcDemoMySql;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Driver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//statement();
		 //preparedStatement();
		callableStatement();

	}

	public static void statement() {
		Connection connection = null;
		Statement stmt = null;
		String url = "jdbc:mysql://localhost:3306/studentdb";
		String user = "root";
		String password = "abc@123";
		try {
			Class.forName("com.mysql.jdbc.Driver");
			// 1. get a connection object(throws SQL exception)
			connection = DriverManager.getConnection(url, user, password);

			// 2.create a statment
			stmt = connection.createStatement();
			String insert = "insert into student(first_Name,last_Name,course_id) values('abraham','Berhe','2001')";
			String update = "update student set last_Name='Birhanu' where student_id=4";
			String delete = "delete from student where student_id=16";
			// 3. execute statement
			// ResultSet result=stmt.executeQuery("select * from student");
			int rowsaffected = stmt.executeUpdate(update);

			// 4 process result set
			// while(result.next()){
			// System.out.println(result.getInt("student_id")+" ,
			// "+result.getString("first_Name")+" ,
			// "+result.getString("last_Name")+" ,
			// "+result.getLong("course_id"));
			//
			// }
			System.out.println("number of rows affected = " + rowsaffected);

		} catch (SQLException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static void preparedStatement() {
		Connection connection = null;
		PreparedStatement stmt = null;
		String url = "jdbc:mysql://localhost:3300/studentdb";
		String user = "root";
		String password = "abc@123";
		try {
			Class.forName("com.mysql.jdbc.Driver");
			// 1. Get a connection object(throws SQL exception)
			connection = DriverManager.getConnection(url, user, password);

			// 2.Create a prepared statment
			String sqlSelect = "select * from student where last_Name=? and course_id=?";
			stmt = connection.prepareStatement(sqlSelect);
			stmt.setString(1, "Berhe");
			stmt.setInt(2, 2001);

			// String sqlInsert="insert into
			// student(first_Name,last_Name,course_id)
			// values('abraham','Berhe','2001')";
			// String sqlUpdate="update student set first_Name='Abebe' where
			// student_id=16";
			// String sqlDelete="delete from student where student_id=16";
			// 3. Execute statement
			ResultSet result = stmt.executeQuery();

			// 4 Process result set
			while (result.next()) {
				System.out.println(result.getInt("student_id") + "  ,  " + result.getString("first_Name") + "  ,  "
						+ result.getString("last_Name") + "  ,  " + result.getLong("course_id"));

			}

			System.out.println("Prepared statement being reused");
			stmt.setString(1, "Birhanu");
			stmt.setInt(2, 1002);
			result=stmt.executeQuery();
			while (result.next()) {
				System.out.println(result.getInt("student_id") + "  ,  " + result.getString("first_Name") + "  ,  "
						+ result.getString("last_Name") + "  ,  " + result.getLong("course_id"));

			}

		} catch (SQLException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	public static void callableStatement() {
		Connection connection = null;
		CallableStatement stmt = null;
		String url = "jdbc:mysql://localhost:3300/studentdb";
		String user = "root";
		String password = "abc@123";
		try {
			Class.forName("com.mysql.jdbc.Driver");
			// 1. Get a connection object(throws SQL exception)
			connection = DriverManager.getConnection(url, user, password);

			// 2.Create a prepared statment
			String sql = "{call increase_salaries_for_department(?,?)}";
			stmt = connection.prepareCall(sql);
			stmt.setString(1, "Engineering");
			stmt.setDouble(2, 10000);

			// String sqlInsert="insert into
			// student(first_Name,last_Name,course_id)
			// values('abraham','Berhe','2001')";
			// String sqlUpdate="update student set first_Name='Abebe' where
			// student_id=16";
			// String sqlDelete="delete from student where student_id=16";
			// 3. Execute statement
			stmt.execute();

			// 4 Process result set

		} catch (SQLException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
