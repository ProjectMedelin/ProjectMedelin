package users;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Scanner;

import ads.Ads;
import ads.Ads.Experience;
import ads.Interview;
import ads.Offer;
import interfaces.Offerable;
import profile.Profile;

public class Employer extends User implements Offerable {

	Scanner sc = new Scanner(System.in);
	private ArrayList<Ads> ads;
	private ArrayList<Offer> offers;
	private ArrayList<Developer> developers;
	private static int counter = 0;
	private HashMap<Ads, ArrayList<Developer>> applications;

	public Employer(Profile profile, String email, String password) {
		super(profile, email, password);
		this.ads = new ArrayList<>();
		this.offers = new ArrayList<>();
		this.developers = new ArrayList<>();
		this.applications = new HashMap<>();

	}

	public HashMap<Ads, ArrayList<Developer>> getApplication() {
		return this.applications;
	}

	public void addApplication(Ads ad, Developer dev) {
		if (!this.applications.containsKey(ad)) {
			this.applications.put(ad, new ArrayList<>());
		}
		this.applications.get(ad).add(dev);
	}

	public void addDeveloper(Developer developer) {
		this.developers.add(developer);
	}

	public void createAd(String title, String desctription, String requirenments, String conditions, Experience xp) {
		Ads ad = new Ads(title, desctription, requirenments, conditions, xp, this);
		ad.addTechnology();
		this.ads.add(ad);
	}

	public void setOffer(Offer offer) {
		this.offers.add(offer);
	}

	@Override
	public void reviewOffers() {
		if (counter >= offers.size()) {
			System.out.println("There is no more offers");
			return;
		}
		System.out.println(offers.get(counter));
		counter++;
		System.out.println("===============");
		if (offers.get(counter - 1).isFinished()) {
			System.out.println("To give feedback press 'f'.\nTo next offer press 'n'.\nTo quit press 'q'.");
			String temp = sc.nextLine();
			if (temp.equals("f")) {
				System.out.println("Please write your feedback: ");
				String feed = sc.nextLine();
				System.out.println("Please enter grade: ");
				double grade = sc.nextDouble();
				FeedBack feeds = new FeedBack(feed, grade);
				offers.get(counter - 1).getDeveloper().addFeedBack(feeds);
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

		if (offers.get(counter - 1).isAccepted()) {
			if (!offers.get(counter - 1).getIsIntervieset())
				System.out.println(
						"If you want to send email for interview press 'y'.\nTo next offer press 'n'.\nTo quit press 'q'.");
			String temp = sc.nextLine();
			if (temp.equals("y")) {
				System.out.println("Please enter date in format dd-M-yyyy : ");
				String date = sc.nextLine();
				System.out.println("Please enter interviewer: ");
				String interviewer = sc.nextLine();
				Interview interview = new Interview(date, interviewer, offers.get(counter - 1));
				offers.get(counter - 1).getDeveloper().addInterview(interview);
				interview.sendInterviewEmail();
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

	}

	public ArrayList<Developer> reviewApplication() {
		for (Entry<Ads, ArrayList<Developer>> e1 : applications.entrySet()) {
			System.out.println(e1.getKey());
		}
		System.out.println("Please pick ad by title: ");
		String title = sc.nextLine();
		for (Entry<Ads, ArrayList<Developer>> e1 : applications.entrySet()) {
			if (e1.getKey().getTitle().equals(title)) {
				return e1.getValue();
			}
		}
		return new ArrayList<Developer>();
	}
    // vrushta developer, koito e izbran ot rabotodatelq za izprashtane na oferta
	public Developer reviewAndPickDeveloper() {
		int counter = 0;
		ArrayList<Developer> developers = reviewApplication();
		for (Developer dev : developers) {
			System.out.println(counter + " - " + dev);

		}
		System.out.println("Please pick developer by number: ");
		int number = sc.nextInt();
		return developers.get(number);
	}

	public ArrayList<Ads> getAdds() {
		return this.ads;
	}

}
