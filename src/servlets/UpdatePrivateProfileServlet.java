package servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import platform.ProfileDao;
import profile.EmplooyerProfile;
import users.User;

/**
 * Servlet implementation class UpdatePrivProfileServlet
 */
@WebServlet("/UpdatePrivateProfile")
public class UpdatePrivateProfileServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String name = request.getParameter("name");
		String about = request.getParameter("about");
		String website = request.getParameter("website");
		String video = request.getParameter("video");
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("currentSessionUser");
		EmplooyerProfile empProfilePrivate = (EmplooyerProfile) user.getProfile();
		empProfilePrivate.setName(name);
		empProfilePrivate.setAbout(about);
		empProfilePrivate.setWebsite(website);
		empProfilePrivate.setVideo(video);

		if (!ProfileDao.saveEmployerPrivate(empProfilePrivate)) {
			RequestDispatcher view = request.getRequestDispatcher("/updatePrivateProfile.html");
			view.forward(request, response);
		} else {
			RequestDispatcher view = request.getRequestDispatcher("/compProfile.html");
			view.forward(request, response);

		}
	}

}
