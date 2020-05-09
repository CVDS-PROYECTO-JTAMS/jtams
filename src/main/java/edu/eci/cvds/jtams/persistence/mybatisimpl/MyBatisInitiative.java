package edu.eci.cvds.jtams.persistence.mybatisimpl;

import com.google.inject.Inject;
import edu.eci.cvds.jtams.exceptions.JtamsExceptions;
import edu.eci.cvds.jtams.model.Initiative;
import edu.eci.cvds.jtams.model.InitiativeStates;
import edu.eci.cvds.jtams.model.Statistic;
import edu.eci.cvds.jtams.persistence.InitiativeDAO;
import edu.eci.cvds.jtams.persistence.mybatisimpl.mappers.InitiativeMapper;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

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
				initiativeMapper.createKeyword(k);
			}
			//initiativeMapper.createVotes();
			
		}catch(Exception e) {
			e.printStackTrace();
			throw new JtamsExceptions("Error trying to insert the initiative");
		}
    }
    @Override
	public void agregarIniciativaRelacionadaAIniciativa(int initiative, int iniRelatione) throws JtamsExceptions {
    	try{
            initiativeMapper.agregarIniciativaRelacionadaAIniciativa(initiative,iniRelatione);
        } catch (javax.persistence.PersistenceException e ){
            throw new javax.persistence.PersistenceException(e.getMessage(), e);
        }
		
	}
    @Override
	public List<Initiative> busaIniciativaRelacionadas(int idIniciativa) throws JtamsExceptions {
    	try {
            return initiativeMapper.busaIniciativaRelacionadas(idIniciativa);
        } catch (Exception e) {
            throw new JtamsExceptions("no se pudo encontrar iniciativas relacionadas con este id", e);
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

	@Override
	public List<Initiative> buscaEstadoIniciativa(String Type_Status_id) throws JtamsExceptions {
		try {
            return initiativeMapper.buscaEstadoIniciativa(Type_Status_id);
        } catch (Exception e) {
            throw new JtamsExceptions("There was an exception persisting the initiative to the database", e);
        }
	}

	@Override
	public void darlike(int user_id, int ini_id) throws JtamsExceptions {
		try {
			Initiative verificar= initiativeMapper.consultarLike(user_id, ini_id);
			if(verificar==null) {
				initiativeMapper.darlike(user_id, ini_id);
				initiativeMapper.sumarLike(ini_id);
			}else {
				initiativeMapper.quitarlike(user_id, ini_id);
				initiativeMapper.restarLike(ini_id);
			}
      } catch(Exception e) {
           throw new JtamsExceptions("hay un error entre mybatis y el mapper en like de la iniciativa", e);
       }
		
	}

	@Override
	public List<Initiative> consultarIniciativaProponente(int User_id) throws JtamsExceptions {
		try {
			
			return initiativeMapper.consultarIniciativaProponente(User_id);
		} catch(Exception e) {
	           throw new JtamsExceptions("hay un error en el mappers ", e);
	       }
	}

}
