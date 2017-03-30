package ads;

import java.util.ArrayList;
import interfaces.TechOwner;

import profile.Technologies;
import users.Employer;

public class Ads implements TechOwner {

	private String title;
	private String desctription;
	private String requirenments;
	private String conditions;
	private ArrayList<Technologies> reqTech;
	private Employer employer;
	private int idAds;
	private int ownerID;

	public Ads(String title, String desctription, String requirenments, String conditions, Employer employer) {
		this.title = title;
		this.desctription = desctription;
		this.requirenments = requirenments;
		this.conditions = conditions;
		this.reqTech = new ArrayList<>();
		this.employer = employer;
	}
	
	public void setOwnerID(int ownerID) {
		this.ownerID = ownerID;
	}
	
	public int getOwnerID() {
		return ownerID;
	}
	
	public void setIdAds(int idAds) {
		this.idAds = idAds;
	}
	
	public int getIdAds() {
		return idAds;
	}

	public String getTitle() {
		return title;
	}

	public String getConditions() {
		return conditions;
	}

	public String getDesctription() {
		return desctription;
	}

	public String getRequirenments() {
		return requirenments;
	}

	public void addIn(Technologies tech) {
		this.reqTech.add(tech);
	}

	public void addTechnology() {
		this.reqTech = addTechno();

	}

	public void adEmployer(Employer emp) {
		this.employer = emp;
	}

	public ArrayList<Technologies> getTechnology() {
		return this.reqTech;
	}

	public Employer getEmployer() {
		return employer;
	}

	@Override
	public String toString() {
		return "Ads [title=" + title + ", desctription=" + desctription + ", requirenments=" + requirenments
				+ ", conditions=" + conditions +   "]";
	}

}
