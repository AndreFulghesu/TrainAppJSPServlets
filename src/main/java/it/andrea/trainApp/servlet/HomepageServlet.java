package it.andrea.trainApp.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import it.andrea.trainApp.dao.DBConnection;
import it.andrea.trainApp.models.AppUser;
import it.andrea.trainApp.models.USER_ROLE;
import it.andrea.trainApp.util.Constants;


@WebServlet(name = "Homepage", urlPatterns = {"/homepage"})
public class HomepageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		DBConnection dbConnection = DBConnection.getInstance();
		Connection con = null;
		PreparedStatement statement = null;
		HttpSession session = request.getSession();
		
		try {
			
			Class.forName(dbConnection.getJdbcDriver());
			con = DriverManager.getConnection(dbConnection.getJdbcConnection(),dbConnection.getUser(),dbConnection.getPassword()); 
			
			AppUser loggedUser = (AppUser)session.getAttribute(Constants.LOGGED_USER);
			
			if(loggedUser.getUserRole().equals(USER_ROLE.ADMINISTRATOR)) {
				
				List<AppUser> allUsers = new ArrayList<>();
				statement = con.prepareStatement(Constants.GET_ALL_USERS);
				ResultSet rs = statement.executeQuery();
				
				while(rs.next()) {
					allUsers.add(AppUser.buildUser(rs));
				}
				
				request.setAttribute(Constants.ALL_USERS, allUsers);
				request.getRequestDispatcher("homepage.jsp").forward(request, response);
				
				statement.close();
				
			}
			
			
			
		} catch(SQLException | ClassNotFoundException  e) {
			
			e.printStackTrace();
			request.getSession().setAttribute("ERROR",Constants.DB_ERROR);
            request.getRequestDispatcher("errorPage.jsp").forward(request, response);
			
		}		
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
