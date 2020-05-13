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
    private PieChartModel barModelState;


    public StatisticsServices getStatisticService() {
        return statisticService;
    }

    public void setStatisticService(StatisticsServices statisticService) {
        this.statisticService = statisticService;
    }

    public PieChartModel getBarModel() {
        return barModel;
    }

    public void setBarModel(PieChartModel barModel) {
        this.barModel = barModel;
    }

    public PieChartModel getBarModelState() {
        return barModelState;
    }

    public void setBarModelState(PieChartModel barModelState) {
        this.barModelState = barModelState;
    }

    @PostConstruct
    public void createBarModels() {
        createBarModel();
    }

    private void createBarModel() {
        barModel = loadData();
        barModel.setLegendPosition("e");
        barModel.setShowDataLabels(true);
        barModel.setShadow(false);
        barModel.setDataFormat("value");
        barModel.setDataLabelFormatString("%d");
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

    @PostConstruct
    public void createBarModelsStatus() {
        createBarModelStatus();
    }

    private void createBarModelStatus() {
        barModelState = loadDataStatus();
        barModelState.setLegendPosition("e");
        barModelState.setShowDataLabels(true);
        barModelState.setShadow(false);
        barModelState.setDataFormat("value");
        barModelState.setDataLabelFormatString("%d");
    }

    private PieChartModel loadDataStatus() {
        try {
            PieChartModel modelStatus = new PieChartModel();
            List<Statistic> statisticsStatus = statisticService.getStatisticsStatus();
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
