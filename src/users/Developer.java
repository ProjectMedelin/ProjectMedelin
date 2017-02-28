package users;

import java.util.ArrayList;

import ads.Ads;
import ads.Interview;
import ads.Offer;
import profile.Profile;

public class Developer extends User{
	
	private ArrayList<Ads> favouriteAds;
	private ArrayList<Offer> receivedOffers;
	private ArrayList<Interview> interviews;
	

	public Developer(Profile profile, String email, String password) {
		super(profile, email, password);
		
	}

}
