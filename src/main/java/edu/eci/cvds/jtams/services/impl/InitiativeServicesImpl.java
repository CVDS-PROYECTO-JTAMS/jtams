package edu.eci.cvds.jtams.services.impl;

import java.util.Date;
import java.util.List;
import edu.eci.cvds.jtams.exceptions.JtamsExceptions;
import edu.eci.cvds.jtams.model.Initiative;
import edu.eci.cvds.jtams.model.InitiativeStates;
import edu.eci.cvds.jtams.persistence.InitiativeDAO;
import edu.eci.cvds.jtams.services.InitiativeServices;

public class InitiativeServicesImpl implements InitiativeServices {
	
	private InitiativeDAO initiativeDAO;

	@Override
	public void createInitiative(Initiative initiative) throws JtamsExceptions {
		if (initiative == null) {
			throw new JtamsExceptions("The Initiative is null");
		}else {
			initiativeDAO.createInitiative(initiative);
		}
	}

	@Override
	public Initiative getInitiative(String area) throws JtamsExceptions {
		return initiativeDAO.getInitiative(area);
	}

	@Override
	public void updateState(int id, InitiativeStates state) throws JtamsExceptions {
		initiativeDAO.updateState(id, state);
		
	}

	@Override
	public void updateInitiative(Initiative initiative) throws JtamsExceptions {
		initiativeDAO.updateInitiative(initiative);
		
	}
	@Override
	public List<Initiative> dariniciativas() throws JtamsExceptions {
		return initiativeDAO.dariniciativas();
	}

	@Override
	public List<Initiative> buscainiciativaporpalabra(List<String> iniciativas) throws JtamsExceptions {
		return initiativeDAO.buscainiciativaporpalabra(iniciativas);
	}

	

}
