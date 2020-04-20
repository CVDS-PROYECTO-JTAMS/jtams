package edu.eci.cvds.persistence.mybatisimpl;

import java.util.List;

import com.google.inject.Inject;

import edu.eci.cvds.entities.User;
import edu.eci.cvds.persistence.UserDAO;
import edu.eci.cvds.persistence.mybatisimpl.mappers.UserMapper;
import edu.eci.cvds.samples.services.ServicesException;

public class MyBatisUserDao implements UserDAO{
	
	@Inject
	UserMapper userMapper;
	
	public List<User> loadAll() throws ServicesException {
		return userMapper.consultUsers();
	}

	public User getUserByCredetianls(String email, String password) throws ServicesException {
		try {
			return userMapper.getUserByCredentials(email, password);
		}catch(Exception e) {
			e.printStackTrace();
			throw new ServicesException("Load user"+email+ "persistence error");
		}
	}
	
	@Override
	public void modifyUser(String email, int rol) throws ServicesException {
		try {
			userMapper.modifyUser(email,rol);
		}catch(Exception e) {
			e.printStackTrace();
			throw new ServicesException("modify user"+email+ "persistence error");
		}

	}
}