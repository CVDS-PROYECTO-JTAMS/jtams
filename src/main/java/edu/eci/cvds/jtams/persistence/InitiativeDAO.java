package edu.eci.cvds.jtams.persistence;

import edu.eci.cvds.jtams.exceptions.JtamsExceptions;
import edu.eci.cvds.jtams.model.Initiative;
import edu.eci.cvds.jtams.model.InitiativeStates;
import edu.eci.cvds.jtams.model.Statistic;

import java.util.List;

public interface InitiativeDAO {
	
	public void createInitiative(String description, String area, int idus, List<String> keywords,String name) throws JtamsExceptions;
	
	public Initiative getInitiative(String area) throws JtamsExceptions;
	
	public void updateState (int id, InitiativeStates state) throws JtamsExceptions;
	
	public void updateInitiative (Initiative initiative) throws JtamsExceptions;

	public List<Initiative> dariniciativas() throws JtamsExceptions;
	
	public List<Initiative> buscainiciativaporpalabra(String palabra) throws JtamsExceptions;

	public List<Initiative> totalInitiatives()throws JtamsExceptions;

	public List<Statistic> getInitiativesByArea();

	public void updateTypeUser(String initiativeToUpdate, String typeToUpdate)throws JtamsExceptions;
	
	public void agregarIniciativaRelacionadaAIniciativa(int initiative, int iniRelatione) throws JtamsExceptions;

}
