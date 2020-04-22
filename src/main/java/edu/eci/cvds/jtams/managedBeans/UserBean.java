package edu.eci.cvds.jtams.managedBeans;

import edu.eci.cvds.jtams.exceptions.JtamsExceptions;
import edu.eci.cvds.jtams.model.User;
import edu.eci.cvds.jtams.model.UserType;
import edu.eci.cvds.jtams.services.InitiativeServicesFactory;
import edu.eci.cvds.jtams.services.UserServices;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import java.io.IOException;
import java.util.Collections;
import java.util.List;
import java.util.Map;

@SuppressWarnings("deprecation")
@ManagedBean(name = "userBean")
@SessionScoped
public class UserBean {

	
	//@Inject
	//private UserServices userServices;
	private UserServices userServices = InitiativeServicesFactory.getInstance().getUserServices();

	private String username;
	private String password;

	private String usernameToUpdate;
	private String typeToUpdate;

	public void logIn() {

		
		try {
			if (userServices.validateLogin(username, password)) {
				System.out.println("Validation Okay");
				User user = userServices.getUser(username);
				switch (user.getType()) {
				case ADMINISTRATOR:FacesContext.getCurrentInstance().getExternalContext().redirect("admin.xhtml");
						break;
					case PERSONAL:FacesContext.getCurrentInstance().getExternalContext().redirect("personal.xhtml");
						break;
					case PROPONENT:FacesContext.getCurrentInstance().getExternalContext().redirect("proponent.xhtml");
						break;
					case PUBLIC:FacesContext.getCurrentInstance().getExternalContext().redirect("public.xhtml");
						break;
				}
			} else {
				System.out.println("Validation Fail");
				FacesContext.getCurrentInstance().getExternalContext().redirect("index.xhtml");
			}
			
		} catch (JtamsExceptions e) {
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}
	public UserServices getUserServices() {
		return userServices;
	}
	public void setUserServices(UserServices userServices) {
		this.userServices = userServices;
	}

	public List<User> getUsers() {
		try{
			return userServices.getUsers();
		}catch (JtamsExceptions e){
			e.printStackTrace();
		}
		return Collections.emptyList();
	}

	
	public String getUsername() {
		return username;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}

	public void updateTypeUser(){
		try {
			Map<String,String> params = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
			//String username = params.get("usernameToUpdate");
			//String type = params.get("typeToUpdate");
			userServices.updateTypeUser(usernameToUpdate, UserType.valueOf(typeToUpdate));
		}catch(JtamsExceptions e){
			e.printStackTrace();
		}
	}

	public void updateTypeUser(String email, String type){
		try {
			Map<String,String> params = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
			String username = params.get("usernameToUpdate");
			//String type = params.get("typeToUpdate");
				userServices.updateTypeUser(username, UserType.valueOf(type));
		}catch(JtamsExceptions e){
			e.printStackTrace();
		}
	}

	public String getUsernameToUpdate() {
		return usernameToUpdate;
	}

	public void setUsernameToUpdate(String usernameToUpdate) {
		this.usernameToUpdate = usernameToUpdate;
	}

	public String getTypeToUpdate() {
		return typeToUpdate;
	}

	public void setTypeToUpdate(String typeToUpdate) {
		this.typeToUpdate = typeToUpdate;
	}
}
