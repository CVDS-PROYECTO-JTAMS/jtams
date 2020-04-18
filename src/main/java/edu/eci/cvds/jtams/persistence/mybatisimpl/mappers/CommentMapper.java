package edu.eci.cvds.jtams.persistence.mybatisimpl.mappers;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Param;

import edu.eci.cvds.jtams.model.*;

public interface CommentMapper {
	public ArrayList<Comment> verComentarios(@Param("idIniciativa") int idIniciativa);

	public void agregarComentario(@Param("comentario") Comment comentario);

	public int getnumComentariosUsuario(@Param("id")String id);
}