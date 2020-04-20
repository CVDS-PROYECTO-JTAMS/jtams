package edu.eci.cvds.entities;

public class User {
	private long id;
	private String name;
	private String lastName;
	private String email;
	private UserType type;

	public User() {}

	public User(long id, String name, String lastName, String email, UserType type) {
		this.id= id;
		this.name= name;
		this.lastName= lastName;
		this.email= email;
		this.type= type;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}


	public UserType getType() {
		return type;
	}

	public void setType(UserType type) {
		this.type = type;
	}
	
	public String toString() {
		return name + " "+ email+" "+type.name();
	}
}