package servlets;

import java.awt.image.BufferedImage;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import javafx.scene.image.Image;
import platform.EmailSender;
import platform.ProfileDao;
import platform.UserDao;
import profile.DeveloperProfile;
import profile.Profile;
import users.Developer;
import users.User;
import validators.CodeGenerator;
import validators.EmailValidator;

/**
 * Servlet implementation class EditProfileServlet
 */
@WebServlet("/updateDevProfile")
public class UpdateDevProfileServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static int counter = 0;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String name = request.getParameter("name");
		String about = request.getParameter("about");
		String website = request.getParameter("website");
		String github = request.getParameter("github");
		String linkedin = request.getParameter("linkedin");
		 // input stream of the upload file
		//File picture = (File) request.getPart("picture");
		 //InputStream inputStream = new FileInputStream(picture);
			
		
        
        //File CV = (File) request.getPart("CV");
		String video = request.getParameter("video");
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("currentSessionUser");
		DeveloperProfile devProfile = (DeveloperProfile) user.getProfile();
		devProfile.setName(name);
		System.out.println(devProfile.getName());
		
		devProfile.setAbout(about);
		devProfile.setWebsite(website);
		//devProfile.setCV(CV);
		devProfile.setGithub(github);
		devProfile.setLinkedIn(linkedin);
		devProfile.setVideo(video);
		//devProfile.setProfilePicture(picture);
		if (!ProfileDao.saveDeveloper(devProfile)) {
			RequestDispatcher view = request.getRequestDispatcher("/updateDevProfile.html");
			view.forward(request, response);
		} else {
			RequestDispatcher view = request.getRequestDispatcher("/devProfile.jsp");
			view.forward(request, response);
		}

	}
	
	

	}

	/*
 * protected void doPost(HttpServletRequest request, HttpServletResponse
 * response) throws ServletException, IOException { String code =
 * CodeGenerator.createCode();
 * 
 * String email = request.getParameter("email"); String password =
 * request.getParameter("password"); User user = null; if
 * (passValidator.validate(password) && EmailValidator.validate(email)) { user =
 * new Developer(new DeveloperProfile(), email, password,code, "developer"); if
 * (!UserDao.getInstance().save(user)) { System.out.println("maikata si ebava");
 * RequestDispatcher view = request.getRequestDispatcher("/devregister.html");
 * view.forward(request, response); } else { HttpSession session =
 * request.getSession(true); session.setAttribute("currentSessionUser", user);
 * ProfileDao.setProfile(user.getProfile(), email); RequestDispatcher view =
 * request.getRequestDispatcher("/signupWelcome.html");
 * EmailSender.sendSimpleEmail(email,"Medellin verification code",
 * "Your code is: " + code); view.forward(request, response); }
 * 
 * } else { RequestDispatcher view =
 * request.getRequestDispatcher("/devregister.html");
 * System.out.println("Invalid password or email"); view.forward(request,
 * response);
 * 
 * }
 * 
 * }
 */
