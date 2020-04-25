package edu.eci.cvds.jtams.services;

import com.google.inject.Injector;
import edu.eci.cvds.jtams.persistence.InitiativeDAO;
import edu.eci.cvds.jtams.persistence.UserDAO;
import edu.eci.cvds.jtams.persistence.mybatisimpl.MyBatisInitiative;
import edu.eci.cvds.jtams.persistence.mybatisimpl.MyBatisUser;
import edu.eci.cvds.jtams.services.impl.InitiativeServicesImpl;
import edu.eci.cvds.jtams.services.impl.StatisticServicesImpl;
import edu.eci.cvds.jtams.services.impl.UserServicesImpl;
import org.mybatis.guice.XMLMyBatisModule;

import java.util.Optional;

import static com.google.inject.Guice.createInjector;

public class InitiativeServicesFactory {
	
	private static InitiativeServicesFactory instance = new InitiativeServicesFactory();

    private static Optional<Injector> optInjector;

    private Injector myBatisInjector(final String env, final String pathResource) {
        return createInjector(new XMLMyBatisModule() {
            @Override
            protected void initialize() {
                setEnvironmentId(env);
                setClassPathResource(pathResource);
                bind(UserDAO.class).to(MyBatisUser.class);
                bind(InitiativeDAO.class).to(MyBatisInitiative.class);
                //bind(CommentDAO.class).to(MyBatisComment.class);
                bind(InitiativeServices.class).to(InitiativeServicesImpl.class);
                bind(UserServices.class).to(UserServicesImpl.class);
                bind(StatisticsServices.class).to(StatisticServicesImpl.class);
            }
        });
    }

    private InitiativeServicesFactory(){
        optInjector = Optional.empty();
    }

    public InitiativeServices getInitiativeServices(){
        if (!optInjector.isPresent()) {
            optInjector = Optional.of(myBatisInjector("development","mybatis-config.xml"));
        }

        return optInjector.get().getInstance(InitiativeServices.class);
    }


    public InitiativeServices getInitiativeServicesTesting(){
        if (!optInjector.isPresent()) {
            optInjector = Optional.of(myBatisInjector("test", "mybatis-config-h2.xml"));
        }

        return optInjector.get().getInstance(InitiativeServices.class);
    }

    public UserServices getUserServices(){
        if (!optInjector.isPresent()) {
            optInjector = Optional.of(myBatisInjector("development","mybatis-config.xml"));
        }

        return optInjector.get().getInstance(UserServices.class);
    }


    public UserServices getUserServicesTesting(){
        if (!optInjector.isPresent()) {
            optInjector = Optional.of(myBatisInjector("test", "mybatis-config-h2.xml"));
        }

        return optInjector.get().getInstance(UserServices.class);
    }
    public StatisticsServices getStatisticsServices(){
        if (!optInjector.isPresent()) {
            optInjector = Optional.of(myBatisInjector("development","mybatis-config.xml"));
        }

        return optInjector.get().getInstance(StatisticsServices.class);
    }


    public static InitiativeServicesFactory getInstance(){
        return instance;
    }


}
