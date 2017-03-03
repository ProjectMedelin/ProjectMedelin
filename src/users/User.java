package users;

import java.util.ArrayList;

import interfaces.TechOwner;
import profile.Profile;

public abstract class User {

	public static class FeedBack {
		private String feedback;
		private double rating;

		public FeedBack(String feedback, double rating) {
			// if(feedback!=null&&!feedback.isEmpty()){
			this.feedback = feedback;
			this.rating = rating;
		}

		public double giveMeRating() {
			return this.rating;
		}

	}

	protected Profile profile;
	protected String email;
	private String password;
	private double rating;
	private ArrayList<FeedBack> feedback;

	public User(Profile profile, String email, String password) {
		this.profile = profile;
		this.email = email;
		this.password = password;
		this.feedback = new ArrayList<>();
	}

	public void addFeedBack(FeedBack feedback) {
		this.feedback.add(feedback);
	}
	
	

	public void updateRating() {
		for (FeedBack feeds : feedback) {
			if (feeds.giveMeRating() >= this.rating) {
				this.rating += feeds.giveMeRating() / this.feedback.size();
			} else {
				this.rating -= feeds.giveMeRating() / this.feedback.size();
			}

		}

	}

	public Profile getProfile() {
		return this.profile;
	}

	public String getEmail() {
		return this.email;
	}

	public String getPassword() {
		return this.password;
	}

	@Override
	public String toString() {
		return "User name " + profile.getName() + ", email=" + email + ", password=" + "********" + "]";
	}

}
