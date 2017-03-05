package profile;

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
