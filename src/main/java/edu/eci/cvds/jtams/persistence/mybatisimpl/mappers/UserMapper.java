package edu.eci.cvds.jtams.persistence.mybatisimpl.mappers;

import edu.eci.cvds.jtams.model.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserMapper {

    public void createUser (@Param("id") int id, @Param("email") String email, @Param("name") String name, @Param("password") String password);

    public void updateUser (@Param("id") int id, @Param("email") String email, @Param("name") String name, @Param("password") String password);

    public List<User> getUsers();

    public User getUser(@Param("username") String username);
}
