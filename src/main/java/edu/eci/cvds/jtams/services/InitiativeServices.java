package edu.eci.cvds.jtams.services;

import java.util.List;

import edu.eci.cvds.jtams.exceptions.JtamsExceptions;
import edu.eci.cvds.jtams.model.Initiative;
import edu.eci.cvds.jtams.model.InitiativeStates;

public interface InitiativeServices {

	public void createInitiative(Initiative initiative) throws JtamsExceptions;
	
	public Initiative getInitiative(String area) throws JtamsExceptions;
	
	public void updateState (int id, InitiativeStates state) throws JtamsExceptions;
	
	public void updateInitiative (Initiative initiative) throws JtamsExceptions;

	public List<Initiative> buscainiciativaporpalabra(List<String> iniciativas) throws JtamsExceptions;
	public List<Initiative> dariniciativas() throws JtamsExceptions;
	
	
}