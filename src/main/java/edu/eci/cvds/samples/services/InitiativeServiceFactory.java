package edu.eci.cvds.samples.services;


import org.mybatis.guice.XMLMyBatisModule;
import org.mybatis.guice.datasource.helper.JdbcHelper;

import static com.google.inject.Guice.createInjector;
import com.google.inject.Injector;
import java.util.ArrayList;
import java.util.List;
import edu.eci.cvds.persistence.UserDAO;
import edu.eci.cvds.entities.UserType;
import edu.eci.cvds.persistence.mybatisimpl.MyBatisUserDao;
import edu.eci.cvds.samples.services.impl.InitiativeServiceImpl;
import edu.eci.cvds.samples.services.impl.InitiativeServicesStub;
import edu.eci.cvds.persistence.InitiativeDAO;
import edu.eci.cvds.persistence.mybatisimpl.MyBatisInitiativeDAO;


public class InitiativeServiceFactory {

    private static InitiativeServiceFactory instance = new InitiativeServiceFactory();
    
    private static Injector injector;
    private static Injector testingInjector;
    
    private InitiativeServiceFactory(){
        injector = createInjector(new XMLMyBatisModule() {

                    @Override
                    protected void initialize() {
                        install(JdbcHelper.PostgreSQL);                        
                        setClassPathResource("mybatis-config.xml");         
                        bind(UserDAO.class).to(MyBatisUserDao.class);
                        bind(InitiativeDAO.class).to(MyBatisInitiativeDAO.class);
                        bind(InitiativeServices.class).to(InitiativeServiceImpl.class);
                    }

                }
                
        );
        
        /*testingInjector = createInjector(new XMLMyBatisModule() {
                    @Override
                    protected void initialize() {
                        install(JdbcHelper.PostgreSQL);                        
                        setClassPathResource("mybatis-config-h2.xml");                        
                        bind(UserDAO.class).to(MyBatisUserDao.class);
                        bind(InitiativeServices.class).to(InitiativeServicesStub.class);
                    }
                }
                
        );*/
        
    }
    
    public InitiativeServices getInitiativeServices(){
        return injector.getInstance(InitiativeServices.class);   
    }

    public InitiativeServices getInitiativeServicesForTesting(){
        return testingInjector.getInstance(InitiativeServices.class);   
    }
    
    public static InitiativeServiceFactory getInstance(){
        return instance;
    }
    
    public static void main(String a[]) throws ServicesException{
    	
    	System.out.println(InitiativeServiceFactory.getInstance().getInitiativeServices().getUser("sebasvilla@gmail.com", "sebastian1213"));
    	System.out.println(InitiativeServiceFactory.getInstance().getInitiativeServices().searchInitiative(1));

    	List<String> kw= new ArrayList<String> (3);
    	kw.add("Construccion");
    	kw.add("Diversion");
    	System.out.println(InitiativeServiceFactory.getInstance().getInitiativeServices().searchInitiativeByKeywords(kw));
    	System.out.println(InitiativeServiceFactory.getInstance().getInitiativeServices().listUsers());
    	System.out.println(InitiativeServiceFactory.getInstance().getInitiativeServices().listStatus());
    }
    
}