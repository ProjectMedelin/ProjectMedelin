package ads;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import java.util.Scanner;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

public class Interview {

	private Date date;
	private String interviewer;
	private Offer offer;
	Scanner sc = new Scanner(System.in);

	public Interview(String data, String interviewer, Offer offer) {
		setDate(data);
		this.interviewer = interviewer;
		this.offer = offer;
	}

	public void setDate(String date) {

		SimpleDateFormat sdf = new SimpleDateFormat("dd-M-yyyy");
		try {
			this.date = sdf.parse(date);
		} catch (ParseException e) {
			System.out.println("Wrong date format");
		}

	}

	public void saveInterviewInFile() {

		File file = new File("interviewDetails.txt");
		try {
			file.createNewFile();
		} catch (IOException e) {

			e.printStackTrace();
		}

		try (BufferedWriter bw = new BufferedWriter(new FileWriter(file))) {

			String interview = this.toString();

			bw.write(interview);

			System.out.println("Write Done");

		} catch (IOException e) {

			e.printStackTrace();

		}

	}

	public void sendInterviewEmail(String subjectText, String msgText) {
		final String username = "project.medelin@gmail.com";
		final String password = "parolamedelin";
        
		Properties props = new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.port", "587");
		Session session = Session.getInstance(props,
		  new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(username, password);
			}
		  });

		try {

			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress("project.medelin@gmail.com"));
			message.setRecipients(Message.RecipientType.TO,
				InternetAddress.parse(this.offer.getDeveloper().getEmail()));
			message.setSubject(subjectText);
			message.setText(msgText);

			Transport.send(message);

			System.out.println("Done");

		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}
	}
	

	@Override
	public String toString() {
		return "Interview [date=" + date + ", interviewer=" + interviewer + ", offer=" + offer + "]";
	}

}
