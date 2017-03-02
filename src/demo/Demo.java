package demo;

import platform.Platform;
import users.Developer;
import users.Employer;

public class Demo {
	public static void main(String[] args) {

		Platform medelin = new Platform("Medelin");

		medelin.signUp();
		medelin.signUp();
		Employer emp = medelin.getEmpCatalog().get(0);
		Developer dev = medelin.getDevCatalog().get(0);
		medelin.createAdds(emp);
		medelin.sendOffer(dev, emp);
		dev.reviewOffers();

		// medelin.logIn();

		medelin.printUsers();

	}
}
