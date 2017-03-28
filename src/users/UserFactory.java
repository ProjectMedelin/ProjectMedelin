package users;

import profile.Profile;

public class UserFactory {

	public User createUser(String email, String password, Profile profile, String type, String code, String role) {
		Developer dev = null;
		if (type.equals("developer")) {
			return new Developer(profile, email, password, code, role);
		} else if (type.equals("employer")) {
			return new Employer(profile, email, password, code, role);
		}
		return dev;
	}
}
