package servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import platform.UserDao;
import profile.DeveloperProfile;
import profile.Profile;
import users.Developer;
import users.User;
import validators.EmailValidator;
import validators.PasswordValidator;

/**
 * Servlet implementation class SignUp
 */
@WebServlet("/SignUp")
public class DeveloperRegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private PasswordValidator passValidator = new PasswordValidator();
	private EmailValidator emailValidator = new EmailValidator();

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String email = request.getParameter("email");
		String password = request.getParameter("password");
		User user = null;
		if (passValidator.validate(password) && emailValidator.validate(email)) {
			user = new Developer(new DeveloperProfile(), email, password);
		} else {
			System.out.println("Invalid password or email");
			// RequestDispatcher view =
			// request.getRequestDispatcher("/vigrata.html");
		}

		if (!UserDao.getInstance().save(user)) {
			System.out.println("maikata si ebava");
			RequestDispatcher view = request.getRequestDispatcher("/devregister.html"); // TODO
			view.forward(request, response);
		} else {
            RequestDispatcher view = request.getRequestDispatcher("/verify.html");
			view.forward(request, response);
		}
	}

}
