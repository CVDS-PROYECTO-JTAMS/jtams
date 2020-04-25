package edu.eci.cvds.jtams.persistence;

import java.util.List;

import edu.eci.cvds.jtams.exceptions.JtamsExceptions;
import edu.eci.cvds.jtams.model.Initiative;
import edu.eci.cvds.jtams.model.InitiativeStates;

public interface InitiativeDAO {
	
	public void createInitiative(String description, String area, int idus, List<String> keywords,String name) throws JtamsExceptions;
	
	public Initiative getInitiative(String area) throws JtamsExceptions;
	
	public void updateState (int id, InitiativeStates state) throws JtamsExceptions;
	
	public void updateInitiative (Initiative initiative) throws JtamsExceptions;

	public List<Initiative> dariniciativas() throws JtamsExceptions;
	
	public List<Initiative> buscainiciativaporpalabra(List<String> keywords) throws JtamsExceptions;

	public void updateTypeUser(String initiativeToUpdate, String typeToUpdate)throws JtamsExceptions;

}
