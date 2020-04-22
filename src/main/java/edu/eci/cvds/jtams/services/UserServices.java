package edu.eci.cvds.jtams.services;

import edu.eci.cvds.jtams.exceptions.JtamsExceptions;
import edu.eci.cvds.jtams.model.Comment;
import edu.eci.cvds.jtams.model.Initiative;
import edu.eci.cvds.jtams.model.User;
import edu.eci.cvds.jtams.model.UserType;

import java.util.ArrayList;
import java.util.List;

public interface UserServices {
	
	public void createUser (User user) throws JtamsExceptions;
	
	public void updateUser (User user) throws JtamsExceptions;
	
	public List<User> getUsers() throws JtamsExceptions;
	
	public User getUser (String username) throws JtamsExceptions;
	
	public boolean validateLogin(String userName, String password) throws JtamsExceptions;
	
	public void updateTypeUser(String username,UserType userType) throws JtamsExceptions;


//	public Comment getComentario(int idIniciativa);
//
//	public void createComentario(Comment comentario);
//
	public ArrayList<Comment> getComentariosIniciativa(int idIniciativa);
	
	public void createComentario(Comment comentario);

	public List<Initiative> buscainiciativaporpalabra(List<String> iniciativas) throws JtamsExceptions;
	public List<Initiative> dariniciativas() throws JtamsExceptions;


}
