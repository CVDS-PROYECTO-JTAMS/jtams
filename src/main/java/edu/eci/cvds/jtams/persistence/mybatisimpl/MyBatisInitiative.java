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
    /**
	  *Registra una nueva Iniciativa
	  * 
	  * @param name Nombre de la iniciativa
	  * @param description Descripcion de la iniciativa
      * @param idus ID del usuario que propone la iniciativa
      * @param area Area a la que pertenece la iniciativa
      * @param keyword lista de palabras clave de la inciativa separadas por coma
      * 
	*/
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
    /**
	  *Registra una nueva Iniciativa relacionada con otra iniciativa 
	  * 
	  * @param initiative ID de la iniciatiiva
	  * @param iniRelation ID de la iniciativa a la cual se relacionara
	*/
    @Override
	public void agregarIniciativaRelacionadaAIniciativa(int initiative, int iniRelatione) throws JtamsExceptions {
    	try{
            initiativeMapper.agregarIniciativaRelacionadaAIniciativa(initiative,iniRelatione);
        } catch (javax.persistence.PersistenceException e ){
            throw new javax.persistence.PersistenceException(e.getMessage(), e);
        }
		
	}
    /**
	  *Busca las iniciativas relacionadas a una iniciativa en especifico
	  * 
	  * @param idIniniciativa ID de la iniciativa
	*/
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
    /**
	  *Actualiza el estado de la iniciativa buscandola por su ID
	  * 
	  * @param id ID de la iniciativa
	  * @param state Nuevo estado de la iniciativa
	*/
    @Override
    public void updateState(int id, InitiativeStates state) throws JtamsExceptions {
        try {
            initiativeMapper.updateState(id, state);
        } catch (Exception e) {
            throw new JtamsExceptions("There was an exception persisting the new initiative state to the database", e);
        }
    }
    /**
	  *Actualiza una iniciativa dada
	  * 
	  * @param initiative Iniciativa que se desea actualizar 
	*/
    @Override
    public void updateInitiative(Initiative initiative) throws JtamsExceptions {
        try {
            initiativeMapper.updateInitiative(initiative.getId(), initiative.getDescription(), initiative.getArea());
        } catch (Exception e) {
            throw new JtamsExceptions("There was an exception persisting the initiative to the database", e);
        }

    }
    /**
	  *Retorna todas las iniciativas
	  *
	  *@return Lista de todas las iniciativas
	*/
    public List<Initiative> dariniciativas() throws JtamsExceptions {
    	//System.out.println("llega a dariniciativas 0");
		return initiativeMapper.dariniciativas();
	}
    /**
	  *Busca todas las iniciativas que tengan una palabra clave en especifico
	  * 
	  * @param keyword Palabra Clave
	*/
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
    /**
	  *Actualiza el tipo de usuario 
	  * 
	  * @param initiativeToUpdate Id de la iniciativa que se quiere actualizar 
	  * @param typeToUpdate El nuevo tipo de usuario valido
	*/

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
    public List<Statistic> getInitiativesByStatus() {
        return initiativeMapper.getInitiativesByStatus();
    }
	/**
	  *Busca las iniciativas por un estado en especifico.
	  * 
	  * @return Lista de iniciativas
	*/

	@Override
	public List<Initiative> buscaEstadoIniciativa(String Type_Status_id) throws JtamsExceptions {
		try {
            return initiativeMapper.buscaEstadoIniciativa(Type_Status_id);
        } catch (Exception e) {
            throw new JtamsExceptions("There was an exception persisting the initiative to the database", e);
        }
	}
	/**
	 *Busca las iniciativas por un area en especifico.
	 *
	 * @return Lista de iniciativas
	 */

    @Override
    public List<Initiative> buscaAreaIniciativa(String area) throws JtamsExceptions {
        try {
            return initiativeMapper.buscaAreaIniciativa(area);
        } catch (Exception e) {
            throw new JtamsExceptions("There was an exception persisting the initiative to the database", e);
        }
    }

	/**
	  *Registra un like para una iniciativa
	  * 
	  * @param user_id Id del usuario que realizara el like
	  * @param user_id Id de la iniciativa a la cual se le asignara el like 
	*/
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
	/**
	  *Busca las iniciativas del usuario que sea de tipo proponente
	  * 
	  * @return Lista de iniciativas
	*/
	@Override
	public List<Initiative> consultarIniciativaProponente(int User_id) throws JtamsExceptions {
		try {
			
			return initiativeMapper.consultarIniciativaProponente(User_id);
		} catch(Exception e) {
	           throw new JtamsExceptions("hay un error en el mappers ", e);
	       }
	}
	/**
	  *Actualiza las iniciativas en cuanto su area y su descripcion
	  * 
	  * @param id Id de la iniciativa que se quiere actualizar 
	  * @param area Nueva area de la iniciativa
	  * @param description Nueva description de la iniciativa
	*/

	@Override
	public void editarIniciativas(int id, String area, String description) throws JtamsExceptions {
		try {
			initiativeMapper.editarIniciativas(id,description,area);
		} catch(Exception e) {
	         throw new JtamsExceptions("hay un error en el mappers ", e);
	     }
	}

}
