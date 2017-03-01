package users;

import java.util.ArrayList;

import ads.Ads;
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
		this.ads=new ArrayList<>();
		this.offers=new ArrayList<>();
		this.developers=new ArrayList<>();
		

	}
	
	public void addDeveloper(Developer developer){
		this.developers.add(developer);
	}
	
	public void createSearchReq(){
		
	}
	
	public void sendOffer(Developer developer){
	   
	}
	
	public ArrayList<Developer> searchDeveloper(Platform platform, ArrayList<Technologies> req){
		return null;
	}
	
	public void giveFeedback(){
		
	}

}
