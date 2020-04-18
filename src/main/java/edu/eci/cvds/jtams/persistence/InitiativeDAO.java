package edu.eci.cvds.jtams.persistence;

import edu.eci.cvds.jtams.model.Initiative;
import edu.eci.cvds.jtams.model.InitiativeStates;

public interface InitiativeDAO {
	
	public void createInitiative(Initiative initiative);
	
	public Initiative getInitiative();
	
	public void updateState (String id, InitiativeStates state);
	
	public void updateInitiative (Initiative initiative);

}
