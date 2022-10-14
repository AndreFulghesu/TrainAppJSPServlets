package it.andrea.trainApp.models;


import  java.sql.ResultSet;
import java.sql.SQLException;

public class AppUser {
	
	private long userId;
	private String username;
	private String password;
	private String email;
	private String address;
	private String birthPlace;
	private USER_ROLE userRole;
	private String phone;
	
	public static AppUser buildUser(ResultSet dbResultUser) throws SQLException {
		
		return new AppUser(
				dbResultUser.getLong("USER_ID"),
				dbResultUser.getString("USER_NAME"),
				dbResultUser.getString("USER_PASSWORD"),
				dbResultUser.getString("EMAIL"),
				dbResultUser.getString("ADDRESS"),
				dbResultUser.getString("BIRTH_PLACE"),
				USER_ROLE.valueOf(dbResultUser.getString("USER_ROLE")),
				dbResultUser.getString("PHONE")

				);
		
	}
	
	
	public AppUser(long idUser, String username, String password, String email, String address, String birthPlace,
			USER_ROLE userRole, String phone) {
		
		this.setIdUser(idUser);
		this.username = username;
		this.password = password;
		this.email = email;
		this.address = address;
		this.birthPlace = birthPlace;
		this.userRole = userRole;
		this.phone = phone;
	}
	
	

	public AppUser(String username, String password, String email, String address, String birthPlace,
			USER_ROLE userRole, String phone) {
		
		this.username = username;
		this.password = password;
		this.email = email;
		this.address = address;
		this.birthPlace = birthPlace;
		this.userRole = userRole;
		this.phone = phone;
	}


	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getBirthPlace() {
		return birthPlace;
	}
	public void setBirthPlace(String birthPlace) {
		this.birthPlace = birthPlace;
	}
	public USER_ROLE getUserRole() {
		return userRole;
	}
	public void setUserRole(USER_ROLE userRole) {
		this.userRole = userRole;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}

	public long getIdUser() {
		return userId;
	}


	public void setIdUser(long idUser) {
		this.userId = idUser;
	}
	
}
