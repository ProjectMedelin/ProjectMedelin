package profile;

import java.io.File;
import java.util.ArrayList;

import interfaces.TechOwner;

public abstract class Profile extends TechOwner.TechAdder {

	// HashMap(Emplooyer, HashMap(Double, String)) feedback
	private String name;
	protected File profilePicture;
	protected String about;
	private File video;
	private String website;

	public Profile(String name) {
		this.name = name;
	}

	public void addProfilePic(File profilePic) {
		System.out.println("Pls add profile picture");
		if (profilePic.isFile()) {
			this.profilePicture = profilePic;
		} else {
			addProfilePic(profilePic);
		}
	}

	public void addAboutDescription(String about) {
		System.out.println("Pls add about information");
		if (about != null && !about.isEmpty()) {
			this.about = about;
		}
	}

	public void addVideo(File video) {
		System.out.println("Pls add your video");
		if (video.isFile()) {
			this.video = video;
		} else {
			addProfilePic(video);
		}
	}

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
