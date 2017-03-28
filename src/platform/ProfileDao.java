package platform;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.http.HttpSession;

import database.DBUtil;
import profile.DeveloperProfile;
import profile.Profile;
import users.User;

public class ProfileDao {

	public static synchronized void setProfile(Profile profile, String email) {
		System.out.println("na maika ti dva pyti");
		System.out.println(email);
		try {
			String sql = "SELECT id from users where email=?";
			PreparedStatement statement = DBUtil.getInstance().getConnection().prepareStatement(sql);
			
			statement.setString(1, email);
			
		    ResultSet rs = statement.executeQuery();
			rs.next();
			
			int idOfUser = rs.getInt("id");
			String quuery = "INSERT INTO profiles (user_profile_id) " + "VALUES(?)";
			statement = DBUtil.getInstance().getConnection().prepareStatement(quuery);
			statement.setInt(1, idOfUser);
			statement.executeUpdate();
			System.out.println("NA MAIKA TI");
		} catch (SQLException e) {
			System.out.println("Cannot save to database - " + e.getClass().getName() + " " + e.getMessage());

		}

	}

}
