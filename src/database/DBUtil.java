package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class DBUtil {
	
	private static final String mySqlUSer = "root";
	private static final String mySqlPwd = "parola";
	private static final String mySQLCS = "jdbc:mysql://localhost:3306/mydb";
	
	public static Connection getConnection() throws SQLException{
		
		return DriverManager.getConnection(mySQLCS, mySqlUSer, mySqlPwd);
		
	}
	
}
