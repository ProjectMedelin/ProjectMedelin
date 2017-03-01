package platform;

import java.util.ArrayList;
import java.util.Scanner;

import ads.Ads;
import profile.EmplooyerProfile.EmplooyerType;
import profile.Profile;
import profile.ProfileFactory;
import searchEngine.SearchEngine;
import users.Developer;
import users.Employer;
import users.User;
import users.UserFactory;

public class Platform {

	Scanner sc = new Scanner(System.in);
	private String name;
	private SearchEngine searchEngine;
	private ArrayList<Developer> devCatalog;
	private ArrayList<Employer> empCatalog;
	private ArrayList<Ads> adsCatalog;
	private ArrayList<User> users;
	private ProfileFactory profileFactory;
	private UserFactory userFactory;

	public Platform(String name) {
		this.name = name;
		this.devCatalog = new ArrayList<>();
		this.empCatalog = new ArrayList<>();
		this.adsCatalog = new ArrayList<>();
		this.users = new ArrayList<>();
		this.profileFactory = new ProfileFactory();
		this.userFactory = new UserFactory();

	}

	public void signUp() {

		System.out.println("Please choose account type.\n enter 0 for developer \n enter 1 for employer ");
		if (sc.nextInt() == 0) {
			System.out.print("Please enter your name");
			String name = sc.nextLine();
			Profile developerProfile = profileFactory.createProfile("developer", name, null);
			System.out.println("Please enter email");
			String emailDeveloper = sc.nextLine();
			System.out.println("Enter Password");
			String passwordDeveloper = sc.nextLine();
			User developerUser = userFactory.createUser(emailDeveloper, passwordDeveloper, developerProfile,
					"developer");
		}
		if (sc.nextInt() == 1) {
			System.out.println("Please enter your name");
			String name = sc.nextLine();
			System.out.println("Please enter 0 for company and 1 for private");
			if (sc.nextInt() == 0) {
				Profile employerCompany = profileFactory.createProfile("employer", name, EmplooyerType.COMPANY);
				System.out.println("Please enter email");
				String emailCompany = sc.nextLine();
				System.out.println("Enter Password");
				String passwordCompany = sc.nextLine();
				User companyUser = userFactory.createUser(emailCompany, passwordCompany, employerCompany, "employer");
			}
			if (sc.nextInt() == 0) {
				Profile employerPrivate = profileFactory.createProfile("employer", name, EmplooyerType.PRIVATE);
				System.out.println("Please enter email");
				String emailPrivate = sc.nextLine();
				System.out.println("Enter Password");
				String passwordPrivate = sc.nextLine();
				User companyUser = userFactory.createUser(emailPrivate, passwordPrivate, employerPrivate, "employer");
			}
		}

	}

}
