package edu.eci.cvds.jtams.model;

public class User {
	
	private int id;
	private String name;
	private String email;
	private String password;
	private UserType type;
	
	public User() {
		
	}
	
	public User(int id, String name, String email, String password, UserType type) {
		
		this.id = id;
		this.name = name;
		this.email =email;
		this.password = password;
		this.type = type;
	}
	
	public String getName() {
		return name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setName(String name) {
		this.name = name;
	}

	public UserType getType() {
		return type;
	}

	public void setType(UserType type) {
		this.type = type;
	}

	@Override
    public String toString() {
        return "User{" + "name=" + name + ", email=" + email + ", password" + password + '}';
    }

	

	

}
