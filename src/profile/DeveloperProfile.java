package profile;

import java.io.File;

public class DeveloperProfile extends Profile {

	enum Experience {
		INTERN, JUNIOR, EXPERIENCED
	}

	private Experience experience;
	private Technologies technologies;
	private File CV;
	private String github;
	private String linkedIn;
	private String video;
	private String website;
	// private ? skype
	// private ? video

	public DeveloperProfile(String name) {
		super(name);
	}

}
