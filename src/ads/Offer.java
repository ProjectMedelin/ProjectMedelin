package ads;

import java.util.ArrayList;

public class Offer {

	private boolean isAccepted;
	private boolean isFinished;
	private Ads ads;

	public Offer(Ads ads) {
		this.isAccepted = false;
		this.isFinished = false;
		this.ads = ads;
	}

	public boolean isAccepted() {
		return this.isAccepted;
	}

	public void setAccepted(boolean isAccepted) {
		this.isAccepted = isAccepted;
	}

	public boolean isFinished() {
		return this.isFinished;
	}

	public void setFinished(boolean isFinished) {
		this.isFinished = isFinished;
	}

}
