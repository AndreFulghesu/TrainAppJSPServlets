package it.andrea.trainApp.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import it.andrea.trainApp.models.AppUser;
import it.andrea.trainApp.util.Constants;

public class UserDAO {

	private UserDAO() {}
	
	public static AppUser loginUser(String username, String password) throws ClassNotFoundException, SQLException {

		DBConnection dbConnection = DBConnection.getInstance();

		Class.forName(dbConnection.getJdbcDriver());

		try (Connection con = DriverManager.getConnection(dbConnection.getJdbcConnection(), dbConnection.getUser(),
				dbConnection.getPassword());
				PreparedStatement statement = con.prepareStatement(Constants.LOGIN_QUERY);) {

			statement.setString(1, username);
			statement.setString(2, password);

			ResultSet rs = statement.executeQuery();

			if (rs.next()) {
				return AppUser.buildUser(rs);
			}

		} catch (SQLException ex) {
			throw new SQLException(ex.getMessage());
		}

		return null;
	}
	
	public static int registerUser(AppUser newUser) throws ClassNotFoundException, SQLException {
		
		DBConnection dbConnection = DBConnection.getInstance();

		Class.forName(dbConnection.getJdbcDriver());
		
		try (Connection con = DriverManager.getConnection(dbConnection.getJdbcConnection(), dbConnection.getUser(),
				dbConnection.getPassword());
				PreparedStatement statement = con.prepareStatement(Constants.LOGIN_QUERY);) {
			
			statement.setString(1, newUser.getUsername());
			statement.setString(2, newUser.getPassword());
			statement.setString(3, newUser.getEmail());
			statement.setString(4, newUser.getAddress());
			statement.setString(5, newUser.getBirthPlace());
			statement.setString(6, newUser.getUserRole().getName());
			statement.setString(7, newUser.getPhone());

			return statement.executeUpdate();
			
		}	
	}

	public static AppUser getUserById(String idUser) throws ClassNotFoundException, SQLException {
		
		DBConnection dbConnection = DBConnection.getInstance();

		Class.forName(dbConnection.getJdbcDriver());
		
		try (Connection con = DriverManager.getConnection(dbConnection.getJdbcConnection(), dbConnection.getUser(),
				dbConnection.getPassword());
				PreparedStatement statement = con.prepareStatement(Constants.GET_USER_BY_ID);) {
			
			statement.setLong(1, Long.valueOf(idUser));
			
			ResultSet rs = statement.executeQuery();

			if (rs.next()) {
				return AppUser.buildUser(rs);
			}
		}
		
		return null;
	}

}
