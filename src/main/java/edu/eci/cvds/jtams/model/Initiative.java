package edu.eci.cvds.jtams.model;

import java.util.Date;

public class Initiative {
	private int id;
	private String description;
	private String area;
	private int numVotes;
	private Date creationDate;
	private int userId;
	private Date modifyDate;
	private String typeStatusId;
	
	public Initiative() {
		
	}
	
	public Initiative(int id, String description, String area, int numVotes, Date creationDate, int userId, Date modifyDate, String typeStatusId) {
		this.id = id;
		this.description = description;
		this.area = area;
		this.numVotes = numVotes;
		this.creationDate = creationDate;
		this.userId = userId;
		this.typeStatusId = typeStatusId;
		this.modifyDate = modifyDate;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public int getNumVotes() {
		return numVotes;
	}

	public void setNumVotes(int numVotes) {
		this.numVotes = numVotes;
	}

	public Date getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getTypeStatusId() {
		return typeStatusId;
	}

	public void setTypeStatusId(String typeStatusId) {
		this.typeStatusId = typeStatusId;
	}
	
	public Date getModifyDate() {
		return modifyDate;
	}

	public void setModifyDate(Date modifyDate) {
		this.modifyDate = modifyDate;
	}

	@Override
    public String toString() {
        return "Initiative{" + "description=" + description + ", area=" + area + ", numVotes" + numVotes + ", creationDate" + creationDate + ", userId" + userId + '}';
    }

	
	

}
