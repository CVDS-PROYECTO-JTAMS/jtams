package edu.eci.cvds.jtams.guice;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;

import org.mybatis.guice.XMLMyBatisModule;
import org.mybatis.guice.datasource.helper.JdbcHelper;

import com.google.inject.Guice;
import com.google.inject.Injector;

import edu.eci.cvds.jtams.model.Initiative;
import edu.eci.cvds.jtams.persistence.CommentDAO;
import edu.eci.cvds.jtams.persistence.InitiativeDAO;
import edu.eci.cvds.jtams.persistence.UserDAO;
import edu.eci.cvds.jtams.persistence.mybatisimpl.MyBatisComment;
import edu.eci.cvds.jtams.persistence.mybatisimpl.MyBatisInitiative;
import edu.eci.cvds.jtams.persistence.mybatisimpl.MyBatisUser;
import edu.eci.cvds.jtams.services.InitiativeServices;
import edu.eci.cvds.jtams.services.UserServices;
import edu.eci.cvds.jtams.services.impl.InitiativeServicesImpl;
import edu.eci.cvds.jtams.services.impl.UserServicesImpl;

public class GuiceContextListener {

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

                // TODO Add service class associated to Stub implementation
                bind(UserDAO.class).to(MyBatisUser.class);
                bind(InitiativeDAO.class).to(MyBatisInitiative.class);
                bind(CommentDAO.class).to(MyBatisComment.class);
                bind(InitiativeServices.class).to(InitiativeServicesImpl.class);
                bind(UserServices.class).to(UserServicesImpl.class);
            }
        });

        servletContextEvent.getServletContext().setAttribute(Injector.class.getName(), injector);
    }

}
