package edu.eci.cvds.jtams.services;

import edu.eci.cvds.jtams.exceptions.JtamsExceptions;
import edu.eci.cvds.jtams.model.Comment;

public interface CommentServices {
    public void createComment(int iniciativa, String mensaje,int usuario) throws JtamsExceptions;

    public Comment getComment(int idComment) throws JtamsExceptions;

    public int getnumComentariosUsuario(int user) throws JtamsExceptions;
}
