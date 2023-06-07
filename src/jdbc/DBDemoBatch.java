package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class DBDemoBatch {

	public static void main(String[] args) {
		
		String url="jdbc:postgresql://localhost:5432/cgg_interns";
		String username="postgres";
		String password="cgg123";
		
		try {
			
			Class.forName("org.postgresql.Driver");
			
			try(Connection conn = DriverManager.getConnection(url,username,password); Statement stm = conn.createStatement()){
				
				stm.addBatch("insert into emp values(124, 'sss', 43000)");
				stm.addBatch("insert into emp values(125, 'ttt', 33000)");
				stm.addBatch("insert into emp values(126, 'uuu', 44000)");
				
				int [] counts;
				
				counts = stm.executeBatch();
				
				System.out.println(counts);
				
				for(int i=0;i<counts.length;i++) {
					switch(counts[i]) {
					case Statement.SUCCESS_NO_INFO:
						System.out.println("Success No Info..");
						break;
					case Statement.EXECUTE_FAILED:
						System.out.println("Execution Failed..");
						break;
					default:
						System.out.println(counts[i]+" rows(s) effected");
				
					}
				
				}
		
			}

		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}