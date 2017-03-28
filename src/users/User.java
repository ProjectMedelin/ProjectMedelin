package users;

import java.util.ArrayList;

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
	private String code;
	private boolean isVerified = false;
	private String role;

	public User(Profile profile, String email, String password,String code, String role) {
		
		this.role = role;
		this.profile = profile;
		this.email = email;
		this.password = password;
		this.feedback = new ArrayList<>();
		this.code=code;
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
	
	public String getRole() {
		return role;
	}

	public boolean isVerified() {
		return isVerified;
	}

	public void setVerified(boolean isVerified) {
		this.isVerified = isVerified;
	}

	public String getCode() {
		return code;
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		return true;
	}

}
