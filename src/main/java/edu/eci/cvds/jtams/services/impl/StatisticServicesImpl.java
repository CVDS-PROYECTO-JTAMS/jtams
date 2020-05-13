package edu.eci.cvds.jtams.services.impl;

import com.google.inject.Inject;
import edu.eci.cvds.jtams.exceptions.JtamsExceptions;
import edu.eci.cvds.jtams.model.Statistic;
import edu.eci.cvds.jtams.persistence.InitiativeDAO;
import edu.eci.cvds.jtams.services.StatisticsServices;

import java.util.List;

public class StatisticServicesImpl implements StatisticsServices {

    @Inject
    private InitiativeDAO initiativeDAO;

    public List<Statistic> getInitiativesByArea() {
        return initiativeDAO.getInitiativesByArea();
    }

    public InitiativeDAO getInitiativeDAO() {
        return initiativeDAO;
    }

    public void setInitiativeDAO(InitiativeDAO initiativeDAO) {
        this.initiativeDAO = initiativeDAO;
    }

    @Override
    public List<Statistic> getStatistics() throws JtamsExceptions {
        return initiativeDAO.getInitiativesByArea();
    }

    @Override
    public List<Statistic> getStatisticsStatus() throws JtamsExceptions {
        return initiativeDAO.getInitiativesByStatus();
    }


}
