package users;

import java.util.ArrayList;

import ads.Ads;
import ads.Ads.Experience;
import ads.Offer;
import platform.Platform;
import profile.EmplooyerProfile;
import profile.Profile;
import profile.Technologies;

public class Employer extends User {

	private ArrayList<Ads> ads;
	private ArrayList<Offer> offers;
	private ArrayList<Developer> developers;

	public Employer(Profile profile, String email, String password) {
		super(profile, email, password);
		this.ads = new ArrayList<>();
		this.offers = new ArrayList<>();
		this.developers = new ArrayList<>();

	}

	
	
	public void addDeveloper(Developer developer) {
		this.developers.add(developer);
	}

	
	
	public void createAdds(String title, String desctription, String requirenments, String conditions, Experience xp) {
		Ads ad = new Ads(title, desctription, requirenments, conditions, xp);
		this.ads.add(ad);

	}

	public void createSearchReq() {

	}

	public void sendOffer(Developer developer) {
		

	}

	public ArrayList<Developer> searchDeveloper(Platform platform, ArrayList<Technologies> req) {
		return null;
	}

	public void giveFeedback() {

	}

	@Override
	public String toString() {
		return "Employer [ads=" + ads + ", offers=" + offers + ", developers=" + developers + "]";
	}

	
}
