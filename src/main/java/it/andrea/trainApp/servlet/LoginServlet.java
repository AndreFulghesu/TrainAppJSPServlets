package it.andrea.trainApp.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import it.andrea.trainApp.dao.UserDAO;
import it.andrea.trainApp.models.AppUser;
import it.andrea.trainApp.util.Constants;

@WebServlet(name = "Login", urlPatterns = { "/login" })
public class LoginServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String username = request.getParameter("username");
		String password = request.getParameter("password");
		HttpSession session = request.getSession();

		try {

			AppUser loggedUser = UserDAO.loginUser(username, password);
			
			if (loggedUser != null) {

				session.setAttribute("USER_ID", loggedUser.getIdUser());
				session.setAttribute(Constants.LOGGED_USER, loggedUser);
				session.setAttribute(Constants.STATUS, Constants.LOGIN_SUCCESS);

				response.sendRedirect("homepage");

			} else {
				request.setAttribute(Constants.STATUS, Constants.LOGIN_FAILED);
				request.getRequestDispatcher("login.jsp").forward(request, response);
			}

		} catch (SQLException | ClassNotFoundException e) {

			e.printStackTrace();
			request.getSession().setAttribute("ERROR", Constants.DB_ERROR);
			request.getRequestDispatcher("errorPage.jsp").forward(request, response);

		}
	}

}
