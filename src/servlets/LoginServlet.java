package servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import platform.UserDao;

@WebServlet("/LoginAndSignup")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher view = request.getRequestDispatcher("/Login.html");
		view.forward(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		String n = request.getParameter("Email");
		String p = request.getParameter("Password");

		if (UserDao.getInstance().validate(n, p)) {
			RequestDispatcher rd = request.getRequestDispatcher("/vigrata2.html");
			rd.forward(request, response);
		} else {
			out.print("Sorry email or password error");
			RequestDispatcher rd = request.getRequestDispatcher("vigrata.html");
			rd.forward(request, response);
		}

		out.close();

	}

}
