package profile;

import java.io.File;
import java.util.ArrayList;

public class DeveloperProfile extends Profile {

    
	private ArrayList<Technologies> technologies;
	private File CV;
	private String github;
	private String linkedIn;
	// private ? skype

	public DeveloperProfile(String name) {
		super(name);
	}

	public void addTechnology() {
		this.technologies = addTechno();
	}

	public ArrayList<Technologies> getTech() {
		return this.technologies;
	}

	public void addGitHub(String git) {
		System.out.println("Pls add your github accaount");
		if (git != null && !git.isEmpty()) {
			this.github = git;
		}
	}

	public void addCV(File cv) {
		System.out.println("Pls add your CV");
		if (cv.isFile()) {
			this.CV = cv;
		} else {
			addProfilePic(cv);
		}
	}

	public void addLinkedIn(String linked) {
		System.out.println("Pls add your linkedIn account");
		if (linked != null && !linked.isEmpty()) {
			this.linkedIn = linked;
		}
	}

}
