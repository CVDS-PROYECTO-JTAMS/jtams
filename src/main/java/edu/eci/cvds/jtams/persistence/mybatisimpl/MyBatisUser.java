package edu.eci.cvds.jtams.persistence.mybatisimpl;

import com.google.inject.Inject;
import edu.eci.cvds.jtams.exceptions.JtamsExceptions;
import edu.eci.cvds.jtams.model.User;
import edu.eci.cvds.jtams.persistence.UserDAO;
import edu.eci.cvds.jtams.persistence.mybatisimpl.mappers.UserMapper;

import java.util.List;

public class MyBatisUser implements UserDAO {

    @Inject
    private UserMapper userMapper;
    /**
	  *Registra un usuario
	  *
	  * @param user Usuario al que se le realizar el registro
	  */
    @Override
    public void createUser(User user) throws JtamsExceptions {
        try {
            userMapper.createUser(user.getId(), user.getEmail(), user.getName(), user.getPassword(), user.getType().getId());
        } catch (Exception e) {
            throw new JtamsExceptions("There was an exception persisting the user to the database", e);
        }
    }
    /**
	  *Actualiza un usuario
	  *
	  *@param user Usuario al que se desea realizar la actualizacion
	  */
    @Override
    public void updateUser(User user) throws JtamsExceptions {
        try {
            userMapper.updateUser(user.getId(), user.getEmail(), user.getName(), user.getPassword(), user.getType().getId());
        } catch (Exception e) {
            throw new JtamsExceptions("There was an exception persisting the user to the database", e);
        }
    }

    @Override
    public List<User> getUsers() throws JtamsExceptions {
        try {
            return userMapper.getUsers();
        } catch (Exception e) {
            throw new JtamsExceptions("There was an exception retrieving the users from the database", e);
        }
    }

    @Override
    public User getUser(String username) throws JtamsExceptions {
        try {
            return userMapper.getUser(username);
        } catch (Exception e) {
            throw new JtamsExceptions("There was an exception retrieving the users from the database", e);
        }
    }
    /**
	  *Actualiza el tipo de usuario
	  * @param email correpondiente al usuario 
	  * @param userType nuevo tipo de usuario valido 
	  */
    @Override
    public void updateTypeUser(String email, int userType) throws JtamsExceptions{
        try {
            userMapper.updateTypeUser(email, userType);
        } catch(Exception e) {
            throw new JtamsExceptions("There was an exception retrieving the users from the database", e);
        }
    }

    public UserMapper getUserMapper() {
        return userMapper;
    }

    public void setUserMapper(UserMapper userMapper) {
        this.userMapper = userMapper;
    }
}
