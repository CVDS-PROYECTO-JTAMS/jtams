package edu.eci.cvds.entities;

public class Comment {
	private int id;
	private User user;
	private Initiative initiative;
	private String comment;

	public Comment() {}

	public Comment(User user, Initiative initiative,String comment ) {
		this.user=user;
		this.initiative=initiative;
		this.comment=comment;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public User getIdUser() {
		return user;
	}

	public void setIdUser(User user) {
		this.user = user;
	}

	public Initiative getIdInitiative() {
		return initiative;
	}

	public void setIdInitiative(Initiative initiative) {
		this.initiative = initiative;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

}