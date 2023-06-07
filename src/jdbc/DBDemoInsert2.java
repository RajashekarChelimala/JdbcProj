package jdbc;

import java.io.File;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class DBDemoInsert2 {

	public static void main(String[] args) {
		String url="jdbc:postgresql://localhost:5432/cgg_interns";
		String username="postgres";
		String password="cgg123";
		
		try {
			
			Class.forName("org.postgresql.Driver");
			String insertCmd = "insert into attachment(filename,filedata) values(?,?)";
			try(Connection connection = DriverManager.getConnection(url,username,password);
					PreparedStatement ps = connection.prepareStatement(insertCmd,Statement.RETURN_GENERATED_KEYS);){
				
				System.out.println("Connection Established...");
				
				File file = new File(args[0]);
				String name = file.getName();
				long length = file.length();
				
				ps.setString(1,name);
				
				FileInputStream fis = new FileInputStream(file);
				ps.setBinaryStream(2, fis, length);
				
				int cnt = ps.executeUpdate();
				
				if(cnt>0) {
					System.out.println(cnt+" row(s) inserted");
					ResultSet keys = ps.getGeneratedKeys();
					keys.next();
					int generatedKey = keys.getInt(1);
					System.out.println("Id assigned: "+ generatedKey);
					keys.close();
				}
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		

	}

}
