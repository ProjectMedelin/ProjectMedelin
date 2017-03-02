package ads;

import java.util.ArrayList;
import java.util.Scanner;

import interfaces.TechOwner;

import profile.Technologies;
import users.Employer;

public class Ads extends TechOwner.TechAdder {

	public enum Experience {
		INTERN, JUNIOR, EXPERIENCED
	}

	private Experience experience;
	private String title;
	private String desctription;
	private String requirenments;
	private String conditions;
	private ArrayList<Technologies> reqTech;
	private Employer employer;

	public Ads(String title, String desctription, String requirenments, String conditions, Experience experience) {
		this.title = title;
		this.desctription = desctription;
		this.requirenments = requirenments;
		this.conditions = conditions;
		this.reqTech = new ArrayList<>();
		this.experience = experience;
	}

	public void addIn(Technologies tech) {
		this.reqTech.add(tech);
	}

	public void addTechnology() {
		this.reqTech = addTechno();

	}

	public ArrayList<Technologies> getArray() {
		return this.reqTech;
	}

	@Override
	public String toString() {
		return "Ads [experience=" + experience + ", title=" + title + ", desctription=" + desctription
				+ ", requirenments=" + requirenments + ", conditions=" + conditions + ", reqTech=" + reqTech
				+ ", employer=" + employer.getProfile().getName() + "]";
	}

}
