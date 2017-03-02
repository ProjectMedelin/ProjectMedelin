package platform;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

import org.omg.CORBA.PRIVATE_MEMBER;

import ads.Ads;
import ads.Offer;
import ads.Ads.Experience;
import profile.EmplooyerProfile.EmplooyerType;
import profile.Profile;
import profile.ProfileFactory;
import searchEngine.SearchEngine;
import users.Developer;
import users.Employer;
import users.User;
import users.UserFactory;

public class Platform {
	
	private static final String PLATFORM_NAME = "Medelin";
	
	private static Platform instance;
	Scanner sc = new Scanner(System.in);
	private String name;
	private SearchEngine searchEngine;
	private ArrayList<Developer> devCatalog;
	private ArrayList<Employer> empCatalog;
	private ArrayList<Ads> adsCatalog;
	private HashSet<User> users;
	private ProfileFactory profileFactory;
	private UserFactory userFactory;

	private Platform() {
		this.name = PLATFORM_NAME;
		this.devCatalog = new ArrayList<>();
		this.empCatalog = new ArrayList<>();
		this.adsCatalog = new ArrayList<>();
		this.users = new HashSet();
		this.profileFactory = new ProfileFactory();
		this.userFactory = new UserFactory();

	}
	
	public static Platform getInstance(){
		if (instance == null) {
			instance = new Platform();
		}
		return instance;
	}

	public void signUp() {

		System.out.println("Please choose account type.\n enter 0 for developer \n enter 1 for employer ");
		int temp = sc.nextInt();
		sc.nextLine();
		if (temp == 0) { // developer
			System.out.print("Please enter your name");
			String name = sc.nextLine();
			Profile developerProfile = profileFactory.createProfile("developer", name, null);
			System.out.println("Please enter email");
			String emailDeveloper = sc.nextLine();
			System.out.println("Enter Password");
			String passwordDeveloper = sc.nextLine();
			User developerUser = userFactory.createUser(emailDeveloper, passwordDeveloper, developerProfile,
					"developer");
			this.users.add(developerUser);
			this.devCatalog.add((Developer) developerUser);

		}
		if (temp == 1) { // employer

			System.out.println("Please enter 0 for company and 1 for private");
			int temp1 = sc.nextInt();
			sc.nextLine();
			if (temp1 == 0) { // company
				System.out.println("Please enter your name");
				String name = sc.nextLine();
				Profile employerCompany = profileFactory.createProfile("employer", name, EmplooyerType.COMPANY);
				System.out.println("Please enter email");
				String emailCompany = sc.nextLine();
				System.out.println("Enter Password");
				String passwordCompany = sc.nextLine();
				User companyUser = userFactory.createUser(emailCompany, passwordCompany, employerCompany, "employer");
				this.users.add(companyUser);
				this.empCatalog.add((Employer) companyUser);

			}
			if (temp1 == 1) { // private
				System.out.println("Please enter your name");
				String name = sc.nextLine();
				Profile employerPrivate = profileFactory.createProfile("employer", name, EmplooyerType.PRIVATE);
				System.out.println("Please enter email");
				String emailPrivate = sc.nextLine();
				System.out.println("Enter Password");
				String passwordPrivate = sc.nextLine();
				User privateUser = userFactory.createUser(emailPrivate, passwordPrivate, employerPrivate, "employer");
				this.users.add(privateUser);
				this.empCatalog.add((Employer) privateUser);
			}
		}
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

	// Ads ad = new Ads(title, desctription, requirenments, conditions, xp);

	public void createAdds(Employer emp) {
		System.out.println("Enter title: ");
		String title = sc.nextLine();
		System.out.println("Enter decription: ");
		String desctription = sc.nextLine();
		System.out.println("Enter requirements: ");
		String requirements = sc.nextLine();
		System.out.println("Enter conditions: ");
		String conditions = sc.nextLine();
		System.out.println("Choose from 0,1,2 for Experience: \n 0 for INTERN \n 1 for JUNIOR \n 2 for EXPERIENCED");
		int xp = sc.nextInt();
		Experience exp = null;
		switch (xp) {
		case 0:
			exp = Experience.INTERN;
			break;
		case 1:
			exp = Experience.JUNIOR;
			break;
		case 2:
			exp = Experience.EXPERIENCED;
			break;
		default:
			break;
		}
		emp.createAd(title, desctription, requirements, conditions, exp);
		emp.giveMeAds().get(0).adEmployer(emp);
	}

	public void printUsers() {
		for (User usr : users) {
			System.out.println(usr);
		}
	}

	public void logIn() {
		System.out.println("Please enter your email");
		String logInEmail = sc.nextLine();
		User temp = userCheckerByEmail(logInEmail);
		if (temp != null) {
			System.out.println("Please enter your password: ");
			String loginPassword = sc.nextLine();
			if (passwordChecker(temp, loginPassword)) {
				System.out.println("===== WELCOME TO MEDELIN =====");
			}
		} else {
			System.out.println("Wrong email");
		}

	}
	
	

	public void sendOffer(Developer developer, Employer emp) {
		int counter = 0;
		for (Ads ads2 : emp.giveMeAds()) {
			System.out.println(counter + " - " + ads2);
			counter++;
		}
		System.out.println("Please enter a number for ads ");
		int help = sc.nextInt();
		Ads add = emp.giveMeAds().get(help);
		Offer offer = new Offer(add);
		emp.setOffer(offer);
		developer.addOffers(offer);
	}

	
	
	public void markJobAsFinished(Developer dev){
		int counter=0;
		for (Offer offs : dev.getReceivedOffers()) {
			System.out.println(counter + " - " + offs);
			counter++;
		}
		System.out.println("Please choose number of offer");
		
	}
}
