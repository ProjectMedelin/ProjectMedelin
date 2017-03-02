package interfaces;

import java.util.ArrayList;
import java.util.Scanner;

import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter.DEFAULT;

import profile.Technologies;

public interface TechOwner {

		 default public ArrayList<Technologies> addTechno() {

			ArrayList<Technologies> tech = new ArrayList<>();
			Scanner sc = new Scanner(System.in);

			for (int i = 0; i < Technologies.values().length; i++) {
				System.out.println(i + 1 + " - " + Technologies.values()[i]);
			}
			System.out.println("=================");
			System.out.println("Please, pick technology by number");
			int input = sc.nextInt();
			do {
				if (input > 29) {
					System.out.println("Please, enter a number from the table");
				} else {
					tech.add(Technologies.values()[input - 1]);
				}
				input = sc.nextInt();

			} while (input != 0);

			return tech;
		}
	
}
