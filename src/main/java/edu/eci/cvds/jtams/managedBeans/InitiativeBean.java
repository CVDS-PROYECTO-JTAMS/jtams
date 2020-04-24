package edu.eci.cvds.jtams.managedBeans;

import edu.eci.cvds.jtams.exceptions.JtamsExceptions;
import edu.eci.cvds.jtams.model.Initiative;
import edu.eci.cvds.jtams.model.Keyword;
import edu.eci.cvds.jtams.model.User;
import edu.eci.cvds.jtams.services.InitiativeServices;
import edu.eci.cvds.jtams.services.InitiativeServicesFactory;
import edu.eci.cvds.jtams.services.UserServices;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@SuppressWarnings("deprecation")
@ManagedBean(name = "InitiativeBean")
@SessionScoped
public class InitiativeBean {

	
	//@Inject
	//private InitiativeServices initiativeService;

	private InitiativeServices initiativeService = InitiativeServicesFactory.getInstance().getInitiativeServices();
	private Initiative initiative;
	private UserServices userServices;

	public InitiativeServices getInitiativeService() {
		return initiativeService;
	}

	public void setInitiativeService(InitiativeServices initiativeService) {
		this.initiativeService = initiativeService;
	}

	public void addInitiative(int id, String description, String area, Date creationDate,
							  Date modifyDate, String words, String email){
		try {
			List<String> keywordsList = Arrays.asList(words.split(","));
			List<Keyword> keywords = new ArrayList<>();
			keywordsList.forEach(word -> keywords.add(new Keyword()));
			int userId  = userServices.getUser(email).getId();
			this.initiative = new Initiative(id,description,area,creationDate,userId,modifyDate,keywordsList);
			initiativeService.createInitiative(initiative);
		}catch(JtamsExceptions e){
			e.printStackTrace();
		}

	}
	public List<Initiative> buscainiciativa(String palabra) throws JtamsExceptions{
		//System.out.println(palabra);
		//System.out.println("aqui arriba deberia imprimir la puta palabra y solo imprime un espacio :C ");
		//List<String> iniciativas= Arrays.asList(palabra.split(","));
		//System.out.println("llega a initiativebean");
		
		//return initiativeService.buscainiciativaporpalabra(iniciativas);
		return null;

	}
	public List<Initiative> Todasiniciativas() throws JtamsExceptions{
		return  initiativeService.dariniciativas();
		//return null;
	}

}
