package edu.eci.cvds.samples.services;

import edu.eci.cvds.entities.*;
import java.util.List;

public interface InitiativeServices {

/**
 * Crea un usuario
 * @param user
 * @throws ServicesException
 */
	public void createUser(User user) throws ServicesException;

	/**
	 * 
	 * @return lista de usuarios
	 * @throws ServicesException
	 */
	public List<User> listUsers() throws ServicesException;
	
	public void modifyUser(String email, int rol) throws ServicesException;
	/** 
	 * @param i
	 * @throws ServicesException
	 */
	public void createInitiative(String description, String area, int idus) throws ServicesException;
	/**
	 * 
	 * @param idUser
	 * @param idIni
	 * @param comment
	 * @throws ServicesException
	 */
	public void createComment (long idUser, int idIni, String comment) throws ServicesException;
	/**
	 * 
	 * @param idUser
	 * @param idIni
	 * @throws ServicesException
	 */
	public void registerVote (long idUser,int idIni) throws ServicesException;
	/**
	 * 
	 * @param id
	 * @return
	 * @throws ServicesException
	 */
	public List<Comment> searchCommentsByInitiative (int id) throws ServicesException;

	/**
	 * 
	 * @param idIni
	 * @return
	 * @throws ServicesException
	 */
	public Initiative searchInitiative(int idIni) throws ServicesException; 
	
	/**
	 * 
	 * @param id
	 * @return
	 * @throws ServicesException
	 */
	public User getUser(String email, String password) throws ServicesException;
	
	/**
	 * 
	 * @param keywords
	 * @return
	 * @throws ServicesException
	 */
	public List<Initiative> searchInitiativeByKeywords(List<String> keywords) throws ServicesException;

	public List<Initiative> listInitiative() throws ServicesException;
	
	public void modifyInitiative(String newStatus, int id) throws ServicesException;
	
	public List<TypeStatus> listStatus() throws ServicesException;
}
