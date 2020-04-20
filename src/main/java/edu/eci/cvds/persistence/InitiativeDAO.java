package edu.eci.cvds.persistence;

import java.util.List;

import edu.eci.cvds.entities.Initiative;
import edu.eci.cvds.samples.services.ServicesException;
import java.sql.Date;
import edu.eci.cvds.entities.TypeStatus;
public interface InitiativeDAO {
	
	public void addInitiative(String description, String area, int idus) throws ServicesException;
	
	public List<Initiative> loadByUser (String id) throws ServicesException;
	
	public Initiative load(int InitiativeId) throws ServicesException;
	
	public List<Initiative> load(List<String> keywords) throws ServicesException;
	
	public List<TypeStatus> listStatus() throws ServicesException;
	
	public void modifyInitiative(String newStatus, int id) throws ServicesException;
	
	public List<Initiative> loadAll() throws ServicesException;

}