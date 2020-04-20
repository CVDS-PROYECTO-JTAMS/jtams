package edu.eci.cvds.persistence;

import java.util.List;

import edu.eci.cvds.entities.Comment;
import edu.eci.cvds.entities.Initiative;
import edu.eci.cvds.entities.UserType;
import edu.eci.cvds.entities.User;
import edu.eci.cvds.samples.services.ServicesException;

public interface UserDAO {
	
	public User getUserByCredetianls (String email, String password) throws ServicesException;
	
	public List<User> loadAll() throws ServicesException;
	public void modifyUser(String email, int rol) throws ServicesException;
	
	
}