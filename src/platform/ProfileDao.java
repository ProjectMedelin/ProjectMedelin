package platform;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import database.DBUtil;
import profile.Profile;
import users.User;

public class ProfileDao {
	
	public synchronized boolean save(Profile profile) {

		try {
			String sql = "INSERT INTO users (email,password) " + "VALUES(?,?)";
			PreparedStatement statement = DBUtil.getInstance().getConnection().prepareStatement(sql);
            statement.setString(1, user.getEmail());
			statement.setString(2, user.getPassword());
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
