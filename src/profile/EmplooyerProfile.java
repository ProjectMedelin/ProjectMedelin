package profile;

public class EmplooyerProfile extends Profile {

	public enum EmplooyerType {
		COMPANY, PRIVATE
	}

	private EmplooyerType type;

	public EmplooyerProfile(EmplooyerType type) {
		this.type = type;
	}

}
