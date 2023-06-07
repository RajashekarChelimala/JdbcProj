package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;

public class DBDemoSelect {

	public static void main(String[] args) {
		String url = "jdbc:postgresql://localhost:5432/cgg_interns";
		String username = "postgres";
		String password = "cgg123";
		
		try {
			
			Class.forName("org.postgresql.Driver");
			String query = "select * from emp order by salary asc";
			
			//ResultSet is a Resource Soo.. put in the trywithresource
			
			try(Connection connection = DriverManager.getConnection(url,username,password);
			Statement stm = connection.createStatement();ResultSet rs = stm.executeQuery(query);){
				
				ResultSetMetaData rm = rs.getMetaData();
				int cols = rm.getColumnCount();
				
				for(int i=1;i<=cols;i++) {
					System.out.print(rm.getColumnName(i)+"\t");
				}
				System.out.println("\n---------------------------");
				
//				while(rs.next()) {
//					System.out.println(rs.getInt("empid")+"\t"+rs.getString("ename")+"\t"+rs.getDouble("salary"));
//					System.out.println("---------------------------");
//				}
				
				while(rs.next()) {
					for(int i=1;i<=cols;i++) {
						System.out.print(rs.getString(i)+"\t");
					}
					System.out.println("\n---------------------------");
				}
				
			}
			
		} catch(Exception e) {
			e.printStackTrace();
		}

	}

}
