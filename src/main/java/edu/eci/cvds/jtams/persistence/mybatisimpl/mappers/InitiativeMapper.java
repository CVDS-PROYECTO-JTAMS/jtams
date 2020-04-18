package edu.eci.cvds.jtams.persistence.mybatisimpl.mappers;

import edu.eci.cvds.jtams.model.Initiative;
import edu.eci.cvds.jtams.model.InitiativeStates;
import org.apache.ibatis.annotations.Param;

import java.util.Date;

public interface InitiativeMapper {


    public void createInitiative(@Param("id") int id, @Param("description") String description, @Param("area") String area,
                                 @Param("numVotes") int numVotes, @Param("creationDate") Date creationDate, @Param("userId") int userId,
                                 @Param("typeStatusId") String typeStatusId);
    public void updateInitiative (@Param("id") int id, @Param("description") String description, @Param("area") String area,
                                  @Param("numVotes") int numVotes, @Param("creationDate") Date creationDate, @Param("userId") int userId,
                                  @Param("typeStatusId") String typeStatusId);
    public Initiative getInitiative(@Param("area") String area);
    public void updateState (@Param("id") int id, @Param("state") InitiativeStates state);

}
