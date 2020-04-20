package edu.eci.cvds.managedBeans;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import edu.eci.cvds.entities.User;
import edu.eci.cvds.entities.UserType;
import edu.eci.cvds.samples.services.InitiativeServices;
import edu.eci.cvds.samples.services.ServicesException;



@SuppressWarnings("deprecation")
@ManagedBean(name = "userBean")
@SessionScoped
public class UserBean extends BasePageBean {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3594009161252782831L;
	
	
	@Inject
	InitiativeServices initiativeService;
	
	public void logIn(String email, String password) throws ServicesException, IOException {
		User user = initiativeService.getUser(email, password);
		FacesContext facesContext = FacesContext.getCurrentInstance();
		if(user != null) {
			HttpSession session = (HttpSession) facesContext.getExternalContext().getSession(true);
			session.setAttribute("id", user.getId());
			session.setAttribute("name", user.getName());
			session.setAttribute("type", user.getType().ordinal());
			facesContext.getExternalContext().redirect("/faces/initiativeKeyword.xhtml");
		}
		else {
			facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Usuario o clave invalido","Error"));
		}
	}
	
	public boolean islogged() {
		return ((HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true)).getAttribute("id") != null;
	}
	
	public boolean isAdmin() {
		if(islogged())
			return ((HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true)).getAttribute("type").toString().equals("0");
		return false;
	}
	
	public String getName() {
		return ((HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true)).getAttribute("name").toString();
	}
		
	public List<User> getUsers() throws Exception{
		try {
			return initiativeService.listUsers();
		}
		catch(ServicesException ex) {
			throw ex;
		}
	}
	
	public List<UserType> getTypes (){
		return Arrays.asList(UserType.class.getEnumConstants() );
	}
	
	public void modifyUser(String email, int rol) {
		try {
			System.out.println(email+" "+rol);
			initiativeService.modifyUser(email, rol);
		} catch (ServicesException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
}