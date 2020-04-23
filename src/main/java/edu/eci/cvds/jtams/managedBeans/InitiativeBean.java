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
	private static final long serialVersionUID = 3594009161252782831L;
	
	private InitiativeServices initiativeService = InitiativeServicesFactory.getInstance().getInitiativeServices();
	
	private String description ;
	private  String area ;
	private  String keyword;
	private String name;
	
	public InitiativeServices getInitiativeService() {
		return initiativeService;
	}

	public void setInitiativeService(InitiativeServices initiativeService) {
		this.initiativeService = initiativeService;
	}
	public String getDescription() {
		return description;
	}

	public void setDescription( String description) {
		this.description =  description;
	}
	public String getArea() {
		return area;
	}

	public void setArea( String area) {
		this.area = area;
	}
	
	public String getKeyword() {
		return keyword;
	}

	public void setKeyword( String keyword) {
		this.keyword = keyword;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String Name) {
		this.name = name;
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
	public void createIntitiative() throws JtamsExceptions {
		
		System.out.println(area+" "+description+" "+name);
		java.sql.Date fecha = new java.sql.Date(System.currentTimeMillis());
		FacesContext facesContext = FacesContext.getCurrentInstance();
		HttpSession session = (HttpSession) facesContext.getExternalContext().getSession(true);
		List<String> keywords= Arrays.asList(keyword.split(",")); 
		try {
			initiativeService.createInitiative(description, area,2 , keywords, name);
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Los datos han sido guardados con exito"));
		}catch (JtamsExceptions ex) {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Existio un error al guardar","Error"));
			throw ex;
		}
	}

}
