package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class CreateFetchSalaryFromBackend {

	public static void main(String[] args) {
		String url="jdbc:postgresql://localhost:5432/cgg_interns";
		String username="postgres";
		String password="cgg123";
		
		try {
			
			Class.forName("org.postgresql.Driver");
			
			try(Connection connection = DriverManager.getConnection(url,username,password);
					Statement stm = connection.createStatement()) {
				
				String dropCmd = "drop procedure if exists spGetSalary";
				String createCmd = 
						"CREATE PROCEDURE spGetSalary(IN a INT, OUT b NUMERIC(12,2)) " +
						"LANGUAGE plpgsql " +
						"AS $$ " +
						"BEGIN " +
						"select salary into b from emp where empid=a;" +
						"END $$";
				
				stm.execute(dropCmd);
				stm.execute(createCmd);
				
				System.out.println("Procedure Created Successfully..");
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
