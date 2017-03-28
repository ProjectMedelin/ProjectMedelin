package platform;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import database.DBUtil;
import profile.DeveloperProfile;
import profile.Profile;
import users.User;

public class ProfileDao {
	
	public synchronized boolean save(Profile profile) {

		try {
			String sql = "INSERT  ";
			PreparedStatement statement = DBUtil.getInstance().getConnection().prepareStatement(sql);
		    statement.setString(1, profile.getName());
			statement.setString(2, profile.getAbout());
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
