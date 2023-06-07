package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;

public class DemoResultSetMetaData {

	public static void main(String[] args){
		
		String url="jdbc:postgresql://localhost:5432/cgg_interns";
		String username="postgres";
		String password="cgg123";
		
		try {
			Class.forName("org.postgresql.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String query = "select * from emp where empid=?";
		try(Connection connection = DriverManager.getConnection(url,username,password);
				PreparedStatement stm = connection.prepareStatement(query)){
			
			stm.setInt(1, 120);
			ResultSet rs = stm.executeQuery();
			
			ResultSetMetaData rm = rs.getMetaData();
			int cnt = rm.getColumnCount();
			
			for(int i=1;i<=cnt;i++) {
				System.out.print(rm.getColumnName(i)+"\t");
				System.out.print(rm.getColumnType(i)+"\t");
				System.out.print(rm.getColumnTypeName(i)+"\t");
				System.out.println(rm.getColumnClassName(i)+"\t");
			}
			
			rs.close();
			
		} catch(Exception e) {
			e.printStackTrace();
		}

	}

}
