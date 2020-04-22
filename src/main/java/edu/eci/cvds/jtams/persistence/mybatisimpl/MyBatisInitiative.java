package edu.eci.cvds.jtams.persistence.mybatisimpl;

import com.google.inject.Inject;
import edu.eci.cvds.jtams.exceptions.JtamsExceptions;
import edu.eci.cvds.jtams.model.Initiative;
import edu.eci.cvds.jtams.model.InitiativeStates;
import edu.eci.cvds.jtams.persistence.InitiativeDAO;
import edu.eci.cvds.jtams.persistence.mybatisimpl.mappers.InitiativeMapper;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class MyBatisInitiative implements InitiativeDAO {
    @Inject
    private InitiativeMapper initiativeMapper;

    public InitiativeMapper getInitiativeMapper() {
        return initiativeMapper;
    }

    public void setInitiativeMapper(InitiativeMapper initiativeMapper) {
        this.initiativeMapper = initiativeMapper;
    }

    @Override
    public void createInitiative(Initiative initiative) throws JtamsExceptions {
        try {
            initiativeMapper.createInitiative(initiative.getId(), initiative.getDescription(), initiative.getArea(),
                initiative.getNumVotes(), initiative.getCreationDate(), initiative.getUserId(), initiative.getTypeStatusId(), initiative.getModifyDate());
        } catch (Exception e) {
            throw new JtamsExceptions("There was an exception persisting the new initiative to the database", e);
        }
    }

    @Override
    public Initiative getInitiative(String area) throws JtamsExceptions {
        try {
            return initiativeMapper.getInitiative(area);
        } catch (Exception e) {
            throw new JtamsExceptions("There was an exception persisting the new initiative state to the database", e);
        }
    }

    @Override
    public void updateState(int id, InitiativeStates state) throws JtamsExceptions {
        try {
            initiativeMapper.updateState(id, state);
        } catch (Exception e) {
            throw new JtamsExceptions("There was an exception persisting the new initiative state to the database", e);
        }
    }

    @Override
    public void updateInitiative(Initiative initiative) throws JtamsExceptions {
        try {
            initiativeMapper.updateInitiative(initiative.getId(), initiative.getDescription(), initiative.getArea());
        } catch (Exception e) {
            throw new JtamsExceptions("There was an exception persisting the initiative to the database", e);
        }

    }
    public List<Initiative> dariniciativas() throws JtamsExceptions {
    	System.out.println("llega a dariniciativas 0");
		return initiativeMapper.dariniciativas();
	}

	@Override
	public List<Initiative> buscainiciativaporpalabra(List<String> keywords) throws JtamsExceptions {
		try {
			List <Initiative> initiatives=new ArrayList<Initiative>();
			Set<Integer> tmp = new HashSet<Integer>(); 
			System.out.println("llega la busqueda 0");
			System.out.println(keywords.get(0));
			for(String k:keywords) {
				System.out.println("llega la busqueda 1");
				System.out.println(initiativeMapper.buscainiciativaporpalabra(k).size());
				//for(Initiative i:initiativeMapper.buscainiciativaporpalabra(k)) {
					//System.out.println("llega la busqueda 2");
					//if (!tmp.contains(i.getId())) {
					//	System.out.println("llega la busqueda 3");
					//	initiatives.add(i);
					//	tmp.add(i.getId());
					//}
				//}
			}
			return initiatives;
		
		}catch(Exception e) {
			e.printStackTrace();
			throw new JtamsExceptions("Unable to load initiatives by keywords, persistence error", e);
		}
	}

}
