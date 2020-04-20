package edu.eci.cvds.entities;

import java.util.*;

public class Initiative {

	private int id;
	private String description;
	private List<String> keyWords;
	private TypeStatus status;
	private String area;
	private int numVotes;
	private Date startDate;
	private Date modifyDate;
	private User user;

	public Initiative() {}

	public Initiative(int id, String description, String area, int numVotes, Date startDate, Date modifyDate){
		this.description= description;
		this.area= area;
		this.id =  id;
		this.numVotes =  numVotes;
		this.startDate = startDate;
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

	public List<String> getKeyWords() {
		return keyWords;
	}

	public void setKeyWords(List<String> keyWords) {
		this.keyWords = keyWords;
	}

	public TypeStatus getStatus() {
		return status;
	}

	public void setTypeStatus(TypeStatus status) {
		this.status = status;
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

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public Date getModifyDate() {
		return modifyDate;
	}

	public void setModifyDate(Date modifyDate) {
		this.modifyDate = modifyDate;
	}
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String toString() {
		return "[Initiative: id: "+id+", description: "+description+", Area: "+area+", CreationDate: "+startDate+", ModifyDate: "+modifyDate+", user: "+user+", status: "+status+", votes: "+numVotes+"]";
	}
}