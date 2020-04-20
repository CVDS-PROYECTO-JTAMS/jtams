package edu.eci.cvds.jtams.services;

import java.util.ArrayList;
import java.util.List;

import edu.eci.cvds.jtams.exceptions.JtamsExceptions;
import edu.eci.cvds.jtams.model.UserType;
import edu.eci.cvds.jtams.model.Comment;
import edu.eci.cvds.jtams.model.Initiative;
import edu.eci.cvds.jtams.model.User;

public interface UserServices {
	
	public void createUser (User user) throws JtamsExceptions;
	
	public void updateUser (User user) throws JtamsExceptions;
	
	public List<User> getUsers() throws JtamsExceptions;
	
	public User getUser (String username) throws JtamsExceptions;
	
	public boolean validateLogin(String userName, String password) throws JtamsExceptions;
	
	public UserType updateTypeUser(UserType userType);

//	public Comment getComentario(int idIniciativa);
//
//	public void createComentario(Comment comentario);
//
	public ArrayList<Comment> getComentariosIniciativa(int idIniciativa);
	
	public void createComentario(Comment comentario);
	public List<Initiative> buscainiciativaporpalabra(List<String> iniciativas) throws JtamsExceptions;
	public List<Initiative> dariniciativas() throws JtamsExceptions;


}
