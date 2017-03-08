package users;

import java.util.Scanner;

import ads.Ads;
import ads.Offer;
import platform.Platform;
import profile.Profile;

public class Admin extends User {

	

	private Platform platform;

	public Admin(Profile profile, String email, String password, Platform platform) {
		super(profile, email, password);
		this.platform = platform;
	}

	
	

}
