package edu.eci.cvds.jtams.model;
import java.sql.Date;
public class Comment {
	private int id;
	private Initiative iniciativa;
	private Date fechaCreacion;
	private Date fechaModificacion;
	private String mensaje;
	private User usuario;

	public Comment(int id, Initiative iniciativa, Date fechaCreacion, String mensaje,
			User usuario) {
		this.id = id;
		this.iniciativa= iniciativa;
		this.fechaCreacion = fechaCreacion;
		this.fechaModificacion = null;
		this.mensaje = mensaje;
		this.usuario = usuario;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Initiative getSugerencia() {
		return iniciativa;
	}

	public void setSugerencia(Initiative Initiative) {
		this.iniciativa = Initiative;
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

	public User getUsuario() {
		return usuario;
	}

	public void setUsuario(User usuario) {
		this.usuario = usuario;
	}
}