package edu.eci.cvds.jtams.managedBeans;

import edu.eci.cvds.jtams.authenticator.SessionLogger;
import edu.eci.cvds.jtams.exceptions.JtamsExceptions;
import edu.eci.cvds.jtams.services.InitiativeServicesFactory;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresGuest;
import org.apache.shiro.subject.Subject;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import java.io.IOException;


@SuppressWarnings("deprecation")
@ManagedBean(name="LoginBean")
@SessionScoped
public class LoginBean {


    private static final long serialVersionUID = -2084921068710522276L;

    private String username;
    private String password;
    private boolean rememberMe;

    //@Inject
    //private SessionLogger logger;
    private SessionLogger logger = InitiativeServicesFactory.getInstance().getLoginServices();
    
    public Subject getCurrentUser(){
        Subject currentUser = SecurityUtils.getSubject();
        return currentUser;
    }

    public SessionLogger getLogger() {
        return logger;
    }

    public void setLogger(SessionLogger logger) {
        this.logger = logger;
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

    public boolean isRememberMe() {
        return rememberMe;
    }

    public void setRememberMe(boolean rememberMe) {
        this.rememberMe = rememberMe;
    }

    @RequiresGuest
    public void login() throws JtamsExceptions {
        try {
            switch (logger.login(username,password,rememberMe)){
                case ADMINISTRATOR:FacesContext.getCurrentInstance().getExternalContext().redirect("/admin/admin.xhtml");
                break;
                case PERSONAL:FacesContext.getCurrentInstance().getExternalContext().redirect("/personal/personal.xhtml");
                    break;
                case PROPONENT:FacesContext.getCurrentInstance().getExternalContext().redirect("/proponent/proponent.xhtml");
                    break;
                case PUBLIC:FacesContext.getCurrentInstance().getExternalContext().redirect("/public/public.xhtml");
                    break;
            }
        } catch (JtamsExceptions e) {
            LoginBean.setErrorMessage(e);
            System.out.println("Clave 1");
            e.printStackTrace();
        }catch (IOException e) {
            LoginBean.setErrorMessage(e);
            e.printStackTrace();

        }catch(Exception e) {
            LoginBean.setErrorMessage(e);
            e.printStackTrace();
        }

    }
    public void initiative() throws JtamsExceptions {
        try {
            FacesContext.getCurrentInstance().getExternalContext().redirect("/index2.xhtml");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


    public void activeSession () throws IOException {
        FacesContext facesContext = FacesContext.getCurrentInstance();
        facesContext.getExternalContext().redirect("");
    }

    public void goToMenu(){
            try{
                FacesContext.getCurrentInstance().getExternalContext().redirect("/index.xhtml");
            }catch(IOException e){
                setErrorMessage(e);
            }
        }

    public void devolver(){
        if (isLogged()){
            try{
                FacesContext.getCurrentInstance().getExternalContext().redirect("/index.xhtml");
            }catch(IOException e){
                setErrorMessage(e);
            }
        }
    }
    public boolean isLogged(){
        return logger.isLogged();
    }

    public void logout() throws IOException {
        if (isLogged()) {
            FacesContext.getCurrentInstance().getExternalContext().redirect("/index.xhtml");
            SecurityUtils.getSubject().logout();
        }
    }

    protected static void setErrorMessage(Exception e) {
        String message = e.getMessage();
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, message, null));
    }
}
