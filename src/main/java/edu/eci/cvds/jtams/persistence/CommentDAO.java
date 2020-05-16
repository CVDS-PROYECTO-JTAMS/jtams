package edu.eci.cvds.jtams.persistence;
import java.util.List;

import edu.eci.cvds.jtams.exceptions.JtamsExceptions;
import edu.eci.cvds.jtams.model.Comment;

public interface CommentDAO {

	public void createComment(int iniciativa, String mensaje, int usuario) throws JtamsExceptions;


	public Comment getComment(int idIniciativa);

	public int getnumComentariosUsuario(String id);


	public List<Comment> todosComentarios()throws JtamsExceptions;
}
