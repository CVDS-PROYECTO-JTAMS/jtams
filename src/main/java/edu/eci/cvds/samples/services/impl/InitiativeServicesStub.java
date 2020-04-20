package edu.eci.cvds.samples.services.impl;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import edu.eci.cvds.samples.services.*;
import edu.eci.cvds.entities.*;

public class InitiativeServicesStub  implements InitiativeServices{
	
	private final Map<Long,User> users;
	private final Map<Integer,UserType> usersType;
	private final Map<Integer,Initiative> initiatives;
	private final Map<Integer,Comment> comments;
	 
	 public InitiativeServicesStub() {
		   users = new HashMap<Long,User>();
		   usersType = new HashMap<Integer,UserType>();
	       initiatives = new HashMap<Integer,Initiative>();
	       comments = new HashMap<Integer,Comment>();
	       poblar();
	 }


	public void createUser(User user) throws ServicesException {
		// TODO Auto-generated method stub
		
	}

	public List<User> listUsers() throws ServicesException {
		// TODO Auto-generated method stub
		return null;
	}

	public void createInitiative(String description, String area, int idus) throws ServicesException{
		// TODO Auto-generated method stub
		
	}

	public void createComment(long idUser, int idIni, String comment) throws ServicesException {
		// TODO Auto-generated method stub
		
	}

	public void registerVote(long idUser, int idIni) throws ServicesException {
		// TODO Auto-generated method stub
		
	}

	public List<Comment> searchCommentsByInitiative(int id) throws ServicesException {
		// TODO Auto-generated method stub
		return null;
	}

	public Initiative searchInitiative(int idIni) throws ServicesException {
		// TODO Auto-generated method stub
		return null;
	}
	
	 private void poblar() {
		 UserType admin = UserType.Administrador;
		 UserType pmo_odi= UserType.Personal;
		 UserType proponent= UserType.Proponente;
		 UserType publico= UserType.Publico;

		 usersType.put(1,admin);
		 usersType.put(2,pmo_odi);
		 usersType.put(3,proponent);
		 usersType.put(4, publico);

		 
		 User u2=new User(123456789,"juan","romero","juanromero@gmail.com",proponent);
		 User u3=new User(111111111,"sebastian","villamarin","sebasvilla@gmail.com",proponent);
		 User u4=new User(987654321,"verbo","camacho","verbocamacho@gmail.com",pmo_odi);
		 User u5=new User(1015475102,"nikolai","bermudez","nikolai9906n@gmail.com",admin);

		 
		 users.put((long)2, u2);
		 users.put((long)3, u3);
		 users.put((long)4, u4);
		 users.put((long)5, u5);

		 List<String> keyWords= Arrays.asList("Jardin","Ba�o","Tecnologia");

		 /*Initiative ini1=new Initiative ("Hacer mas ba�os", keyWords,"Logistica",1015475102);
		 Initiative ini2=new Initiative ("Expandir zona verde", keyWords,"Jardineria",123456789);
		 Initiative ini3=new Initiative ("Mas computadores", keyWords,"Tecnologia",1016095672);

		 initiatives.put(1, ini1);
		 initiatives.put(2, ini2);
		 initiatives.put(3, ini3);

		 Comment comment1=new Comment(u1, ini1, "muy buena idea");
		 Comment comment2=new Comment(u2, ini2, "Mas espacio para comer!!");

		 comments.put(1, comment1);
		 comments.put(2, comment2);*/
	 }


	 @Override
	public User getUser(String email, String password) throws ServicesException {
			// TODO Auto-generated method stub
			return null;
	}
	@Override
	public List<Initiative> searchInitiativeByKeywords(List<String> keywords) throws ServicesException {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public void modifyUser(String email, int rol) throws ServicesException {
		// TODO Auto-generated method stub

	}

	@Override
	public void modifyInitiative(String newStatus, int id) throws ServicesException {
		// TODO Auto-generated method stub

	}
	@Override
	public List<Initiative> listInitiative() throws ServicesException {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public List<TypeStatus> listStatus() throws ServicesException {
		// TODO Auto-generated method stub
		return null;
	}

	

}