package profile;

import java.io.File;

public abstract class Profile {

	public class FeedBack {
		private String feedback;
		private double valuation;

		public FeedBack(String feedback, double valuation) {
			// if(feedback!=null&&!feedback.isEmpty()){
			this.feedback = feedback;
			this.valuation = valuation;
		}

	}

	// HashMap(Emplooyer, HashMap(Double, String)) feedback
	private String name;
	protected double rating;
	protected File profilePicture;
	protected FeedBack feedback;
	protected String about;

	public Profile(String name) {
		this.name = name;
	}

}
