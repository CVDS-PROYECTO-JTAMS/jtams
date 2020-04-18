package edu.eci.cvds.jtams.services;

import edu.eci.cvds.jtams.model.Initiative;
import edu.eci.cvds.jtams.model.InitiativeStates;

public interface InitiativeServices {

	public void createInitiative(Initiative initiative);
	
	public Initiative getInitiative();
	
	public void updateState (String id, InitiativeStates state);
	
	public void updateInitiative (Initiative initiative);
	
	
}
