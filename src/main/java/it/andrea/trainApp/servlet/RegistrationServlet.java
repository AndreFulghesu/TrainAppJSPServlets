package it.andrea.trainApp.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.andrea.trainApp.models.USER_ROLE;
import it.andrea.trainApp.util.Constants;
import it.andrea.trainApp.util.DBConnection;

/*
 * the type is the same in the action attribute 
 * in a classic html form tag 
 */
@WebServlet("/register")
public class RegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {

		String usernname = request.getParameter("username");
		String password = request.getParameter("password");
		String email = request.getParameter("email");
		String address = request.getParameter("address");
		String birthPlace = request.getParameter("birth_place");
		String phone = request.getParameter("phone");
		String userRole = request.getParameter("user_role");

		if (usernname.isEmpty() || password.isEmpty() || email.isEmpty() || address.isEmpty() || birthPlace.isEmpty()
				|| phone.isEmpty() || userRole == null) {

			request.setAttribute(Constants.STATUS, Constants.REGISTRATION_MANDATORY);
			request.getRequestDispatcher("registration.jsp").forward(request, response);

		} else {

			DBConnection dbConnection = DBConnection.getInstance();
			Connection con = null;

			try {
				Class.forName(dbConnection.getJdbcDriver());
				con = DriverManager.getConnection(dbConnection.getJdbcConnection(), dbConnection.getUser(),
						dbConnection.getPassword());
				PreparedStatement statement = con.prepareStatement(Constants.BASIC_INSERT_USER);

				statement.setString(1, usernname);
				statement.setString(2, password);
				statement.setString(3, email);
				statement.setString(4, address);
				statement.setString(5, birthPlace);
				statement.setString(6, USER_ROLE.valueOf(userRole).getName());
				statement.setString(7, phone);

				int rowCount = statement.executeUpdate();

				if (rowCount > 0) {
					request.setAttribute(Constants.STATUS, Constants.REGISTRATION_SUCCESS);
				} else {
					request.setAttribute(Constants.STATUS, Constants.REGISTRATION_FAILED);
				}

				request.getRequestDispatcher("login.jsp").forward(request, response);

			} catch (SQLException | ClassNotFoundException e) {
				e.printStackTrace();
				request.getSession().setAttribute("ERROR", Constants.DB_ERROR);
				request.getRequestDispatcher("errorPage.jsp").forward(request, response);

			}
		}
	}

}
