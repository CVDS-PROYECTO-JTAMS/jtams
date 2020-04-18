package edu.eci.cvds.jtams.persistence;

import java.util.List;

import edu.eci.cvds.jtams.model.User;

public interface UserDAO {
	
	public void createUser (User user);
	
	public void updateUser (User user);
	
	public List<User> getUsers();
	
	public User getUser (String username);

}
