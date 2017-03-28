package platform;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.mysql.jdbc.exceptions.jdbc4.MySQLDataException;

import ads.Ads;
import ads.Ads.Experience;
import database.DBUtil;

public class AdsDao {

	public synchronized void createAd() {

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
						rs.getString("conditions"), Experience.INTERN, null);
				allAds.add(ad);

			}
		} catch (SQLException e) {
			System.out.println("Cannot login");
			System.out.println(e);
		}
		return allAds;
	}
}
