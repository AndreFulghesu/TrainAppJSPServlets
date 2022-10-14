package it.andrea.trainApp.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import it.andrea.trainApp.models.AppUser;
import it.andrea.trainApp.util.Constants;
import it.andrea.trainApp.util.DBConnection;


@WebServlet(name = "Login", urlPatterns = {"/login"})
public class LoginServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		DBConnection dbConnection = DBConnection.getInstance();
		Connection con = null;
		HttpSession session = request.getSession();
		
		
		try {
			
			Class.forName(dbConnection.getJdbcDriver());
			con = DriverManager.getConnection(dbConnection.getJdbcConnection(),dbConnection.getUser(),dbConnection.getPassword()); 
			PreparedStatement statement = con.prepareStatement(Constants.LOGIN_QUERY);
			
			statement.setString(1,username);
			statement.setString(2, password);
			
			ResultSet rs = statement.executeQuery();
			
			if(rs.next()) {
				AppUser loggedUser = AppUser.buildUser(rs);
				session.setAttribute("USER_ID", rs.getLong("USER_ID"));
				session.setAttribute(Constants.LOGGED_USER, loggedUser);
				session.setAttribute(Constants.STATUS, Constants.LOGIN_SUCCESS);	
				
				response.sendRedirect("homepage");
				
			} else {
				request.setAttribute(Constants.STATUS, Constants.LOGIN_FAILED);
				request.getRequestDispatcher("login.jsp").forward(request, response);
			}
			
			statement.close();
			
		} catch(SQLException | ClassNotFoundException  e) {
			
			e.printStackTrace();
			request.getSession().setAttribute("ERROR",Constants.DB_ERROR);
            request.getRequestDispatcher("errorPage.jsp").forward(request, response);
	
		}
	}

}
