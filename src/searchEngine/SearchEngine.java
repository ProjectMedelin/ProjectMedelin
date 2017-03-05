package searchEngine;

import java.util.ArrayList;

import ads.Ads;
import platform.Platform;
import profile.DeveloperProfile;
import profile.Technologies;
import users.Developer;

public class SearchEngine {

	private int matches;

	// tyrsachka po tehnologiii
	public ArrayList<Developer> searchDeveloper(ArrayList<Technologies> req, Platform platform) {
		ArrayList<Developer> tep = new ArrayList<>();
		for (Developer dev : platform.getDevCatalog()) {
			DeveloperProfile tempp1 = (DeveloperProfile) dev.getProfile();
			if (tempp1.getTech().containsAll(req)) {
				tep.add(dev);
			}
		}
		return tep;
	}

	public ArrayList<Ads> searchAds(ArrayList<Technologies> req, Platform platform) {
		ArrayList<Ads> temp = new ArrayList<>();
		for (Ads ad : platform.getAds()) {
			if (ad.getTechnology().containsAll(req)) {
				temp.add(ad);
			}
		}
		return temp;
	}

}
