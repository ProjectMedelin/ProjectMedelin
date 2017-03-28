package users;

import java.util.ArrayList;
import java.util.Scanner;
import ads.Ads;
import ads.Interview;
import ads.Offer;
import interfaces.Moderator;
import interfaces.Offerable;
import interfaces.TechOwner;
import profile.DeveloperProfile;
import profile.Profile;
import profile.Technologies;

public class Developer extends User implements TechOwner, Offerable {

	private static int counter = 0;
	Scanner sc = new Scanner(System.in);
	private ArrayList<Ads> favouriteAds;
	private ArrayList<Offer> receivedOffers;
	private ArrayList<Interview> interviews;

	public Developer(Profile profile, String email, String password, String code, String role) {
		super(profile, email, password, code, role);
		this.favouriteAds = new ArrayList<>();
		this.receivedOffers = new ArrayList<>();
		this.interviews = new ArrayList<>();

	}

	public ArrayList<Ads> getFavouriteAds() {
		return favouriteAds;
	}

	public void setProfile(DeveloperProfile prof) {
		this.profile = prof;
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
			counter = 0;
			return;
		}
		if (temp.equals("n")) {
			reviewOffers();
		}
		if (temp.equals("q")) {
			counter = 0;
			return;
		}
	}

	public ArrayList<Offer> getReceivedOffers() {
		return this.receivedOffers;
	}

	public void addOffers(Offer offer) {
		this.receivedOffers.add(offer);
	}

	public void addInterview(Interview intV) {
		this.interviews.add(intV);

	}

	public ArrayList<Technologies> getTechnology() {
		DeveloperProfile prof = (DeveloperProfile) this.profile;
		return prof.getTech();

	}

	public void removeAdFromDeveloper(Ads add, Moderator mod) {
		for (Ads ad : favouriteAds) {
			if (ad.equals(add)) {
				this.favouriteAds.remove(add);
			}
		}
	}

	public void removeOfferByAd(Ads add, Moderator mod) {
		for (Offer offer : this.receivedOffers) {
			if (offer.getAds().equals(add)) {
				this.receivedOffers.remove(offer);
			}
		}
	}
}
