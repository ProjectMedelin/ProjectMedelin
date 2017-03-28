package platform;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import ads.Ads;
import database.DBUtil;
import profile.DeveloperProfile;
import profile.Profile;
import users.Developer;
import users.User;

public class UserDao {

	private static UserDao instance;

	private UserDao() {
	}

	public synchronized static UserDao getInstance() {
		if (instance == null) {
			instance = new UserDao();
		}
		return instance;
	}

	public synchronized boolean save(User user) {

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

	public synchronized boolean validate(String email, String password) {
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
			System.out.println("Cannot login");
			System.out.println(e);
		}
		return status;
	}

//	public synchronized ArrayList<User> getAllUsersFromDB(){
/*        String queryOne = "SELECT * FROM users where role = 'employer' ";
        String queryTwo = "SELECT * FROM users where role = 'developer' ";
        String queryProf = "Select * from profile where email = ?";
		ArrayList<User> users = new ArrayList<User>();
	    
		try {
		   PreparedStatement ps = DBUtil.getInstance().getConnection().prepareStatement(queryTwo);
           ResultSet resultSet = ps.executeQuery(queryTwo);
		   while (resultSet.next()) {
		     User user = new Developer(null,
		    		 					resultSet.getString("email"), 
		    		 					resultSet.getString("password"),	
		    		 					resultSet.getString("code"));
		     ResultSet profiles = st.executeQuery(queryProf);
		     Profile profile = new DeveloperProfile();
		     profile.setName(profiles.getString("name"));
		     profile.addAboutDescription(profiles.getString("about"));
		     profile.addWebsite(profiles.getString("website"));
		     profile.addVideo(profiles.g);
		     
		      users.add(user);
		            }
              } catch (SQLException e) {

		            System.out.println("Error in DB");
		            e.printStackTrace();
              } finally {
		                    try {
								st.close();
							} catch (SQLException e) {
								System.out.println("ops");
							}
		               
		        }
		        return users;*/
	
	//}

}
