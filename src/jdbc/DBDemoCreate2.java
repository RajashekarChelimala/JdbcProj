package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class DBDemoCreate2 {

	public static void main(String[] args) {
		
		String url="jdbc:postgresql://localhost:5432/cgg_interns";
		String username="postgres";
		String password="cgg123";
		
		try {
			
			Class.forName("org.postgresql.Driver");
//			Connection connection = DriverManager.getConnection(url,username,password);
//			Statement stm=connection.createStatement();
			
			try(Connection connection = DriverManager.getConnection(url,username,password);Statement stm=connection.createStatement()){

				System.out.println("Connection Established...");
				
				String dropCmd="drop table if exists attachment";
				String createCmd="create table attachment(id serial primary key, filename varchar(40),filedata bytea)";
				
				stm.execute(dropCmd);
				stm.execute(createCmd);

				System.out.println("Table created...");
		
			}
			
//			String dropCmd="drop table if exists emp";
//			String createCmd="create table emp(empid int primary key,ename varchar(40),salary numeric(12,2))";
//			
//			stm.execute(dropCmd);
//			stm.execute(createCmd);
//
//			System.out.println("Table created...");
			
//			stm.close();
//			connection.close();
			
		} catch (Exception e) {
			
			e.printStackTrace();
			
		}

	}

}
