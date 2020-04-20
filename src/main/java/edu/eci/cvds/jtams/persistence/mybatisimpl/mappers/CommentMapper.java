package edu.eci.cvds.jtams.persistence.mybatisimpl.mappers;

import java.util.Date;

import org.apache.ibatis.annotations.Param;

import edu.eci.cvds.jtams.model.*;

public interface CommentMapper {
	
	public void createComment(@Param("id") int id, @Param("iniciativa") Initiative iniciativa, 
			@Param("fechaCreacion") Date fechaCreacion, @Param("fechaModificacion") Date fechaModificacion, 
			@Param("mensaje") String mensaje, @Param("usuario") User usuario);
	
	public Comment getComment(@Param("idIniciativa") int idIniciativa);

	public int getnumComentariosUsuario(@Param("id")String id);
}