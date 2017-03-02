package users;

import java.util.ArrayList;

import ads.Ads;
import ads.Interview;
import ads.Offer;
import profile.DeveloperProfile;
import profile.Profile;
import profile.Technologies;

public class Developer extends User {

	private ArrayList<Ads> favouriteAds;
	private ArrayList<Offer> receivedOffers;
	private ArrayList<Interview> interviews;
	private ArrayList<Employer> emplooyers;

	public Developer(Profile profile, String email, String password) {
		super(profile, email, password);
		this.favouriteAds = new ArrayList<>();
		this.receivedOffers = new ArrayList<>();
		this.emplooyers = new ArrayList<>();
		this.interviews = new ArrayList<>();

	}

	public void reviewOffer(Offer offer) {

	}

	public ArrayList<Offer> getReceivedOffers() {
		return this.receivedOffers;
	}

	public void addOffers(Offer offer) {
		this.receivedOffers.add(offer);
	}
	
	public void recieveFeedBack(){
		
	}
}
