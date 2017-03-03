package ads;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Interview {
	
	private Date date;
	private String interviewer;
	private Offer offer;
	
	public Interview(Date date, String interviewer, Offer offer) {
        this.date = date;
		this.interviewer = interviewer;
		this.offer = offer;
	}
	
	public void setDate(String date){
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd-M-yyyy");
		try {
			this.date = sdf.parse(date);
		} catch (ParseException e) {
			System.out.println("Wrong date format");
		}
	
    }

	@Override
	public String toString() {
		return "Interview [date=" + date + ", interviewer=" + interviewer + ", offer=" + offer + "]";
	}
	
	
	
	
}
