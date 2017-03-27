package profile;

import profile.EmplooyerProfile.EmplooyerType;

public class ProfileFactory {

	public Profile createProfile(String type, String name, EmplooyerType employerType) {
		DeveloperProfile dev = null;
		if (type.equals("developer")) {
			return new DeveloperProfile();
		} else if (type.equals("employer")) {
			return new EmplooyerProfile( EmplooyerType.PRIVATE);
		}
		return dev;
	}

}
