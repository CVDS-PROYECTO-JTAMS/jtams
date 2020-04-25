package edu.eci.cvds.jtams.services.impl;

import com.google.inject.Inject;
import edu.eci.cvds.jtams.exceptions.JtamsExceptions;
import edu.eci.cvds.jtams.model.Initiative;
import edu.eci.cvds.jtams.model.InitiativeStates;
import edu.eci.cvds.jtams.persistence.InitiativeDAO;
import edu.eci.cvds.jtams.services.InitiativeServices;

import java.util.List;

public class InitiativeServicesImpl implements InitiativeServices {

	@Inject
	private InitiativeDAO initiativeDAO;

	public InitiativeDAO getInitiativeDAO() {
		return initiativeDAO;
	}

	public void setInitiativeDAO(InitiativeDAO initiativeDAO) {
		this.initiativeDAO = initiativeDAO;
	}

	@Override
	public void createInitiative(String description, String area, int idus, List<String> keywords, String name) throws JtamsExceptions {
		if (description == null) {
			throw new JtamsExceptions("The Initiative is null");
		}else {
			initiativeDAO.createInitiative( description, area, idus, keywords,name);
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
		System.out.println("llega a servicesimpl para listar iniciativas");
		
		return initiativeDAO.dariniciativas();
	}

	@Override
	public List<Initiative> buscainiciativaporpalabra(List<String> iniciativas) throws JtamsExceptions {
		System.out.println("llega a servicesimpl para buscar iniciativa");
		return initiativeDAO.buscainiciativaporpalabra(iniciativas);
	}

	


	

}
