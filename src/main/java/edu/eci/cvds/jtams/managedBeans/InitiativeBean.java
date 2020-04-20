package edu.eci.cvds.jtams.managedBeans;
import edu.eci.cvds.jtams.model.*;
import edu.eci.cvds.jtams.exceptions.*;
import java.util.List;
import java.util.Arrays;
import edu.eci.cvds.jtams.services.*;
public class InitiativeBean {


	public List<Initiative> buscainiciativa(String palabra) throws JtamsExceptions{
		List<String> iniciativas= Arrays.asList(palabra.split(","));
		return null;//InitiativeServices.buscainiciativaporpalabra(iniciativas);
	}
	public List<Initiative> Todasiniciativas() throws JtamsExceptions{
		return null;//InitiativeServices.dariniciativas();
	}

}
