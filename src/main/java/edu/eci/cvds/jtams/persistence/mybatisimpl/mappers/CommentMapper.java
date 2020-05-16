package edu.eci.cvds.jtams.persistence.mybatisimpl.mappers;

import org.apache.ibatis.annotations.Param;

import edu.eci.cvds.jtams.model.Comment;

import java.util.Date;
import java.util.List;

public interface CommentMapper {
	/**
	  *Registra un comentario nuevo
	  * 
	  */
	public void createComment(@Param("id") int id, @Param("iniciativa") int iniciativa,
			@Param("fechaCreacion") Date fechaCreacion, @Param("fechaModificacion") Date fechaModificacion, 
			@Param("mensaje") String mensaje, @Param("usuario") int usuario);

	public List<Comment> todosComentarios();
	
//	public Comment getComment(@Param("idIniciativa") int idIniciativa);
//
//	public int getnumComentariosUsuario(@Param("id")String id);


}