package edu.eci.cvds.jtams.managedBeans;

import java.io.IOException;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import com.google.inject.Inject;

import edu.eci.cvds.jtams.exceptions.JtamsExceptions;
import edu.eci.cvds.jtams.model.User;
import edu.eci.cvds.jtams.services.InitiativeServicesFactory;
import edu.eci.cvds.jtams.services.UserServices;

@SuppressWarnings("deprecation")
@ManagedBean(name = "userBean")
@SessionScoped
public class UserBean extends BasePageBean{
	
	@Inject
	private UserServices userServices;
	//private UserServices userServices = InitiativeServicesFactory.getInstance().getUserServices();
	private String username;
	private String password;
	
	public void logIn() {
		
		try {
			if (userServices.validateLogin(username, password)) {
				System.out.println("Validation Okay");
				User user = userServices.getUser(username);
				switch (user.getUserType()) {
				case ADMINISTRATOR:FacesContext.getCurrentInstance().getExternalContext().redirect("admin.xhtml");
					
					break;

				default:
					break;
				}
			} else {
				System.out.println("Validation Fail");
				FacesContext.getCurrentInstance().getExternalContext().redirect("login.xhtml");
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

}
