package users;

import java.sql.SQLNonTransientConnectionException;
import java.util.Scanner;

import ads.Ads;
import ads.Offer;
import interfaces.Moderator;
import ads.Offer;
import interfaces.Moderator;
import platform.Platform;
import profile.Profile;

public class Admin extends User implements Moderator {

	Scanner scan = new Scanner(System.in);
	private static final String PASSWORD_ADMIN="parolamedelin12*";
	private static final String EMAIL_ADMIN="project.medelin@gmail.com";
	private static final String CODE="asdf12";

	public Admin() {
       super(null, EMAIL_ADMIN, PASSWORD_ADMIN, CODE);
	}

	@Override
	public void removeAds(Platform platform) {
		int counter = 1;
		for (Ads ad : platform.getAds()) {
			System.out.println(counter + " - " + ad);
		}
		System.out.println("Please choose ad by number: ");
		int number = scan.nextInt();
		Ads temp = platform.getAds().get(number - 1);
		platform.removeAdFromCatalog(temp, this);
		for (Developer dev : platform.getDevCatalog()) {
			dev.removeAdFromDeveloper(temp, this);
			dev.removeOfferByAd(temp, this);
		}
		for (Employer employer : platform.getEmpCatalog()) {
			employer.removeAd(temp, this);
			employer.removeOfferByAd(temp, this);
		}
		System.out.println("The ad is deleted");
	}
	
	@Override
	public void removeUser(Platform platform){
		int counter = 1;
		for (User user : platform.getUsers()) {
			System.out.println(counter + " - " + user);
		}
		System.out.println("Please choose User by number: ");
		int number = scan.nextInt();
		User temp = platform.getUsers().get(number - 1);
		platform.removeUser(temp, this);
		
	}


}
