package edu.eci.cvds.jtams.persistence.mybatisimpl;

import com.google.inject.Inject;
import edu.eci.cvds.jtams.exceptions.JtamsExceptions;
import edu.eci.cvds.jtams.model.Comment;
import edu.eci.cvds.jtams.persistence.CommentDAO;
import edu.eci.cvds.jtams.persistence.mybatisimpl.mappers.CommentMapper;

import java.sql.Date;
import java.time.LocalDate;

public class MyBatisComment implements CommentDAO {

	@Inject
	private CommentMapper commentMapper;
	/**
	  *Registra un comentario
	  * 
	  */
	@Override
	public void createComment(int iniciativa, String mensaje, int usuario) throws JtamsExceptions {
		try {
			LocalDate fechaCreacion = LocalDate.now();
			LocalDate fechaModificacion = LocalDate.now();
			commentMapper.createComment(0, iniciativa, Date.valueOf(fechaCreacion), Date.valueOf(fechaModificacion), mensaje, usuario);
		}catch(Exception e) {
			throw new JtamsExceptions("Error trying to insert the comment", e);
		}
	}
	@Override
	public Comment getComment(int idIniciativa) {
		return null;//commentMapper.getComment(idIniciativa);
		
	}

	@Override
	public int getnumComentariosUsuario(String id) {
		return 0;
		//commentMapper.getnumComentariosUsuario(id);
	}


	public CommentMapper getCommentMapper() {
		return commentMapper;
	}

	public void setCommentMapper(CommentMapper commentMapper) {
		this.commentMapper = commentMapper;
	}
}