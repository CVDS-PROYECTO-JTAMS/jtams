package edu.eci.cvds.jtams.persistence.mybatisimpl;

import com.google.inject.Inject;

import edu.eci.cvds.jtams.model.Comment;
import edu.eci.cvds.jtams.persistence.CommentDAO;
import edu.eci.cvds.jtams.persistence.mybatisimpl.mappers.CommentMapper;

public class MyBatisComment implements CommentDAO {

	@Inject
	private CommentMapper commentMapper;

	@Override
	public void createComment(Comment comment) {
		commentMapper.createComment(comment.getId(),comment.getSugerencia(),comment.getFechaCreacion(),comment.getFechaModificacion(),comment.getMensaje(),comment.getUsuario());
	}

	@Override
	public Comment getComment(int idIniciativa) {
		return commentMapper.getComment(idIniciativa);
		
	}

	@Override
	public int getnumComentariosUsuario(String id) {
		return commentMapper.getnumComentariosUsuario(id);
	}




	
	

}