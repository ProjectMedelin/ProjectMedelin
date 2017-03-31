package profile;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import interfaces.TechOwner;
import sun.print.resources.serviceui_zh_TW;

public class DeveloperProfile extends Profile implements TechOwner {

	private ArrayList<Technologies> technologies;
	private File CV;
	private String github;
	private String linkedIn;

	public DeveloperProfile() {

	}

	public File getCV() {
		return CV;
	}

	public String getLinkedIn() {
		return linkedIn;
	}

	public String getGithub() {
		return github;
	}

	public void addTechnology() {
		this.technologies = addTechno();
	}

	public void setGithub(String github) {
		this.github = github;
	}

	public void setLinkedIn(String linkedIn) {
		this.linkedIn = linkedIn;
	}

	public void setCV(File cV) {
		if (cV.exists()) {
			this.CV = cV;
		}
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

	/*
	 * public void addCV(File cv) { System.out.println("Pls add your CV"); if
	 * (cv.isFile()) { this.CV = cv; } else { addProfilePic(cv); } }
	 */

	public void addLinkedIn(String linked) {
		System.out.println("Pls add your linkedIn account");
		if (linked != null && !linked.isEmpty()) {
			this.linkedIn = linked;
		}
	}

	@Override
	public String toString() {
		return "Name: " + super.getName() + " + "
				+ ", github=" + github + ", linkedIn=" + linkedIn + "]";
	}

}
