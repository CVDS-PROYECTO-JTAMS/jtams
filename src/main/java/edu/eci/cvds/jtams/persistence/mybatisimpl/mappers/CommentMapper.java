package edu.eci.cvds.jtams.persistence.mybatisimpl.mappers;

import org.apache.ibatis.annotations.Param;

import java.util.Date;

public interface CommentMapper {
	
	public void createComment(@Param("id") int id, @Param("iniciativa") int iniciativa,
			@Param("fechaCreacion") Date fechaCreacion, @Param("fechaModificacion") Date fechaModificacion, 
			@Param("mensaje") String mensaje, @Param("usuario") int usuario);
	
//	public Comment getComment(@Param("idIniciativa") int idIniciativa);
//
//	public int getnumComentariosUsuario(@Param("id")String id);


}