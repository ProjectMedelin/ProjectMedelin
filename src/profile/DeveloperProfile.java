package profile;

import java.io.File;
import java.util.ArrayList;

import interfaces.TechOwner;

public class DeveloperProfile extends Profile implements TechOwner {

    
	private ArrayList<Technologies> technologies;
	private File CV;
	private String github;
	private String linkedIn;

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
