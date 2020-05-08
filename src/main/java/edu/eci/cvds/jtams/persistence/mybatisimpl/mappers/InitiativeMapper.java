package edu.eci.cvds.jtams.persistence.mybatisimpl.mappers;

import edu.eci.cvds.jtams.model.Initiative;
import edu.eci.cvds.jtams.model.InitiativeStates;
import edu.eci.cvds.jtams.model.Keyword;
import edu.eci.cvds.jtams.model.Statistic;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

public interface InitiativeMapper {


    public void createInitiative(@Param("id") int id, @Param("description") String description, @Param("area") String area,
                                 @Param("numVotes") int numVotes, @Param("creationDate") Date creationDate, @Param("userId") int userId,
                                 @Param("modifyDate") Date modifyDate,@Param("typeStatusId") String typeStatusId);
    
    public void updateInitiative (@Param("id") int id, @Param("description") String description, @Param("area") String area);
    
    public void updateState (@Param("id") int id, @Param("state") InitiativeStates state);
    
   
    
    public Initiative getInitiative(@Param("area") String area);
    public List<Keyword> listKeywords();
    public List<Initiative> dariniciativas();
    public List<Initiative> buscainiciativaporpalabra(@Param("keyword") String keyword);
    
    public void createKeyword(@Param("keyword") String keyword);

    public List<Initiative> totalInitiatives();

    List<Statistic> getInitiativesByArea();

	public void updateTypeUser(@Param("id") int id,@Param("typeStatusId") String typeToUpdate);

	public void agregarIniciativaRelacionadaAIniciativa(@Param("initiative")int initiative,@Param("iniRelatione") int iniRelatione);
	
	public List<Initiative> busaIniciativaRelacionadas(@Param("initiative") int initiative);

	public List<Initiative> buscaEstadoIniciativa(@Param("Type_Status_id") String Type_Status_id);

	public void darlike(@Param("user_id")int user_id,@Param("ini_id")int ini_id);

	public Initiative consultarLike(@Param("user_id")int user_id,@Param("ini_id")int ini_id);

	public void quitarlike(@Param("user_id")int user_id,@Param("ini_id")int ini_id);

	public void sumarLike(@Param("id") int id);

	public void restarLike(@Param("id") int id);

	

	
}
