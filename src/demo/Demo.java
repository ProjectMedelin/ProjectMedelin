package demo;

import ads.Ads;
import ads.Ads.Experience;
import ads.Interview;
import ads.Offer;
import platform.EmailSender;
import platform.Platform;
import profile.DeveloperProfile;
import profile.EmplooyerProfile;
import profile.EmplooyerProfile.EmplooyerType;
import users.Developer;
import users.Employer;

public class Demo {
	public static void main(String[] args) {
		
		DeveloperProfile developerProfile = new DeveloperProfile("Shashank");
		Developer developer = new Developer(developerProfile, "project.medelin@gmail.com", "parola");
		EmplooyerProfile emplooyerProfile = new EmplooyerProfile("it", EmplooyerType.COMPANY);
		Employer employer = new Employer(emplooyerProfile, "ivan@abv.bg", "parola");
		Ads ad = new Ads("da", "ne", "mnogo", "malko", Experience.INTERN, employer);
		Offer offer = new Offer(ad, developer);
		Interview interview = new Interview("12-3-2017", "Gosho", offer);
		interview.saveInterviewInFile();
		System.out.println(ad);
		System.out.println(offer);
		System.out.println(interview);
		
		String testFilename = "interviewDetails.txt";
		EmailSender.sendEmailWithattachment("project.medelin@gmail.com", "proba", "test", testFilename);
		
		
		
	}
}
