package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.postgresql.Driver;

public class DBDemo {

	public static void main(String[] args) {
		String url="jdbc:postgresql://localhost:5432/cgg_interns";
		String username="postgres";
		String password="cgg123";
		
		//Way 1. Register Driver with DriverManager class
		
//		try {
//			
//			Class.forName("org.postgresql.Driver");
//			
//			//getConnection object
//			Connection connection = DriverManager.getConnection(url,username,password);
//			System.out.println("Connection Established...");
//			
//			connection.close();
//			
//			
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
		
		
		
		//Way 2. Register Driver with DriverManager
		
		try {
			DriverManager.registerDriver(new Driver());
			Connection connection = DriverManager.getConnection(url,username,password);
			System.out.println("Connection Established...");
			
			connection.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

}
