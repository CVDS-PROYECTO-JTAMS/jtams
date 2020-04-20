package edu.eci.cvds.persistence;

import edu.eci.cvds.entities.Comment;
import edu.eci.cvds.samples.services.ServicesException;

public interface CommentDAO {

	public void addComment (int InitiativeId, Comment comment) throws ServicesException;

}