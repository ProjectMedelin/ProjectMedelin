package profile;

import java.io.File;

public abstract class Profile {

	// HashMap(Emplooyer, HashMap(Double, String)) feedback
	private String name;
	protected File profilePicture;
	protected String about;
	private String video;
	private String website;

	public Profile() {
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setWebsite(String website) {
		this.website = website;
	}
	
	public File getProfilePicture() {
		return profilePicture;
	}

	public String getAbout() {
		return about;
	}
	public void setAbout(String about) {
		this.about = about;
	}

	public String getVideo() {
		return video;
	}

	public String getWebsite() {
		return website;
	}

	public void setProfilePicture(File profilePicture) {
		if (profilePicture.exists()) {
			this.profilePicture = profilePicture;
		}
	}

	public void addAboutDescription(String about) {
		System.out.println("Pls add about information");
		if (about != null && !about.isEmpty()) {
			this.about = about;
		}
	}

	public void setVideo(String video) {
		this.video = video;
	}

	/*
	 * public void addVideo(String video) {
	 * System.out.println("Pls add your video"); if (video.isEmpty()) {
	 * this.video = video; } else { addProfilePic(video); } }
	 */
	public void addWebsite(String web) {
		System.out.println("Pls add your website");
		if (web != null && !web.isEmpty()) {
			this.website = web;
		}
	}

	public String getName() {
		return this.name;
	}

}
