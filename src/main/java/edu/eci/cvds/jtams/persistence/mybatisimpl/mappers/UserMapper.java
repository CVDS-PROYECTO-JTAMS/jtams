package edu.eci.cvds.jtams.persistence.mybatisimpl.mappers;

import edu.eci.cvds.jtams.model.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserMapper {
	/**
	  *Registra un nuevo usuario 
	  * 
	  * @param id ID del usuario 
	  * @param email email del usuario 
   	  * @param name nombre del usuario  
   	  * @param password clave del usuario  
   	  * @param type_user tipo de usuario 
   	  * 
	*/
    public void createUser (@Param("id") int id, @Param("email") String email, @Param("name") String name, @Param("password") String password, @Param("type_user") int userType);
    /**
	  *Actualiza un usuario 
	  * 
	  * @param id ID del usuario 
	  * @param email email del usuario 
  	  * @param name nombre del usuario  
  	  * @param password clave del usuario  
  	  * @param type_user tipo de usuario 
  	  * 
	*/
    public void updateUser (@Param("id") int id, @Param("email") String email, @Param("name") String name, @Param("password") String password, @Param("type_user") int userType);

    public List<User> getUsers();

    public User getUser(@Param("username") String username);
    /**
	  *Actualiza un usuario por su estado
	  * 
	  * @param id ID del usuario 
	  * @param email email del usuario 
 	  * @param name nombre del usuario  
 	  * @param password clave del usuario  
 	  * @param type_user nuevo tipo de usuario 
 	  * 
	*/
    public void updateTypeUser (@Param("email") String email,@Param("type_user") int userType) ;
}
