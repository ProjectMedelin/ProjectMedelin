package demo;

import java.security.KeyRep.Type;

import ads.Ads;
import profile.DeveloperProfile;
import profile.EmplooyerProfile;
import profile.EmplooyerProfile.EmplooyerType;
import profile.Technologies;

public class Demo {

	public static void main(String[] args) {
		
		//Ads ads = new Ads("maika ti", "roshava", "mnogo", "802802 evraka");
		//ads.addTechnology();
		//System.out.println(ads.getArray());
		//DeveloperProfile profilche = new DeveloperProfile("Pesho");
		//profilche.addTechnology();
		//System.out.println(profilche.getTech());
		
		EmplooyerProfile profile =new EmplooyerProfile("Pesho",EmplooyerType.PRIVATE);
		
	}
}
