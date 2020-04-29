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

}
