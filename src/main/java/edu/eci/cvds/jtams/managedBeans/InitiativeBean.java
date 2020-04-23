package edu.eci.cvds.jtams.managedBeans;

import edu.eci.cvds.jtams.exceptions.JtamsExceptions;
import edu.eci.cvds.jtams.model.Initiative;
import edu.eci.cvds.jtams.services.InitiativeServices;
import edu.eci.cvds.jtams.services.InitiativeServicesFactory;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import com.google.inject.Inject;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

@SuppressWarnings("deprecation")
@ManagedBean(name = "InitiativeBean")
@SessionScoped
public class InitiativeBean {

	
	//@Inject
	//private InitiativeServices Service;
	
	
	private InitiativeServices initiativeService = InitiativeServicesFactory.getInstance().getInitiativeServices();
	
	
	
	public InitiativeServices getInitiativeService() {
		return initiativeService;
	}

	public void setInitiativeService(InitiativeServices initiativeService) {
		this.initiativeService = initiativeService;
	}


	public List<Initiative> buscainiciativa(String palabra) throws JtamsExceptions{
		System.out.println(palabra);
		System.out.println("aqui arriba deberia imprimir la puta palabra y solo imprime un espacio :C ");
		List<String> iniciativas= Arrays.asList(palabra.split(",")); 
		System.out.println("llega a initiativebean");
		
		//return initiativeService.buscainiciativaporpalabra(iniciativas);
		return null;

	}
	public List<Initiative> Todasiniciativas() throws JtamsExceptions{
		return  initiativeService.dariniciativas();
		//return null;
	}
	public void createIntitative(String description, String area, String keyword, String name) throws IOException, JtamsExceptions {
		
		System.out.println(area+" "+description+" "+name);
		java.sql.Date fecha = new java.sql.Date(System.currentTimeMillis());
		FacesContext facesContext = FacesContext.getCurrentInstance();
		HttpSession session = (HttpSession) facesContext.getExternalContext().getSession(true);
		List<String> keywords= Arrays.asList(keyword.split(",")); 
		try {
			initiativeService.createInitiative(description, area, Integer.parseInt(session.getAttribute("id").toString()), keywords, name);
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Los datos han sido guardados con exito"));
		}catch (JtamsExceptions ex) {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Existio un error al guardar","Error"));
			throw ex;
		}
	}

}
