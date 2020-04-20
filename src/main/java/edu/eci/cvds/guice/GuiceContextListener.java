package edu.eci.cvds.guice;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.mybatis.guice.XMLMyBatisModule;
import org.mybatis.guice.datasource.helper.JdbcHelper;

import com.google.inject.Guice;
import com.google.inject.Injector;

import edu.eci.cvds.persistence.InitiativeDAO;
import edu.eci.cvds.persistence.mybatisimpl.MyBatisInitiativeDAO;
import edu.eci.cvds.persistence.UserDAO;
import edu.eci.cvds.samples.services.InitiativeServices;
import edu.eci.cvds.samples.services.impl.InitiativeServiceImpl;
import edu.eci.cvds.persistence.mybatisimpl.MyBatisUserDao;

public class GuiceContextListener implements ServletContextListener {

    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        ServletContext servletContext = servletContextEvent.getServletContext();
        servletContext.removeAttribute(Injector.class.getName());
    }

    public void contextInitialized(ServletContextEvent servletContextEvent) {
        Injector injector = Guice.createInjector(new XMLMyBatisModule() {
            @Override
            protected void initialize() {
                install(JdbcHelper.PostgreSQL);
                setEnvironmentId("development");
                setClassPathResource("mybatis-config.xml");
                bind(InitiativeServices.class).to(InitiativeServiceImpl.class);
                bind(UserDAO.class).to(MyBatisUserDao.class);
                bind(InitiativeDAO.class).to(MyBatisInitiativeDAO.class);

                
                
            }
        });

        servletContextEvent.getServletContext().setAttribute(Injector.class.getName(), injector);
    }
}