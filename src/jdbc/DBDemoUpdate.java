package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class DBDemoUpdate {

	public static void main(String[] args) {
		
		String url = "jdbc:postgresql://localhost:5432/cgg_interns";
		String username = "postgres";
		String password = "cgg123";
	
		try {
			
			Class.forName("org.postgresql.Driver");
			
			try(Connection connection = DriverManager.getConnection(url,username,password);Statement stm = connection.createStatement()){
				//String updateCmd = "update emp set ename='AAA',salary=100000 where empid=104";
				//int cnt = stm.executeUpdate(updateCmd);
				
//				String deleteCmd = "delete from emp where ename='"+args[0]+"'";
//				int cnt = stm.executeUpdate(deleteCmd);
				
				String deleteAllCmd = "delete from emp";
				int cnt = stm.executeUpdate(deleteAllCmd);
				
				System.out.println(cnt+" row(s) deleted..");
								
			}
		}catch(Exception e) {
			e.printStackTrace();
		}

	}

}
