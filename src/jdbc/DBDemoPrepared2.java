package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

public class DBDemoPrepared2 {
	
	static ResultSet rs;
	static int cnt;
	
	public static void displayColumnHeading() throws SQLException {
		ResultSetMetaData rm = rs.getMetaData();
		cnt = rm.getColumnCount();
		
		for(int i=1;i<=cnt;i++) {
			System.out.print(rm.getColumnName(i)+"\t");
		}
		System.out.println();
	}
	
	public static void displayData() throws SQLException {
		while(rs.next()) {
			for(int i=1;i<=cnt;i++) {
				System.out.print(rs.getString(i)+"\t");
			}
			System.out.println();
		}
	}

	public static void main(String[] args) {
		String url="jdbc:postgresql://localhost:5432/cgg_interns";
		String username="postgres";
		String password="cgg123";
		
		try {
			
//			Class.forName("org.postgresql.Driver");
//			String query = "select * from emp where empid=?";
//			try(Connection connection = DriverManager.getConnection(url,username,password);
//					PreparedStatement stm = connection.prepareStatement(query)){
//				
//				stm.setInt(1, 120);
//				ResultSet rs = stm.executeQuery();
//				
//				ResultSetMetaData rm = rs.getMetaData();
//				int cnt = rm.getColumnCount();
//				
//				for(int i=1;i<=cnt;i++) {
//					System.out.print(rm.getColumnName(i)+"\t");
//				}
//				System.out.println();
//				
//				while(rs.next()) {
//					for(int i=1;i<=cnt;i++) {
//						System.out.print(rs.getString(i)+"\t");
//					}
//					System.out.println();
//				}
//				rs.close();
//				
//			}
			
			Class.forName("org.postgresql.Driver");
			String query = "select * from emp where empid=?";
			try(Connection connection = DriverManager.getConnection(url,username,password);
					PreparedStatement stm = connection.prepareStatement(query)){
				
				stm.setInt(1, 120);
				rs = stm.executeQuery();
				
				displayColumnHeading();
				displayData();
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
