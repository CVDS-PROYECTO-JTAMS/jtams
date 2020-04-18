package edu.eci.cvds.jtams.services;

import java.util.List;

import edu.eci.cvds.jtams.model.User;

public interface UserServices {
	
	public void createUser (User user);
	
	public void updateUser (User user);
	
	public List<User> getUsers();
	
	public User getUser (String username);
	
	public boolean validateLogin(String userName, String password);

}
