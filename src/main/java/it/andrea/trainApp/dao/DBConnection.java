package it.andrea.trainApp.dao;

import java.io.IOException;
import java.util.Properties;

import it.andrea.trainApp.util.Constants;
import it.andrea.trainApp.util.CustomTrainAppException;

public class DBConnection {
	
	
	private static DBConnection instance = null;
	
	public static DBConnection getInstance() {
		if(instance == null) {
			instance = new DBConnection();
		}
		
		return instance;
	}
	
	private DBConnection()  {
		
		Properties prop = new Properties(); 
		
		try {
			
			prop.load(Thread.currentThread().getContextClassLoader().getResourceAsStream("/config.properties"));
			setJdbcDriver(prop.getProperty("db.jdbcDriver"));
			setJdbcConnection(prop.getProperty("db.jdbcConnection"));
			setUser(prop.getProperty("db.user"));
			setPassword(prop.getProperty("db.password"));	
		} catch (IOException  e) {
			CustomTrainAppException ex = new CustomTrainAppException(Constants.DB_ERROR);
			ex.printStackTrace();
		}
		
	}
	
	private String jdbcDriver;
	private String jdbcConnection;
	private String user;
	private String password;
	
	public String getUser() {
		return user;
	}

	private void setUser(String user) {
		this.user = user;
	}

	public String getPassword() {
		return password;
	}

	private void setPassword(String password) {
		this.password = password;
	}

	public String getJdbcDriver() {
		return jdbcDriver;
	}
	private void setJdbcDriver(String jdbcDriver) {
		this.jdbcDriver = jdbcDriver;
	}
	public String getJdbcConnection() {
		return jdbcConnection;
	}
	private void setJdbcConnection(String jdbcConnection) {
		this.jdbcConnection = jdbcConnection;
	}

}
