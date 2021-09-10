import java.sql.Connection;
import java.sql.SQLException;

public class Program {

	public static void main(String[] args) {

		try {
			
			Connection conn = Database.getConnection();
			Database.printSessionInfo(conn);
			Thread.sleep(10000); // for testing with Activity Monitor in SQL Server Management Studio
			System.out.println("Done!");
			
		} catch (SQLException | InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}	
}
