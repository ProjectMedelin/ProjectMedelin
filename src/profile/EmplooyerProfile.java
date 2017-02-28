package profile;

import java.io.File;

public class EmplooyerProfile extends Profile {

	enum EmplooyerType {
		COMPANY, 
		PRIVATE
	}

	private EmplooyerType type;
	private String website;
	private Technologies technologies;
	// private ? skype
	// private ? video

	public EmplooyerProfile(String name) {
		super(name);
		// TODO Auto-generated constructor stub
	}

}
