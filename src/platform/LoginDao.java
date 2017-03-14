package platform;

import java.sql.*;

import database.DBUtil;

public class LoginDao {
	public static boolean validate(String email, String password) {
		boolean status = false;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DBUtil.getConnection();
			PreparedStatement ps = con.prepareStatement("select * from users where email=? and password=?");
			ps.setString(1, email);
			ps.setString(2, password);

			ResultSet rs = ps.executeQuery();
			status = true;

		} catch (Exception e) {
			System.out.println(e);
		}
		return status;
	}
}
