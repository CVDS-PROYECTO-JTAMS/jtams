package edu.eci.cvds.jtams.persistence;
import java.util.ArrayList;

import edu.eci.cvds.jtams.model.*;

public interface CommentDAO {

	public void createComment(Comment comment);
	
	public Comment getComment(int idIniciativa);

	public int getnumComentariosUsuario(String id);
}
