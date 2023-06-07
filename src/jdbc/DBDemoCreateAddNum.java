package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class DBDemoCreateAddNum {

	public static void main(String[] args) {
		
		String url="jdbc:postgresql://localhost:5432/cgg_interns";
		String username="postgres";
		String password="cgg123";
		
		try {
			Class.forName("org.postgresql.Driver");
			
			try(Connection connection = DriverManager.getConnection(url,username,password);
					Statement stm = connection.createStatement()) {
				
				String dropCmd = "drop procedure if exists spAddNum";
				String createCmd = 
						"CREATE PROCEDURE spAddNum(IN a INT, IN b INT, OUT c INT) " +
						"LANGUAGE plpgsql " +
						"AS $$ " +
						"BEGIN " +
						"c := a + b; " +
						"END $$";
				
				stm.execute(dropCmd);
				stm.execute(createCmd);
				
				System.out.println("Procedure Created Successfully..");
			}
			
		}catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			}
		

	}

}
