package it.andrea.trainApp.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.andrea.trainApp.dao.UserDAO;
import it.andrea.trainApp.models.AppUser;
import it.andrea.trainApp.util.Constants;


@WebServlet("/modify-user")
public class ModifyUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String idUser = request.getParameter("id");
		try {

			AppUser searchedUser = UserDAO.getUserById(idUser);
			
			if (searchedUser != null) {

				request.setAttribute(Constants.SEARCHED_USER, searchedUser);

				request.getRequestDispatcher("modifyUser.jsp").forward(request, response);

			} else {
				request.setAttribute(Constants.STATUS, Constants.GENERIC_ERROR);
				request.getRequestDispatcher("homepage.jsp").forward(request, response);
			}

		} catch (SQLException | ClassNotFoundException e) {

			e.printStackTrace();
			request.getSession().setAttribute("ERROR", Constants.DB_ERROR);
			request.getRequestDispatcher("errorPage.jsp").forward(request, response);

		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
