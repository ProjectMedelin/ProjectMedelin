package ads;

import users.Developer;

public class Offer {

	private boolean isAccepted;
	private boolean isFinished;
	private Ads ads;
	private Developer dev;
	private boolean isInterviewSet;

	public Offer(Ads ads, Developer dev) {
		this.isAccepted = false;
		this.isFinished = false;
		this.ads = ads;
		this.dev = dev;
		this.isInterviewSet = false;
	}

	public boolean isAccepted() {
		return this.isAccepted;
	}

	public Developer getDeveloper() {
		return this.dev;
	}

	public void setAccepted(boolean isAccepted) {
		this.isAccepted = isAccepted;
	}

	public boolean isFinished() {
		return this.isFinished;
	}

	public boolean getIsIntervieset() {
		return this.isInterviewSet;
	}

	public void isInterviewSet(boolean isSeet) {
		this.isInterviewSet = isSeet;
	}

	public void setFinished(boolean isFinished) {
		this.isFinished = isFinished;
	}

	public Ads getAds() {
		return ads;
	}

	@Override
	public String toString() {
		return "Offer [isAccepted=" + isAccepted + ", isFinished=" + isFinished + ", Ad=" + ads + "]";
	}

}
