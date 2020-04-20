package edu.eci.cvds.samples.services.impl;

import java.util.List;

import javax.inject.Inject;

import edu.eci.cvds.entities.Comment;
import edu.eci.cvds.entities.Initiative;
import edu.eci.cvds.entities.User;
import edu.eci.cvds.persistence.UserDAO;
import edu.eci.cvds.samples.services.InitiativeServices;
import edu.eci.cvds.samples.services.ServicesException;
import edu.eci.cvds.persistence.InitiativeDAO;
import edu.eci.cvds.entities.TypeStatus;

public class InitiativeServiceImpl implements InitiativeServices {

	@Inject
	private UserDAO userDAO;

	@Inject
	private InitiativeDAO initiativeDAO;
	
	@Override
	public void createUser(User user) throws ServicesException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<User> listUsers() throws ServicesException {
		return userDAO.loadAll();
	}

	@Override
	public void createInitiative(String description, String area, int idus) throws ServicesException{
		try {
			
			initiativeDAO.addInitiative(description, area, idus);
		}catch (ServicesException ex) {
			throw new ServicesException("Error trying to insert the initiative", ex);
		}
	}

	@Override
	public void createComment(long idUser, int idIni, String comment) throws ServicesException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void registerVote(long idUser, int idIni) throws ServicesException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Comment> searchCommentsByInitiative(int id) throws ServicesException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Initiative searchInitiative(int idIni) throws ServicesException {
		return initiativeDAO.load(idIni);
	}

	@Override
	public User getUser(String email, String password) throws ServicesException {
		return userDAO.getUserByCredetianls(email, password);
	}
	
	@Override
	public List<Initiative> searchInitiativeByKeywords(List<String> keywords) throws ServicesException {
		return initiativeDAO.load(keywords);
	}
	@Override
	public void modifyUser(String email, int rol) throws ServicesException {
		userDAO.modifyUser(email, rol);

	}
	@Override
	public void modifyInitiative(String newStatus, int id) throws ServicesException {
		initiativeDAO.modifyInitiative(newStatus,id);

	}
	@Override
	public List<Initiative> listInitiative() throws ServicesException {
		return initiativeDAO.loadAll();
	}
	
	@Override
	public List<TypeStatus> listStatus() throws ServicesException {
		return initiativeDAO.listStatus();
	}

}