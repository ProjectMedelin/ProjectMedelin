package ads;

import java.util.ArrayList;

public class Ads {
	
	private String title;
	private String desctription;
	private String requirenments;
	private String conditions;
	private ArrayList<Enum> reqTech;
	
	public Ads(String title, String desctription, String requirenments, String conditions, ArrayList<Enum> reqTech) {
		super();
		this.title = title;
		this.desctription = desctription;
		this.requirenments = requirenments;
		this.conditions = conditions;
		this.reqTech = reqTech;
	}
	
	
	
}
