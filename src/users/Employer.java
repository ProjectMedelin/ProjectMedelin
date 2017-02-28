package users;

import java.util.ArrayList;

import ads.Ads;
import ads.Offer;
import profile.Profile;

public class Employer extends User{
	
	private ArrayList<Ads> ads;
	private ArrayList<Offer> offers;


	public Employer(Profile profile, String email, String password) {
		super(profile, email, password);
		
	}
	
}
