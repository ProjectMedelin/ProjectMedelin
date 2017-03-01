package profile;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class EmplooyerProfile extends Profile {

	public enum EmplooyerType {
		COMPANY, PRIVATE
	}

	private EmplooyerType type;

	public EmplooyerProfile(String name, EmplooyerType type) {
		super(name);
		this.type = type;
	}

}
