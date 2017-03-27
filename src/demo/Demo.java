package demo;

import java.sql.Connection;
import java.sql.SQLException;

import ads.Ads;
import ads.Ads.Experience;
import ads.Interview;
import ads.Offer;
import database.DBUtil;
import platform.EmailSender;
import platform.Platform;
import profile.DeveloperProfile;
import profile.EmplooyerProfile;
import profile.EmplooyerProfile.EmplooyerType;
import users.Developer;
import users.Employer;
import validators.PasswordValidator;

public class Demo {
	public static void main(String[] args) throws SQLException {
		
		/*Platform medelin =Platform.getInstance();
		DeveloperProfile developerProfile = new DeveloperProfile("Shashank");
		Developer developer = new Developer(developerProfile, "project.medelin@gmail.com", "parola");
		EmplooyerProfile emplooyerProfile = new EmplooyerProfile("it", EmplooyerType.COMPANY);
		Employer employer = new Employer(emplooyerProfile, "ivan@abv.bg", "parola");
		Ads ad = new Ads("da", "ne", "mnogo", "malko", Experience.INTERN, employer);
		medelin.createAdds(employer);
		Offer offer = new Offer(ad, developer);
		Interview interview = new Interview("12-3-2017", "Gosho", offer);
		interview.saveInterviewInFile();
		System.out.println(ad);
		System.out.println(offer);
		System.out.println(interview);
	
		medelin.applyAdds(developer);
		medelin.sendOffer(employer.reviewAndPickDeveloper(), ad.getEmployer());
		
		ad.getEmployer().reviewApplication();*/

		

			
		//String testFilename = "interviewDetails.txt";
		//EmailSender.sendEmailWithattachment("project.medelin@gmail.com", "proba", "test", testFilename);
		
		
		
	}
}
