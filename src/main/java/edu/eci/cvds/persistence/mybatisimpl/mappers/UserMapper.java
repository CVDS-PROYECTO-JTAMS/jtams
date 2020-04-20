package edu.eci.cvds.persistence.mybatisimpl.mappers;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import edu.eci.cvds.entities.User;

public interface UserMapper{
	public User getUserByCredentials(@Param("email") String email,  @Param("password") String password);
	
	public List<User> consultUsers();
	public void modifyUser(@Param("email")String email, @Param("rol")int rol);
}