package jdbc;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Types;

public class DBDemoCallAddNum {

	public static void main(String[] args) {
		
		String url="jdbc:postgresql://localhost:5432/cgg_interns";
		String username="postgres";
		String password="cgg123";
		
		try {
			Class.forName("org.postgresql.Driver");
			String sql = "call spAddNum(?,?,?)";
			
			try(Connection connection = DriverManager.getConnection(url,username,password);
					CallableStatement cs = connection.prepareCall(sql)) {
				
				cs.setInt(1, Integer.parseInt(args[0]));
				cs.setInt(2, Integer.parseInt(args[1]));
				
				cs.registerOutParameter(3, Types.INTEGER);
				
				cs.execute();
				
				int result = cs.getInt(3);
				
				System.out.println("Sum = "+result);
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		

	}

}
