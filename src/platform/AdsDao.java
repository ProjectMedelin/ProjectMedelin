
package platform;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import com.mysql.jdbc.exceptions.jdbc4.MySQLDataException;

import ads.Ads;
import database.DBUtil;

public class AdsDao {

	public static synchronized boolean createAd(Ads ad, int userID) {

		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		try {
			String query = "INSERT into ads (title,description,requirements,conditions,id_platform_ads,user_ads_id)"
					+ "VALUES(?,?,?,?,?,?)";
			PreparedStatement statement = DBUtil.getInstance().getConnection().prepareStatement(query);
			statement.setString(1, ad.getTitle());
			statement.setString(2, ad.getDesctription());
			statement.setString(3, ad.getRequirenments());
			statement.setString(4, ad.getConditions());
			statement.setInt(5, 1);
			statement.setInt(6, userID);
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

	public synchronized ArrayList<Ads> getAllAds() throws ClassNotFoundException {
		boolean status;
		ArrayList<Ads> allAds = new ArrayList<>();
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String query = "SELECT * d.name FROM users e JOIN ads d on d.user_ads = es";
			PreparedStatement ps = DBUtil.getInstance().getConnection().prepareStatement(query);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Ads ad = new Ads(rs.getString("title"), rs.getString("description"), rs.getString("requirenments"),
						rs.getString("conditions"), null);
				allAds.add(ad);

			}
		} catch (SQLException e) {
			System.out.println("Cannot login");
			System.out.println(e);
		}
		return allAds;
	}
}
