package jdbc;

import java.io.File;
import java.io.FileOutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DBDemoSelectBytes {

	public static void main(String[] args) {
		String url="jdbc:postgresql://localhost:5432/cgg_interns";
		String username="postgres";
		String password="cgg123";
		
		try {
			
			Class.forName("org.postgresql.Driver");
			String cmd = "select filename,filedata from attachment where id=?";
			try(Connection connection = DriverManager.getConnection(url,username,password);
					PreparedStatement ps = connection.prepareStatement(cmd);){
				
					ps.setInt(1, Integer.parseInt(args[0]));
					ResultSet rs = ps.executeQuery();
					
					String saveDir = "./temp";
					
					while(rs.next()) {
						String fileName = rs.getString("filename");
						
						File file = new File(saveDir,fileName);
						FileOutputStream fos = new FileOutputStream(file);
						byte[] data = rs.getBytes("filedata");
						fos.write(data);
						fos.flush();
						fos.close();
						System.out.println("File saved as: "+file.getCanonicalPath());
					}
					rs.close();
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}

}
