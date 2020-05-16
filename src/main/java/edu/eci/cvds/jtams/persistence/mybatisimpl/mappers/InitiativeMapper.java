package edu.eci.cvds.jtams.persistence.mybatisimpl.mappers;

import edu.eci.cvds.jtams.model.Initiative;
import edu.eci.cvds.jtams.model.InitiativeStates;
import edu.eci.cvds.jtams.model.Keyword;
import edu.eci.cvds.jtams.model.Statistic;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

public interface InitiativeMapper {

	/**
	  *Registra una nueva Iniciativa
	  * 
	  * @param description Descripcion de la iniciativa
     * @param idus ID del usuario que propone la iniciativa
     * @param area Area a la que pertenece la iniciativa
     * @param keyword lista de palabras clave de la inciativa separadas por coma
     * @param numVotes numero de votos que tiene la iniciativa 
     * @param creationDate la fecha de creacion
     * @param modifyDate la fecha de modificacion
     * @param typeStatusId estado en el que se encuentra la iniciativa
	*/
    public void createInitiative(@Param("id") int id, @Param("description") String description, @Param("area") String area,
                                 @Param("numVotes") int numVotes, @Param("creationDate") Date creationDate, @Param("userId") int userId,
                                 @Param("modifyDate") Date modifyDate,@Param("typeStatusId") String typeStatusId);
    /**
	  *Actualiza una iniciativa 
	  * 
	  * @Param id ID de la Iniciativa que se desea actualizar 
	  * @param description Nueva descripcion de la iniciativa 
	  * @param area Nueva area de la iniciativa 
	  * 
	*/
    public void updateInitiative (@Param("id") int id, @Param("description") String description, @Param("area") String area);
    /**
	  *Actualiza una iniciativa por su estado
	  * 
	  * @Param id ID de la Iniciativa que se desea actualizar 
	  * @param state Nueva estado de la iniciativa 
	  * 
	*/
    public void updateState (@Param("id") int id, @Param("state") InitiativeStates state);
    
    /**
	  *Busca una iniciativa por su area
	  * 
	  * @Param area Area de la Iniciativa 
	*/
    
    public Initiative getInitiative(@Param("area") String area);
    /**
	  *Busca todas las palabras claves
	*/
    public List<Keyword> listKeywords();
    /**
	  *Busca todas las Iniciativas
	*/
    public List<Initiative> dariniciativas();
    /**
	  *Busca todas las Iniciativas por una palabra clave dada
	  *
	  *@Param keyword Palabra clave dada
	  *
	*/
    public List<Initiative> buscainiciativaporpalabra(@Param("keyword") String keyword);
    /*
	  *Registra una palabra clave 
	  *
	  *@Param keyword Palabra clave 
	  *
	*/
    public void createKeyword(@Param("keyword") String keyword);
    /*

     */
    public List<Initiative> totalInitiatives();

    
    List<Statistic> getInitiativesByArea();

	List<Statistic> getInitiativesByStatus();
	 /**
	  *Actualiza el tipo de usuario de un usuario en especifico
	  * 
	  * @Param id ID del usuario que se desea actualizar 
	  * @param tipeStatusId El nuevo tipo de usuario
	  * 
	*/
	public void updateTypeUser(@Param("id") int id,@Param("typeStatusId") String typeToUpdate);
	 /**
	  *Registra una iniciativa relacionada a otra
	  * 
	  * @Param initiative ID de la Iniciativa
	  * @param iniRelation ID de la iniciativa que se relacionara con la iniciativa de id intiative
	  * 
	*/
	public void agregarIniciativaRelacionadaAIniciativa(@Param("initiative")int initiative,@Param("iniRelatione") int iniRelatione);
	/**
	  *Busca todas las iniciativas relacionadas a una iniciativa en especifico
	  * 
	  * @Param initiative ID de la Iniciativa
	*/
	public List<Initiative> busaIniciativaRelacionadas(@Param("initiative") int initiative);
	/**
	  *Busca todas las iniciativas por un estado en especifico
	  * 
	  * @Param Type_Status_id  estado de las iniciativas
	*/
	public List<Initiative> buscaEstadoIniciativa(@Param("Type_Status_id") String Type_Status_id);

	/**
	 *Busca todas las iniciativas por un area en especifico
	 *
	 * @Param area  area de las iniciativas
	 */
	public List<Initiative> buscaAreaIniciativa(@Param("area") String area);


	/**
	  *Registra un like de una iniciativa
	  * 
	  * @Param user_id ID del usuario que quiere registrar el like 
	  * @param ini_idi ID de la iniciativa que se le quiere registrar el like
	  * 
	*/

	public void darlike(@Param("user_id")int user_id,@Param("ini_id")int ini_id);
	/**
	  *Buscar un like de una iniciativa
	  * 
	  * @Param user_id ID del usuario 
	  * @param ini_idi ID de la iniciativa que se quiere buscar
	  * 
	*/
	public Initiative consultarLike(@Param("user_id")int user_id,@Param("ini_id")int ini_id);
	/**
	  *Elimina un like de una iniciativa
	  * 
	  * @Param user_id ID del usuario 
	  * @param ini_idi ID de la iniciativa en la que se desea eliminar el like
	  * 
	*/
	public void quitarlike(@Param("user_id")int user_id,@Param("ini_id")int ini_id);
	/**
	  *Registra un like EN una iniciativa
	  * 
	  * @Param id ID de la iniciativa a la que se le quiere sumar un like
	*/
	public void sumarLike(@Param("id") int id);

	public void restarLike(@Param("id") int id);
	/**
	  *Busca una iniciativa del proponente
	  * 
	  * @Param User_id ID del usuario del que se deseea conocer todas las iniciativas
	*/
	public List<Initiative> consultarIniciativaProponente(@Param("User_id")int User_id);
	/**
	  *Actualiza una iniciativa 
	  * 
	  * @Param id ID de la Iniciativa que se desea actualizar 
	  * @param description Nueva descripcion de la iniciativa 
	  * @param area Nueva area de la iniciativa 
	  * 
	*/
	public void editarIniciativas(@Param("id") int id, @Param("description") String description, @Param("area") String area);


	

	
}
