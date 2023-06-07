package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;

public class DBDemoInsertResultSetPrep {

	public static void main(String[] args) {
		String url="jdbc:postgresql://localhost:5432/cgg_interns";
		String username="postgres";
		String password="cgg123";
		
		try {
			
			Class.forName("org.postgresql.Driver");
			String query = "select * from emp";
			try(Connection conn = DriverManager.getConnection(url,username,password);
					PreparedStatement stm = conn.prepareStatement(query, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE)){
				
				
				//Scroll Sensitive is not supported in Postgres
				ResultSet rs = stm.executeQuery();
				
				ResultSetMetaData rm = rs.getMetaData();
				
				int cnt = rm.getColumnCount();
				
				int noofrows=1;
				while(rs.next()) {
					for(int i=1; i<=cnt;i++) {
						System.out.print(rs.getString(i)+"\t");
					}
					System.out.println();
					noofrows++;
					if(noofrows==2) {
						try {
							Thread.sleep(20000);
						}
						finally {
							
						}
					}
				}	
			}
					
		} catch(Exception e) {
			e.printStackTrace();
		}

	}

}
