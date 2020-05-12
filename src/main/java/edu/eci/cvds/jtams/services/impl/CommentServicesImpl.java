package edu.eci.cvds.jtams.services.impl;

import com.google.inject.Inject;
import edu.eci.cvds.jtams.exceptions.JtamsExceptions;
import edu.eci.cvds.jtams.model.Comment;
import edu.eci.cvds.jtams.persistence.CommentDAO;
import edu.eci.cvds.jtams.persistence.InitiativeDAO;
import edu.eci.cvds.jtams.persistence.UserDAO;
import edu.eci.cvds.jtams.services.CommentServices;

public class CommentServicesImpl implements CommentServices {

    @Inject
    private CommentDAO commentDAO;
    @Inject
    private InitiativeDAO initiativeDAO;
    @Inject
    private UserDAO userDao;

    public UserDAO getUserDao() {
        return userDao;
    }

    public void setUserDao(UserDAO userDao) {
        this.userDao = userDao;
    }

    @Override
    public void createComment(int iniciativa, String mensaje, String usuario) throws JtamsExceptions {
        if(mensaje == null){
            throw new JtamsExceptions("El mensaje es nulo");
        }else{
            int id = userDao.getUser(usuario).getId();
            commentDAO.createComment(iniciativa,mensaje,id);
        }
    }

    @Override
    public Comment getComment(int idComment) throws JtamsExceptions {
        return null;
    }

    @Override
    public int getnumComentariosUsuario(int user) throws JtamsExceptions {
        return 0;
    }

    public CommentDAO getCommentDAO() {
        return commentDAO;
    }

    public void setCommentDAO(CommentDAO commentDAO) {
        this.commentDAO = commentDAO;
    }

    public InitiativeDAO getInitiativeDAO() {
        return initiativeDAO;
    }

    public void setInitiativeDAO(InitiativeDAO initiativeDAO) {
        this.initiativeDAO = initiativeDAO;
    }
}
