package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class DBDemo2 {

	public static void main(String[] args) {
		
		String url="jdbc:postgresql://localhost:5432/cgg_interns";
		
		Properties properties = new Properties();
		
		properties.put("user", "postgres");
		properties.put("password", "cgg123");
		
		try {
			
			Class.forName("org.postgresql.Driver");
			try(Connection connection = DriverManager.getConnection(url,properties)){
				System.out.println("Connection Established...");
			}
			
			//System.out.println("Connection Established...");
			//Connection connection = DriverManager.getConnection(url,properties);
			//connection.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
