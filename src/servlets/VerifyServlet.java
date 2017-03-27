package servlets;

import java.io.IOException;

import javax.mail.Session;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mysql.jdbc.PreparedStatement;

import platform.EmailSender;
import users.User;

/**
 * Servlet implementation class VerifyServlet
 */
@WebServlet("/verify")
public class VerifyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("wtf");
		HttpSession session = request.getSession();
		String code = request.getParameter("code");
		User user = (User) session.getAttribute("currentSessionUser");
		while (!user.getCode().equals(code)) {
			RequestDispatcher view = request.getRequestDispatcher("/signupWelcome.html");
			view.forward(request, response);
		}
		RequestDispatcher view = request.getRequestDispatcher("/vigrata.html");
		view.forward(request, response);
	}

}
