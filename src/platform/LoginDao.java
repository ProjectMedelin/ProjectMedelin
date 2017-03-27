package platform;

import java.sql.*;

import database.DBUtil;

public class LoginDao {

	public static boolean validate(String email, String password) {
		boolean status = false;
		try {

			Class.forName("com.mysql.jdbc.Driver");
			String query = "select * from users where email=? and password=?";
			PreparedStatement ps = DBUtil.getInstance().getConnection().prepareStatement(query);
			ps.setString(1, email);
			ps.setString(2, password);

			ResultSet rs = ps.executeQuery();
			status = rs.next();

		} catch (Exception e) {
			System.out.println(e);
		}
		return status;
	}
}
