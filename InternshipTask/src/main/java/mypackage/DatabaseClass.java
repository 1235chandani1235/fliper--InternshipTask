package mypackage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseClass {
	
	private Connection conn;

	public DatabaseClass() throws ClassNotFoundException, SQLException {
		establishConnection();
	}

	private void establishConnection() throws ClassNotFoundException, SQLException {

		Class.forName("com.mysql.jdbc.Driver");
		conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/interntask", "root", "root");

	}
	
	 public Connection getConnection() {
	        return conn;
	    }

}
