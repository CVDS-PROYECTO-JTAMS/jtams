package edu.eci.cvds.jtams.model;

import java.util.Date;

;
public class Comment {
	private int id;
	private int iniciativa;
	private Date fechaCreacion;
	private Date fechaModificacion;
	private String mensaje;
	private int usuario;
	public Comment() {
		
	}
	public Comment(int id, int iniciativa, Date fechaCreacion, String mensaje,
			int usuario) {
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

	public int getSugerencia() {
		return iniciativa;
	}

	public void setSugerencia(int Initiative) {
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

	public int getUsuario() {
		return usuario;
	}

	public void setUsuario(int usuario) {
		this.usuario = usuario;
	}
}