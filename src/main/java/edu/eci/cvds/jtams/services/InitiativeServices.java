package edu.eci.cvds.jtams.services;

import edu.eci.cvds.jtams.exceptions.JtamsExceptions;
import edu.eci.cvds.jtams.model.Initiative;
import edu.eci.cvds.jtams.model.InitiativeStates;

import java.util.List;

public interface InitiativeServices {

	void createInitiative(String description, String area, int idus, List<String> keywords, String name) throws JtamsExceptions;
	
	Initiative getInitiative(String area) throws JtamsExceptions;
	
	void updateState (int id, InitiativeStates state) throws JtamsExceptions;
	
	void updateInitiative (Initiative initiative) throws JtamsExceptions;

	List<Initiative> buscainiciativaporpalabra(List<String> iniciativas) throws JtamsExceptions;

	List<Initiative> dariniciativas() throws JtamsExceptions;
	

	void updateStatusInitiative(String initiativeToUpdate, String initiativeToUpdate2)throws JtamsExceptions;

	void addComment(String comment) throws JtamsExceptions;

	void agregarIniciativaRelacionadaAIniciativa(int initiative, int iniRelatione) throws JtamsExceptions;

	List<Initiative> busaIniciativaRelacionadas(int idIniciativa) throws JtamsExceptions;
	 
	
	
}