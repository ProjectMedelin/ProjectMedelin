package platform;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.mysql.jdbc.exceptions.jdbc4.MySQLDataException;

import ads.Ads;
import database.DBUtil;

public class AdsDao {

	public synchronized ArrayList<Ads> getAllAds(){
		ArrayList<Ads> allAds = new ArrayList<>();
		try {
            Class.forName("com.mysql.jdbc.Driver");
			String query = "SELECT * SELECT * FROM mydb.ads" ;
			PreparedStatement ps = DBUtil.getInstance().getConnection().prepareStatement(query);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				Ads ad = new Ads(rs.getString("title"), 
						         rs.getString("description"), 
						         rs.getString("requirenments"), rs.getString("conditions"), 
						        rs.getString("s"), )
			}

		} catch (MySQLDataException e) {
			System.out.println("Cannot login");
			System.out.println(e);
		}
		return status;
	}
}
