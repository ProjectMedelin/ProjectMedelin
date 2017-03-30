package servlets;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import ads.Ads;
import database.DBUtil;
import platform.AdsDao;
import users.Employer;
import users.User;

/**
 * Servlet implementation class CreateAdServlet
 */
@WebServlet("/CreateAd")
public class CreateAdServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int id = 0;
		String title = request.getParameter("title");
		String description = request.getParameter("description");
		String requirenments = request.getParameter("requirenments");
		String conditions = request.getParameter("conditions");
		HttpSession session = request.getSession();
		Employer user = (Employer) session.getAttribute("currentSessionUser");
		String sql = "SELECT id from users where email=?";
		try {
			PreparedStatement st = DBUtil.getInstance().getConnection().prepareStatement(sql);
			st.setString(1, user.getEmail());
			ResultSet rs = st.executeQuery();
			rs.next();
			id = rs.getInt("id");
			System.out.println(id);
			Ads ad = new Ads(title, description, requirenments, conditions, user);
			if (!AdsDao.createAd(ad, id)) {
				RequestDispatcher view = request.getRequestDispatcher("/createAd.html");
				view.forward(request, response);
			} else {
				RequestDispatcher view = request.getRequestDispatcher("/Ad.html");
				view.forward(request, response);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
