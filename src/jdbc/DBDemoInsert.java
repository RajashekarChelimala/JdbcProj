package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class DBDemoInsert {

	public static void main(String[] args) {
		String url="jdbc:postgresql://localhost:5432/cgg_interns";
		String username="postgres";
		String password="cgg123";
		
		try {
			
			Class.forName("org.postgresql.Driver");
			
			try(Connection connection = DriverManager.getConnection(url,username,password);Statement stm = connection.createStatement();){
				
				System.out.println("Connection Established...");
				
				int empno = Integer.parseInt(args[0]);
				String ename = args[1];
				double salary = Double.parseDouble(args[2]);
				
				String insertCmd = "insert into emp values("+empno+",'"+ename+"',"+salary+")";
				
				int cnt = stm.executeUpdate(insertCmd);
				
				System.out.println(cnt+" row(s) inserted");
			}
			
//			Connection connection = DriverManager.getConnection(url,username,password);
//			Statement stm = connection.createStatement();
//			
//			int empno = Integer.parseInt(args[0]);
//			String ename = args[1];
//			double salary = Double.parseDouble(args[2]);
//			
//			String insertCmd = "insert into emp values("+empno+",'"+ename+"',"+salary+")";
//			
//			int cnt = stm.executeUpdate(insertCmd);
//			
//			System.out.println(cnt+" row(s) inserted");
//			
//			stm.close();
//			connection.close();
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		

	}

}
