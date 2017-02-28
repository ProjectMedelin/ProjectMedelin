package ads;

import java.util.ArrayList;

public class Offer extends Ads{
	
	private boolean isAccepted;

	public Offer(String title, String desctription, String requirenments, String conditions, ArrayList<Enum> reqTech) {
		super(title, desctription, requirenments, conditions, reqTech);
		isAccepted = false;
	}
	
}
