package edu.eci.cvds.jtams.persistence.mybatisimpl;

import java.util.ArrayList;

import com.google.inject.Inject;

import edu.eci.cvds.jtams.model.Comment;
import edu.eci.cvds.jtams.persistence.CommentDAO;
import edu.eci.cvds.jtams.persistence.mybatisimpl.mappers.CommentMapper;

public class MyBatisComment implements CommentDAO {
	@Inject
	CommentMapper comentarioMapper;
	
	@Override
	public ArrayList<Comment> verComentarios(int idIniciativa) {
		return comentarioMapper.verComentarios(idIniciativa);
	}


	@Override
	public int getnumComentariosUsuario(String id) {
		return comentarioMapper.getnumComentariosUsuario(id);
	}

	@Override
	public void agregarComentario(Comment comentario) {
		comentarioMapper.agregarComentario(comentario);
		
	}
}