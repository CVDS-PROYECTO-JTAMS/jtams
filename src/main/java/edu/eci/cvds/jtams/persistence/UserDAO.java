package edu.eci.cvds.jtams.persistence;

import edu.eci.cvds.jtams.exceptions.JtamsExceptions;
import edu.eci.cvds.jtams.model.User;

import java.util.List;

public interface UserDAO {
	
	public void createUser (User user) throws JtamsExceptions;
	
	public void updateUser (User user) throws JtamsExceptions;
	
	public List<User> getUsers() throws JtamsExceptions;
	
	public User getUser (String username) throws JtamsExceptions;

	public void updateTypeUser (String email,int userType) throws JtamsExceptions;

	

}
