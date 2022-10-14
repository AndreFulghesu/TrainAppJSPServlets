package it.andrea.trainApp.models;

public enum USER_ROLE {
	
	USER("USER"),
	ADMIN("ADMIN"),
	ADMINISTRATOR("ADMINISTRATOR");
	
	private String name;
	
	USER_ROLE(String name) {
		this.name = name;
	}

	public String getName() {
		return this.name;
	}

}
