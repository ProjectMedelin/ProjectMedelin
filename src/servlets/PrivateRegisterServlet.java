package servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import platform.EmailSender;
import platform.UserDao;
import profile.EmplooyerProfile;
import profile.EmplooyerProfile.EmplooyerType;
import users.Employer;
import users.User;
import validators.CodeGenerator;
import validators.EmailValidator;
import validators.PasswordValidator;

/**
 * Servlet implementation class PrivateRegisterServlet
 */
@WebServlet("/PrivateRegister")
public class PrivateRegisterServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	private PasswordValidator passValidator = new PasswordValidator();
	private EmailValidator emailValidator = new EmailValidator();

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String code = new CodeGenerator().createCode();
		
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		User user = null;
		if (passValidator.validate(password) && emailValidator.validate(email)) {
			user = new Employer(new EmplooyerProfile(EmplooyerType.PRIVATE), email, password,code, "private");
			if (!UserDao.getInstance().save(user)) {
				System.out.println("maikata si ebava");
				RequestDispatcher view = request.getRequestDispatcher("/devregister.html"); // TODO
				view.forward(request, response);
			} else {
				HttpSession session = request.getSession(true);
				session.setAttribute("currentSessionUser", user);
				RequestDispatcher view = request.getRequestDispatcher("/signupWelcome.html");
				EmailSender.sendSimpleEmail(email,"Medellin verification code", "Your code is: " + code);
				view.forward(request, response);
			}

		} else {
			RequestDispatcher view = request.getRequestDispatcher("/devregister.html");
			System.out.println("Invalid password or email");
			// RequestDispatcher view =
			// request.getRequestDispatcher("/vigrata.html");
		}

	}

}