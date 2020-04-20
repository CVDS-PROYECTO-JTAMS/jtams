package edu.eci.cvds.jtams.persistence.mybatisimpl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import edu.eci.cvds.jtams.exceptions.JtamsExceptions;
import edu.eci.cvds.jtams.model.Initiative;
import edu.eci.cvds.jtams.model.InitiativeStates;
import edu.eci.cvds.jtams.persistence.InitiativeDAO;
import edu.eci.cvds.jtams.persistence.mybatisimpl.mappers.InitiativeMapper;

public class MyBatisInitiative implements InitiativeDAO {

    private InitiativeMapper initiativeMapper;

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
		return initiativeMapper.dariniciativas();
	}

	@Override
	public List<Initiative> buscainiciativaporpalabra(List<String> keywords) throws JtamsExceptions {
		try {
			List <Initiative> initiatives=new ArrayList<Initiative>();
			Set<Integer> tmp = new HashSet<Integer>(); 
			for(String k:keywords) {
				for(Initiative i:initiativeMapper.buscainiciativaporpalabra(k)) {
					if (!tmp.contains(i.getId())) {
						initiatives.add(i);
						tmp.add(i.getId());
					}
				}
			}
			return initiatives;
		
		}catch(Exception e) {
			e.printStackTrace();
			throw new JtamsExceptions("Unable to load initiatives by keywords, persistence error");
		}
	}

}
