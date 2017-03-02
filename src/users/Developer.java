package users;

import java.util.ArrayList;
import java.util.Scanner;

import ads.Ads;
import ads.Interview;
import ads.Offer;
import interfaces.TechOwner;
import profile.DeveloperProfile;
import profile.Profile;
import profile.Technologies;

public class Developer extends User implements TechOwner{

	private static int counter = 0;
	Scanner sc = new Scanner(System.in);
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
	
	

	public void reviewOffers() {
		if (counter >= receivedOffers.size()) {
			System.out.println("There is no more offers");
			return;
		}
		System.out.println(receivedOffers.get(counter));
		counter++;
		System.out.println("===============");
		System.out.println("To accept offer press 'a'.\nTo next offer press 'n'.\nTo quit press 'q'.");
		String temp = sc.nextLine();
		if (temp.equals("a")) {
			
			receivedOffers.get(counter).setAccepted(true);
			System.out.println("Thanks for your choice");
			return;
		}
		if (temp.equals("n")) {
			reviewOffers();
		}
		if (temp.equals("q")) {
			return;
		}
	}

	public ArrayList<Offer> getReceivedOffers() {
		return this.receivedOffers;
	}

	public void addOffers(Offer offer) {
		this.receivedOffers.add(offer);
	}

	public void recieveFeedBack() {

	}
}