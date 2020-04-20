package edu.eci.cvds.entities;

public class TypeStatus {
	private int id;
	private String status;

	public TypeStatus() {}

	public TypeStatus(int id, String status) {
		this.id= id;
		this.status= status;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String toString() {
		return "[Status: "+status +"]";
	}
}
