package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class DBDemoCommit {

	public static void main(String[] args) {
		String url="jdbc:postgresql://localhost:5432/cgg_interns";
		String username="postgres";
		String password="cgg123";
		
		try {
			Class.forName("org.postgresql.Driver");
			String cmd = "delete from emp where empid=?";
			
			try(Connection conn = DriverManager.getConnection(url,username,password);
					PreparedStatement ps = conn.prepareStatement(cmd)) {
				conn.setAutoCommit(false);
				
				ps.setInt(1, Integer.parseInt(args[0]));
				
				int count = ps.executeUpdate();
				
				if(count>0) {
					System.out.println("Employee deleted..");
				}
				else {
					System.out.println("No such Employee..");
				}
				
				conn.commit();
				System.out.println("Transaction Committed..");
				conn.setAutoCommit(true);
				
			} 
		} catch (Exception e) {
			e.printStackTrace();
		}
		

	}

}
