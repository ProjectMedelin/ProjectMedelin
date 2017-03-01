package profile;

import profile.EmplooyerProfile.EmplooyerType;

public class ProfileFactory {

	public Profile createProfile(String type, String name, EmplooyerType employerType) {
		DeveloperProfile dev = null;
		if (type.equals("developer")) {
			return new DeveloperProfile(name);
		} else if (type.equals("employer")) {
			return new EmplooyerProfile(name, EmplooyerType.PRIVATE);
		}
		return dev;
	}

}
