package edu.eci.cvds.jtams.managedBeans;

import edu.eci.cvds.jtams.exceptions.JtamsExceptions;
import edu.eci.cvds.jtams.model.Initiative;
import edu.eci.cvds.jtams.services.InitiativeServices;
import edu.eci.cvds.jtams.services.InitiativeServicesFactory;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.util.Arrays;
import java.util.List;

@SuppressWarnings("deprecation")
@ManagedBean(name = "InitiativeBean")
@SessionScoped
public class InitiativeBean {

	
	//@Inject
	//private InitiativeServices initiativeService;
	private InitiativeServices initiativeService = InitiativeServicesFactory.getInstance().getInitiativeServices();

	public InitiativeServices getInitiativeService() {
		return initiativeService;
	}

	public void setInitiativeService(InitiativeServices initiativeService) {
		this.initiativeService = initiativeService;
	}

	public List<Initiative> buscainiciativa(String palabra) throws JtamsExceptions{
		List<String> iniciativas= Arrays.asList(palabra.split(",")); 
		System.out.println("llega a initiativebean");
		System.out.println("busqueda Fail");
		return initiativeService.buscainiciativaporpalabra(iniciativas);
		//return null;

	}
	public List<Initiative> Todasiniciativas() throws JtamsExceptions{
		return  initiativeService.dariniciativas();
	}

}
