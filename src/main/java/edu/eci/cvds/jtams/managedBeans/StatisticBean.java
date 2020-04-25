package edu.eci.cvds.jtams.managedBeans;

import edu.eci.cvds.jtams.exceptions.JtamsExceptions;
import edu.eci.cvds.jtams.model.Statistic;
import edu.eci.cvds.jtams.services.InitiativeServicesFactory;
import edu.eci.cvds.jtams.services.StatisticsServices;
import org.primefaces.model.chart.PieChartModel;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.faces.bean.ManagedBean;
import java.util.List;

@SuppressWarnings("deprecation")
@ManagedBean(name = "StatisticBean")
@RequestScoped
public class StatisticBean {

    private StatisticsServices statisticService = InitiativeServicesFactory.getInstance().getStatisticsServices();;
    private PieChartModel barModel;


    public StatisticsServices getStatisticService() {
        return statisticService;
    }

    public void setStatisticService(StatisticsServices statisticService) {
        this.statisticService = statisticService;
    }

    public PieChartModel getBarModel() {
        return barModel;
    }

    @PostConstruct
    public void createBarModels() {
        createBarModel();
    }

    private void createBarModel() {
        barModel = loadData();
        barModel.setTitle("Cantidad de Iniciativas");
        barModel.setLegendPosition("e");
        barModel.setShowDataLabels(true);
        barModel.setShadow(false);
        barModel.setDataFormat("value");
        barModel.setDataLabelFormatString("%dI");
    }

    private PieChartModel loadData() {
        try {
            PieChartModel model = new PieChartModel();
            List<Statistic> statistics = statisticService.getStatistics();
            for (Statistic s: statistics ){
                model.set(s.getTittle(),s.getCount());
            }
            return model;
        }catch( JtamsExceptions e){
            e.printStackTrace();
        }
        return null;

    }



}
