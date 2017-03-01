package users;

import profile.DeveloperProfile;
import profile.EmplooyerProfile;
import profile.Profile;
import profile.EmplooyerProfile.EmplooyerType;

public class UserFactory {

	public User createUser(String email, String password, Profile profile, String type) {
		Developer dev = null;
		if (type.equals("developer")) {
			return new Developer(profile, email, password);
		} else if (type.equals("employer")) {
			return new Employer(profile, email, password);
		}
		return dev;
	}
}
