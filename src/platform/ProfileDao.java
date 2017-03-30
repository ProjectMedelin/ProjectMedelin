package platform;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.http.HttpSession;

import database.DBUtil;
import profile.DeveloperProfile;
import profile.EmplooyerProfile;
import profile.Profile;
import users.User;

public class ProfileDao {

	private static int id;

	public static synchronized void setProfile(Profile profile, String email) {

		try {
			String sql = "SELECT id from users where email=?";
			PreparedStatement statement = DBUtil.getInstance().getConnection().prepareStatement(sql);

			statement.setString(1, email);

			ResultSet rs = statement.executeQuery();
			rs.next();

			int idOfUser = rs.getInt("id");
			id = idOfUser;

			String quuery = "INSERT INTO profiles (user_profile_id) " + "VALUES(?)";
			statement = DBUtil.getInstance().getConnection().prepareStatement(quuery);
			statement.setInt(1, idOfUser);
			statement.executeUpdate();
			System.out.println("");
		} catch (SQLException e) {
			System.out.println("Cannot save to database - " + e.getClass().getName() + " " + e.getMessage());

		}

	}

	public static synchronized boolean saveDeveloper(DeveloperProfile profDev) {

		try {
			String sql = "UPDATE profiles SET name=?,type=?,video=?,about=?,website=?,github=?,linkedIn=? where user_profile_id=?";
			PreparedStatement statement = DBUtil.getInstance().getConnection().prepareStatement(sql);

			statement.setString(1, profDev.getName());
			statement.setString(2, "developer");
			// statement.setString(3, profDev.getProfilePicture().getPath());
			statement.setString(3, profDev.getVideo());
			statement.setString(4, profDev.getAbout());
			statement.setString(5, profDev.getWebsite());
			// statement.setString(7, profDev.getCV().getPath());
			statement.setString(6, profDev.getGithub());
			statement.setString(7, profDev.getLinkedIn());
			statement.setInt(8, id);
			int isAdded = statement.executeUpdate();
			if (isAdded > 0) {
				System.out.println("Saving  successful.");
				return true;
			}

		} catch (SQLException e) {
			System.out.println("Cannot save to database - " + e.getClass().getName() + " " + e.getMessage());
			return false;
		}
		return true;
	}

	public static synchronized boolean saveEmployer(EmplooyerProfile profEmp) {

		try {
			String sql = "UPDATE profiles SET name=?,type=?,video=?,about=?,website=? where user_profile_id=?";
			PreparedStatement statement = DBUtil.getInstance().getConnection().prepareStatement(sql);
			statement.setString(1, profEmp.getName());
			statement.setString(2, "company");
			statement.setString(3, profEmp.getVideo());
			statement.setString(4, profEmp.getAbout());
			statement.setString(5, profEmp.getWebsite());
			statement.setInt(6, id);
			int isAdded = statement.executeUpdate();
			if (isAdded > 0) {
				System.out.println("Saving  successful.");
				return true;
			}

		} catch (SQLException e) {
			System.out.println("Cannot save to database - " + e.getClass().getName() + " " + e.getMessage());
			return false;
		}
		return true;
	}

}
