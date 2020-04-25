package edu.eci.cvds.jtams.services;

import edu.eci.cvds.jtams.exceptions.JtamsExceptions;
import edu.eci.cvds.jtams.model.Statistic;

import java.util.List;

public interface StatisticsServices {

    List<Statistic> getStatistics() throws JtamsExceptions;


}
