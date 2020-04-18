package edu.eci.cvds.jtams.persistence.mybatisimpl;

import java.util.Date;

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
                initiative.getNumVotes(), initiative.getCreationDate(), initiative.getUserId(), initiative.getTypeStatusId());
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
            initiativeMapper.updateInitiative(initiative.getId(), initiative.getDescription(), initiative.getArea(),
                    initiative.getNumVotes(), initiative.getCreationDate(), initiative.getUserId(), initiative.getTypeStatusId());
        } catch (Exception e) {
            throw new JtamsExceptions("There was an exception persisting the initiative to the database", e);
        }

    }

}
