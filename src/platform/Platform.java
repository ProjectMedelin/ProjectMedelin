package platform;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

import ads.Ads;
import interfaces.Moderator;
import ads.Offer;
import profile.EmplooyerProfile.EmplooyerType;
import profile.DeveloperProfile;
import profile.EmplooyerProfile;
import profile.Profile;
import profile.ProfileFactory;
import profile.Technologies;
import searchEngine.SearchEngine;
import users.Developer;
import users.Employer;
import users.User;
import users.User.FeedBack;
import validators.EmailValidator;
import validators.PasswordValidator;
import users.UserFactory;

public class Platform {

	private static final String PLATFORM_NAME = "Medelin";

	private static int counter = 0;
	private static Platform instance;
	Scanner sc = new Scanner(System.in);
	private String name;
	private SearchEngine searchEngine;
	private ArrayList<Developer> devCatalog;
	private ArrayList<Employer> empCatalog;
	private ArrayList<Ads> adsCatalog;
	private ArrayList<User> users;
	private ProfileFactory profileFactory;
	private UserFactory userFactory;
	private SearchEngine searcher;

	private Platform() {
		this.name = PLATFORM_NAME;
		this.devCatalog = new ArrayList<>();
		this.empCatalog = new ArrayList<>();
		this.adsCatalog = new ArrayList<>();
		this.users = new ArrayList<>();
		this.profileFactory = new ProfileFactory();
		this.userFactory = new UserFactory();
		this.searcher = new SearchEngine();

	}

	
	public void adAds(Ads ad){
		this.adsCatalog.add(ad);
	}
	
	public static Platform getInstance() {
		if (instance == null) {
			instance = new Platform();
		}
		return instance;
	}

	
	public User userCheckerByEmail(String email) {
		for (User child : users) {
			if (child.getEmail().equals(email)) {
				return child;
			}
		}
		return null;
	}

	public boolean passwordChecker(User user, String password) {
		if (user.getPassword().equals(password)) {
			return true;
		}
		return false;
	}

	public ArrayList<Developer> getDevCatalog() {
		return devCatalog;
	}

	public ArrayList<Employer> getEmpCatalog() {
		return empCatalog;
	}

	

	public void printUsers() {
		for (User usr : users) {
			System.out.println(usr);
		}
	}

	public void logIn() {
		System.out.println("Please enter your email");
		String logInEmail = sc.nextLine();

		while (!EmailValidator.validate(logInEmail)) {
			System.out.println("Invalid email address.");
			System.out.println("Please enter email");
			logInEmail = sc.nextLine();
		}

		User temp = userCheckerByEmail(logInEmail);
		if (temp != null) {
			System.out.println("Please enter your password: ");
			String loginPassword = sc.nextLine();
			if (passwordChecker(temp, loginPassword)) {
				System.out.println("===== WELCOME TO MEDELIN =====");
			}
		} else {
			System.out.println("Wrong email or password.");
		}

	}

	public void sendOffer(Developer developer, Employer emp) {
		printAds(emp.getAdds());
		System.out.println("Please enter a number for ads ");
		int help = sc.nextInt();
		Ads add = emp.getAdds().get(help);
		Offer offer = new Offer(add, developer);
		emp.setOffer(offer);
		developer.addOffers(offer);
		System.out.println("done");
	}

	// podava se ofer ot list na developera i se setva kato finished.
	public void markJobAsFinished(Offer offer) {
		offer.setFinished(true);
		sendFeedback(offer.getAds().getEmployer());

	}

	private void sendFeedback(Employer employer) {
		String feed = sc.nextLine();
		Double rating = sc.nextDouble();

		FeedBack feedback = new FeedBack(feed, rating);
		employer.addFeedBack(feedback);

	}

	public void printAds(ArrayList<Ads> ads) {
		for (Ads ad : ads) {
			System.out.println(ad);
		}

	}

	public void updateProfile(User user) { // ostavili sme si go, kogato pravim
											// front-end-a, zaradi mnogoto
											// syso-ve
		if (user.getProfile() instanceof DeveloperProfile) {
			DeveloperProfile temp = (DeveloperProfile) user.getProfile();
			// update fields of developerprofile class with setters
		}

		if (user.getProfile() instanceof EmplooyerProfile) {
			EmplooyerProfile temp = (EmplooyerProfile) user.getProfile();
			// update fields of empolyerprofile class with setters
		}
	}

	public ArrayList<Ads> getAds() {
		return this.adsCatalog;
	}

	public void applyAdds(Developer dev) {
		System.out.println("Please choose technology: ");
		ArrayList<Technologies> techAds = dev.addTechno();
		System.out.println(this.adsCatalog.size());
		System.out.println(techAds);

		ArrayList<Ads> searchedAds = searcher.searchAds(techAds, this);
		printAds(searchedAds);
		System.out.println("Please choose ad to apply by number: ");
		int number = sc.nextInt();
		searchedAds.get(number).getEmployer().addApplication(searchedAds.get(number), dev);


	}

	public void removeAdFromCatalog(Ads ad, Moderator mod) {
		if (this.adsCatalog.contains(ad)) {
			this.adsCatalog.remove(ad);
		}
	}

	public ArrayList<User> getUsers() {
		return users;
	}

	public void removeUser(User user, Moderator mod) {
		if (this.users.contains(user)) {
			this.users.remove(user);
		}
		if (user instanceof Developer) {
			this.devCatalog.remove(user);
		}
		if (user instanceof Employer) {
			this.empCatalog.remove(user);
			
		}

	}

}
