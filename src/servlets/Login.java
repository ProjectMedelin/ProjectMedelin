package servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import platform.LoginDao;

/**
 * Servlet implementation class Login
 */
@WebServlet("/LoginAndSignup")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher view = request.getRequestDispatcher("/Login.html");
		// don't add your web-app name to the path
		System.out.println("wtf");
		view.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		String n = request.getParameter("Email");
		String p = request.getParameter("Password");
		
        
		if (LoginDao.validate(n, p)) {
			RequestDispatcher rd = request.getRequestDispatcher("/vigrata2.html");
			rd.forward(request, response);
		} else {
			out.print("Sorry email or password error");
			RequestDispatcher rd = request.getRequestDispatcher("vigrata.html");
			rd.forward(request, response);
		}

		out.close();

		// RequestDispatcher view =
		// request.getRequestDispatcher("/vigrata.html");
		// don't add your web-app name to the path
		// System.out.println("wtf");
		// view.forward(request, response);

	}

}
