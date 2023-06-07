package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DBDemoInsertResultSet {

	public static void main(String[] args) {
		String url="jdbc:postgresql://localhost:5432/cgg_interns";
		String username="postgres";
		String password="cgg123";
		
		try {
			
			Class.forName("org.postgresql.Driver");
			String query = "select * from emp";
			try(Connection conn = DriverManager.getConnection(url,username,password);
					Statement stm = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE)){
				
				ResultSet rs = stm.executeQuery(query);
				
				rs.moveToInsertRow();
				
				rs.updateInt(1,400);
				rs.updateString(2,"ghi");
				rs.updateDouble(3,90000);
				
				rs.insertRow();
				rs.moveToCurrentRow();
				
			}
					
		} catch(Exception e) {
			e.printStackTrace();
		}

	}

}
