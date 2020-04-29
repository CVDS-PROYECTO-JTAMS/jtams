package edu.eci.cvds.jtams.persistence.mybatisimpl;

import com.google.inject.Inject;
import edu.eci.cvds.jtams.exceptions.JtamsExceptions;
import edu.eci.cvds.jtams.model.Initiative;
import edu.eci.cvds.jtams.model.InitiativeStates;
import edu.eci.cvds.jtams.model.Keyword;
import edu.eci.cvds.jtams.model.Statistic;
import edu.eci.cvds.jtams.persistence.InitiativeDAO;
import edu.eci.cvds.jtams.persistence.mybatisimpl.mappers.InitiativeMapper;
import edu.eci.cvds.jtams.persistence.mybatisimpl.mappers.KeywordMapper;

import java.sql.Date;
import java.time.LocalDate;
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
    public void createInitiative(String description, String area, int idus, List<String> keywords, String name) throws JtamsExceptions {
    	try {
			LocalDate creationDate = LocalDate.now();
			LocalDate modificationDate = LocalDate.now();
			initiativeMapper.createInitiative(0, description,area,0, Date.valueOf(creationDate),idus,Date.valueOf(modificationDate),"En espera revision");
			for(String k: keywords) {
				initiativeMapper.createKeyword(3, k,0);
			}
			
		}catch(Exception e) {
			e.printStackTrace();
			throw new JtamsExceptions("Error trying to insert the initiative");
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
    	//System.out.println("llega a dariniciativas 0");
		return initiativeMapper.dariniciativas();
	}

	@Override
	public List<Initiative> buscainiciativaporpalabra(String keyword) throws JtamsExceptions {
		try{
            List<Initiative> iniciativas= initiativeMapper.buscainiciativaporpalabra(keyword);
            return iniciativas;
        } catch (javax.persistence.PersistenceException e){
            throw new javax.persistence.PersistenceException(e.getMessage(),e);
        }
	}

    @Override
    public List<Initiative> totalInitiatives() throws JtamsExceptions {
        return null;
    }

    @Override
    public List<Statistic> getInitiativesByArea() {
        return initiativeMapper.getInitiativesByArea();
    }

	@Override
	public void updateTypeUser(String initiativeToUpdate, String typeToUpdate) throws JtamsExceptions {
		try {
			int id=Integer.parseInt(initiativeToUpdate);
			//System.out.println("llega y hace la conversion del string a..."+id);
			initiativeMapper.updateTypeUser(id, typeToUpdate);
        } catch(Exception e) {
            throw new JtamsExceptions("hay un error entre mybatis y el mapper", e);
        }
		 
		        
		    
		
	}

}
