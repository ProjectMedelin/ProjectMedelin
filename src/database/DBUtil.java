package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class DBUtil {
	private static DBUtil instance;
	private static final String mySqlUSer = "root";
	private static final String mySqlPwd = "root";
	private static final String mySQLCS = "jdbc:mysql://localhost:3306/mydb";
	private static Connection con;

	public static synchronized DBUtil getInstance() {
		if (instance == null) {
			instance = new DBUtil();
		}
		return instance;
	}

	private DBUtil() {
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			System.out.println("Driver not found");
		}
		try {
			con = DriverManager.getConnection(mySQLCS, mySqlUSer, mySqlPwd);
		} catch (SQLException e) {
			System.out.println("Error connecting - " + 	e.getMessage());
		}
	}
	
	public Connection getConnection(){
		return con;
	}

}
