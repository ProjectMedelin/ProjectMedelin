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

import platform.EmailSender;

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

	public void sendInterviewEmail() {
		
		System.out.println("Please enter receiver email: ");
		String receiverEmail = sc.nextLine();
		System.out.println("Please enter email subject: ");
		String subjectText = sc.nextLine();
		System.out.println("Please enter your massage: ");
		String msgText = sc.nextLine();
		
		EmailSender.sendSimpleEmail(receiverEmail, subjectText, msgText);
		
		
	}
	

	@Override
	public String toString() {
		return "Interview [date=" + date + ", interviewer=" + interviewer + ", offer=" + offer + "]";
	}

}
