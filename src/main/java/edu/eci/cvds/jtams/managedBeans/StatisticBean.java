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

    private StatisticsServices statisticService = InitiativeServicesFactory.getInstance().getStatisticsServices();
    private StatisticsServices statisticServiceStatus = InitiativeServicesFactory.getInstance().getStatisticsServices();

    private PieChartModel pieModel;
    private PieChartModel pieModelStatus;


    public StatisticsServices getStatisticService() {
        return statisticService;
    }

    public void setStatisticService(StatisticsServices statisticService) {
        this.statisticService = statisticService;
    }

    public StatisticsServices getStatisticServiceStatus() {
        return statisticServiceStatus;
    }

    public void setStatisticServiceStatus(StatisticsServices statisticServiceStatus) {
        this.statisticServiceStatus = statisticServiceStatus;
    }

    public PieChartModel getPieModel() {
        return pieModel;
    }

    public void setPieModel(PieChartModel pieModel) {
        this.pieModel = pieModel;
    }

    public PieChartModel getPieModelStatus() {
        return pieModelStatus;
    }

    public void setPieModelStatus(PieChartModel pieModelStatus) {
        this.pieModelStatus = pieModelStatus;
    }

    @PostConstruct
    public void createBarModels() {
        createBarModel();
        createBarModelStatus();
    }

    private void createBarModel() {
        pieModel = loadData();
        pieModel.setLegendPosition("e");
        pieModel.setShowDataLabels(true);
        pieModel.setShadow(false);
        pieModel.setDataFormat("value");
        pieModel.setDataLabelFormatString("%d");
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

    private void createBarModelStatus() {
        pieModelStatus = loadDataStatus();
        pieModelStatus.setLegendPosition("e");
        pieModelStatus.setShowDataLabels(true);
        pieModelStatus.setShadow(false);
        pieModelStatus.setDataFormat("value");
        pieModelStatus.setDataLabelFormatString("%d");
    }

    private PieChartModel loadDataStatus() {
        try {
            PieChartModel modelStatus = new PieChartModel();
            List<Statistic> statisticsStatus = statisticServiceStatus.getStatisticsStatus();
            for (Statistic s: statisticsStatus ){
                modelStatus.set(s.getTypeStatusId(),s.getScount());
            }
            return modelStatus;
        }catch( JtamsExceptions e){
            e.printStackTrace();
        }
        return null;

    }



}
