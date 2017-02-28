package users;

import profile.Profile;

public abstract class User {
	
	private Profile profile;
	private String email;
	private String password;
	
	public User(Profile profile, String email, String password) {
		this.profile = profile;
		this.email = email;
		this.password = password;
	}
	
	
	
	
}
