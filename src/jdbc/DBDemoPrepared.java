package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class DBDemoPrepared {

	public static void main(String[] args) {
		String url="jdbc:postgresql://localhost:5432/cgg_interns";
		String username="postgres";
		String password="cgg123";
		
		try {
			
			Class.forName("org.postgresql.Driver");
			
			try(Connection connection = DriverManager.getConnection(url,username,password);
					PreparedStatement stm = connection.prepareStatement("insert into emp values(?,?,?)")){
				
				stm.setInt(1, 120);
				stm.setString(2,"pqr");
				stm.setDouble(3,35000);
				
				int cnt = stm.executeUpdate();
				System.out.println(cnt+" row(s) inserted");
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
