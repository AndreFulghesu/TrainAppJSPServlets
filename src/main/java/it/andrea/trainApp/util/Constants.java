package it.andrea.trainApp.util;

public interface Constants {
	
	public static final String BASIC_INSERT_USER = "INSERT INTO APP_USER(USER_NAME,USER_PASSWORD,EMAIL,ADDRESS,BIRTH_PLACE,USER_ROLE,PHONE)"
			+ "VALUES(?,?,?,?,?,?,?)";
	
	public static final String LOGIN_QUERY = "SELECT * FROM APP_USER WHERE USER_NAME = ? AND USER_PASSWORD = ?";
	
	public static final String GET_ALL_USERS = "SELECT * FROM APP_USER";
	
	
	
	/*
	 ** generics messages
	 */
	public static final String DB_ERROR = "Si � verificato un errore durante la connessione al database";
	public static final String STATUS = "STATUS";
	public static final String LOGGED_USER = "LOGGED_USER";
	public static final String REGISTRATION_MANDATORY = "I campi sono tutti obbligatori!";
	public static final String REGISTRATION_SUCCESS = "La registrazione � avvenuta con successo";
	public static final String REGISTRATION_FAILED = "Si � verificato un errore durante la registrazione";

	public static final String LOGIN_SUCCESS = "Utente loggato con successo, Benvenuto";

	public static final String LOGIN_FAILED = "Username o password non corretti!";

	public static final String ALL_USERS = "ALL_USERS";
}
