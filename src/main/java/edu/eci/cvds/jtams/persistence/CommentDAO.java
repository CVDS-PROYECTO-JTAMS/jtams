package edu.eci.cvds.jtams.persistence;
import java.util.ArrayList;

import edu.eci.cvds.jtams.model.*;

public interface CommentDAO {

	public ArrayList<Comment> verComentarios(int idInciativa);
	
	public void agregarComentario(Comment comentario);

	public int getnumComentariosUsuario(String nombre);
}
