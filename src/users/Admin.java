package users;

import platform.Platform;
import profile.Profile;

public class Admin extends User {

	private Platform platform;
	
	public Admin(Profile profile, String email, String password) {
		super(profile, email, password);
    }

}
