import java.sql.*;
import com.microsoft.sqlserver.jdbc.*;

public abstract class Database {

	public static Connection getConnection() throws SQLServerException {

		SQLServerDataSource ds = new SQLServerDataSource();
		ds.setUser("companyuser");
		ds.setPassword("ThisIsALongPassword");
		ds.setServerName("localhost\\sqlexpress");
		ds.setDatabaseName("Company");
		return ds.getConnection();
	}

	public static void printSessionInfo(Connection conn) throws SQLException {

		PreparedStatement selectSessionInfo = conn.prepareStatement("select @@SPID");
		ResultSet sessionInfoRows = selectSessionInfo.executeQuery();
		sessionInfoRows.next();
		System.out.println("Session ID: " + sessionInfoRows.getInt(1));
	}
}
