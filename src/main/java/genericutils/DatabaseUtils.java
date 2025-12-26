package genericutils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class DatabaseUtils {

	Connection conn = null;
	ResultSet result = null;
	
	public void connectToDB() throws SQLException
	
	{
		//register the databas
		Driver driver = new Driver();
		DriverManager.registerDriver(driver);
		
		//get connection for database
//		conn = DriverManager.getConnection(IPathConstants.dbURL, IPathConstants.dbUsername, IPathConstants.dbPassword);
}	
	
	public ResultSet executeQuery(String query) throws SQLException
	{
		//create statement
		Statement state = conn.createStatement();
	
		//execute query
		result = state.executeQuery(query);
	
		return result;
	}
	
	public int updateQuery(String query) throws SQLException
	{
		//create statement
		Statement state = conn.createStatement();
		int res = state.executeUpdate(query);
		return res;
	}
	
	public void disconnectDB() throws SQLException
	{
		//close datase connection
		conn.close();
		
	}
}
