package edu.eci.cvds.jtams.managedBeans;

import edu.eci.cvds.jtams.exceptions.JtamsExceptions;
import edu.eci.cvds.jtams.services.CommentServices;
import edu.eci.cvds.jtams.services.InitiativeServicesFactory;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.primefaces.PrimeFaces;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import java.util.Date;


@SuppressWarnings("deprecation")
@ManagedBean(name = "CommentBean")
@SessionScoped
public class CommentBean {

	//@Inject
	//CommentServices commentServices;
	CommentServices commentServices = InitiativeServicesFactory.getInstance().getCommentServices();

	private int id;
	private Date fechaCreacion;
	private Date fechaModificacion;
	private String mensaje;
	private int usuario;
	private int initiativeId;

	public CommentServices getCommentServices() {
		return commentServices;
	}

	public void setCommentServices(CommentServices commentServices) {
		this.commentServices = commentServices;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getFechaCreacion() {
		return fechaCreacion;
	}

	public void setFechaCreacion(Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	public Date getFechaModificacion() {
		return fechaModificacion;
	}

	public void setFechaModificacion(Date fechaModificacion) {
		this.fechaModificacion = fechaModificacion;
	}

	public String getMensaje() {
		return mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}

	public int getUsuario() {
		return usuario;
	}

	public void setUsuario(int usuario) {
		this.usuario = usuario;
	}
	/**
	  * Registra un comentario 
	  * 
	  */
	public void createComment () throws JtamsExceptions {
		try {
			Subject currentUser = SecurityUtils.getSubject();
			String email = currentUser.getPrincipal().toString();
			commentServices.createComment(initiativeId, mensaje, email);
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Los datos han sido guardados con exito"));
			PrimeFaces current = PrimeFaces.current();
			current.executeScript("PF('dlg2').hide();");
		}catch (JtamsExceptions ex){
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Existio un error al guardar","Error"));
			throw ex;
		}

	}
	/**
	  * selecciona una iniciativa
	  * 
	  */
	public void selectInitiative(int initiativeId) {
		this.initiativeId = initiativeId;
		PrimeFaces current = PrimeFaces.current();
		current.executeScript("PF('dlg2').show();");
	}

	public int getInitiativeId() {
		return initiativeId;
	}

	public void setInitiativeId(int initiativeId) {
		this.initiativeId = initiativeId;
	}
}
