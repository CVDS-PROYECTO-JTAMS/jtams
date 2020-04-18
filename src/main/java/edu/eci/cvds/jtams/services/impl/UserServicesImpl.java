package edu.eci.cvds.jtams.services.impl;

import java.util.List;

import javax.persistence.PersistenceException;

import com.google.inject.Inject;
import edu.eci.cvds.jtams.exceptions.JtamsExceptions;
import edu.eci.cvds.jtams.model.User;
import edu.eci.cvds.jtams.model.UserType;
import edu.eci.cvds.jtams.persistence.UserDAO;
import edu.eci.cvds.jtams.services.UserServices;

public class UserServicesImpl implements UserServices{

	@Inject
	private UserDAO userDao;

	@Override
	public void createUser(User user) throws JtamsExceptions {
		if (user == null) {
			throw new JtamsExceptions("The User is Null");
		}else {
			userDao.createUser(user);
		}
	}

	@Override
	public void updateUser(User user)throws JtamsExceptions {
		if (user == null) {
			throw new JtamsExceptions("The user in null");
		}else {
			userDao.updateUser(user);
		}
	}
	
	@Override
	public UserType updateTypeUser(UserType userType) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<User> getUsers() throws JtamsExceptions {
		return userDao.getUsers();
	}

	@Override
	public User getUser(String username) throws JtamsExceptions {
		try {
		return userDao.getUser(username);
		} catch (PersistenceException e) {
			throw new JtamsExceptions("The username is not valid", e);
		}
	}

	@Override
	public boolean validateLogin(String userName, String password) throws JtamsExceptions {
		User user = userDao.getUser(userName);
		if (user == null) {
			return false;
		}
		return true;
	}

	public UserDAO getUserDao() {
		return userDao;
	}

	public void setUserDao(UserDAO userDao) {
		this.userDao = userDao;
	}
}
