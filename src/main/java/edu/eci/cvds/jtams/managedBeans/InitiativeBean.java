package edu.eci.cvds.jtams.managedBeans;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ManagedBean;
import edu.eci.cvds.jtams.model.*;
import com.google.inject.Inject;
import edu.eci.cvds.jtams.exceptions.*;
import java.util.List;
import java.util.Arrays;
import edu.eci.cvds.jtams.services.*;

@SuppressWarnings("deprecation")
@ManagedBean(name = "InitiativeBean")
@SessionScoped
public class InitiativeBean {

	
	private InitiativeServices initiativeService = InitiativeServicesFactory.getInstance().getInitiativeServices();
	
	public List<Initiative> buscainiciativa(String palabra) throws JtamsExceptions{
		List<String> iniciativas= Arrays.asList(palabra.split(",")); 
		System.out.println("llega a initiativebean");
		System.out.println("busqueda Fail");
		System.out.println("busqueda Fail");
		System.out.println("busqueda Fail");
		System.out.println("busqueda Fail");
		System.out.println("busqueda Fail");
		//return initiativeService.buscainiciativaporpalabra(iniciativas);
		return null;

	}
	public List<Initiative> Todasiniciativas() throws JtamsExceptions{
		//System.out.println("llega a initiativebean");
		//System.out.println("listar Fail");
		//System.out.println("listar Fail");
		//System.out.println("listar Fail");
		//System.out.println("listar Fail");
		
		return  initiativeService.dariniciativas();
	}

}
