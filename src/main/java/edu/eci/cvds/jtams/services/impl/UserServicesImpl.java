package edu.eci.cvds.jtams.services.impl;

import java.util.List;

import edu.eci.cvds.jtams.exceptions.JtamsExceptions;
import edu.eci.cvds.jtams.model.User;
import edu.eci.cvds.jtams.persistence.UserDAO;
import edu.eci.cvds.jtams.services.UserServices;

public class UserServicesImpl implements UserServices{
	
	private UserDAO userDao;

	@Override
	public void createUser(User user) throws JtamsExceptions {
		if (user== null) {
			throw new JtamsExceptions("The User is Null");
		}
		userDao.createUser(user);
	}

	@Override
	public void updateUser(User user) {
		// TODO Auto-generated method s
		
	}

	@Override
	public List<User> getUsers() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User getUser(String username) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean validateLogin(String userName, String password) {
		// TODO Auto-generated method stub
		return false;
	}

}
