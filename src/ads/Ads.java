package ads;

import java.util.ArrayList;
import java.util.Scanner;

import interfaces.TechOwner;

import profile.Technologies;
import users.Employer;

public class Ads extends TechOwner.TechAdder {

	enum Experience {
		INTERN, JUNIOR, EXPERIENCED
	}

	private Experience experience;
	private String title;
	private String desctription;
	private String requirenments;
	private String conditions;
	private ArrayList<Technologies> reqTech;
	private Employer employer;

	public Ads(String title, String desctription, String requirenments, String conditions) {
		this.title = title;
		this.desctription = desctription;
		this.requirenments = requirenments;
		this.conditions = conditions;
		this.reqTech = new ArrayList<>();
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

}
