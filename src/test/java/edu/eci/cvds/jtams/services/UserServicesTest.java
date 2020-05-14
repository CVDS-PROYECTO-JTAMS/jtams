package edu.eci.cvds.jtams.services;


import com.google.inject.Inject;

import edu.eci.cvds.jtams.exceptions.JtamsExceptions;
import edu.eci.cvds.jtams.model.User;
import edu.eci.cvds.jtams.model.UserType;
import edu.eci.cvds.jtams.model.Initiative;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class UserServicesTest {

    @Inject
    private UserServices userService;
    private InitiativeServices initiativeServices;
    private CommentServices commentServices;
    private Random random = new Random();

    public UserServicesTest() {

        userService = InitiativeServicesFactory.getInstance().getUserServicesTesting();
    }

    @Test(expected = JtamsExceptions.class)
    public void testCreateUserWithNullUser() throws JtamsExceptions {
        userService.createUser(null);
    }

    @Test
    public void testCreateUser() throws JtamsExceptions {
        int id = random.nextInt();
        userService.createUser(new User(id, "name", "createEmail", "password", UserType.ADMINISTRATOR));
        User u = userService.getUser("createEmail");
        Assert.assertEquals(u.getEmail(), "createEmail");
    }

    @Test
    public void testUpdateUser() throws JtamsExceptions {
        int id = random.nextInt();
        userService.createUser(new User(id, "name", "updateEmail", "password", UserType.ADMINISTRATOR));
        userService.updateUser(new User(id, "name", "updateEmail", "password1", UserType.ADMINISTRATOR));
        User u = userService.getUser("updateEmail");
        Assert.assertEquals(u.getEmail(), "updateEmail");
        Assert.assertEquals(u.getPassword(), "password1");
    }
    
    @Test
    public void testGetUsers() throws JtamsExceptions {
        int id = random.nextInt();
        int sizeL=userService.getUsers().size();
        userService.createUser(new User(id, "name0", "updateEmail0", "password0", UserType.ADMINISTRATOR));
        userService.createUser(new User(id+1, "name1", "updateEmail1", "password1", UserType.ADMINISTRATOR));
        userService.createUser(new User(id+2, "name2", "updateEmail2", "password2", UserType.ADMINISTRATOR));
        userService.createUser(new User(id+3, "name3", "updateEmail3", "password3", UserType.ADMINISTRATOR));
        userService.createUser(new User(id+4, "name4", "updateEmail4", "password4", UserType.ADMINISTRATOR));
        List<User> listaUsuarios=userService.getUsers();
        Assert.assertEquals(listaUsuarios.size(), sizeL+5);
        
    }
    
    @Test
    public void testGetUser() throws JtamsExceptions {
        int id = random.nextInt();
        userService.createUser(new User(id, "name00", "updateEmail00", "password00", UserType.ADMINISTRATOR));
        userService.createUser(new User(id+1, "name11", "updateEmail11", "password11", UserType.ADMINISTRATOR));
        User u = userService.getUser("updateEmail00");
        Assert.assertEquals(u.getEmail(), "updateEmail00");
        Assert.assertEquals(u.getPassword(), "password00");    
    }
    
    @Test
    public void testGetUser2() throws JtamsExceptions {
        int id = random.nextInt();
        userService.createUser(new User(id, "name000", "updateEmail000", "password000", UserType.ADMINISTRATOR));
        userService.createUser(new User(id+1, "name111", "updateEmail111", "password111", UserType.ADMINISTRATOR));
        User u = userService.getUser("updateEmail111");
        Assert.assertEquals(u.getEmail(), "updateEmail111");
        Assert.assertEquals(u.getPassword(), "password111"); 
    }
    
    @Test
    public void testGetUserNull() throws JtamsExceptions {
        User u = userService.getUser("updateEm1");
        Assert.assertNull(u);
    }
    
    @Test
    public void testValidateLogin() throws JtamsExceptions {
        int id = random.nextInt();
        userService.createUser(new User(id, "nam000", "updatEmail000", "passwod000", UserType.ADMINISTRATOR));
        boolean login=userService.validateLogin("updatEmail000","passwod000");
        Assert.assertTrue(login);
    }
    
    @Test
    public void testValidateLoginFalseUser() throws JtamsExceptions {
        int id = random.nextInt();
        userService.createUser(new User(id, "am000", "pdatEmail00", "passwod000", UserType.ADMINISTRATOR));
        boolean login=userService.validateLogin("am000","passwod000");
        Assert.assertFalse(login);
    }
    
    @Test
    public void testValidateLoginFalsePass() throws JtamsExceptions {
        int id = random.nextInt();
        userService.createUser(new User(id, "am010", "pdatEmail100", "passwod000", UserType.ADMINISTRATOR));
        boolean login=userService.validateLogin("am010","passwod010");
        Assert.assertFalse(login);
    }
    
    @Test
    public void testUpdateTypeUser() throws JtamsExceptions {
        int id = random.nextInt();
        userService.createUser(new User(id, "name9", "updateEmail9", "password9", UserType.ADMINISTRATOR));
        userService.updateTypeUser("updateEmail9",UserType.PERSONAL);
        User u = userService.getUser("updateEmail9");
        Assert.assertEquals(u.getType(), UserType.PERSONAL);
    }
    
    @Test
    public void testUpdateTypeUserFail() throws JtamsExceptions {
    	int id = random.nextInt();
        userService.createUser(new User(id, "name90", "updateEmail90", "password90", UserType.ADMINISTRATOR));
        userService.updateTypeUser("updateEmail90",UserType.PERSONAL);
        User u = userService.getUser("updateEmail90");
        Assert.assertNotEquals(u.getType(), UserType.PROPONENT);
    }
    
    @Test
    public void testGetInitiativesNull() throws JtamsExceptions {
    	List<Initiative> listain=userService.dariniciativas();
        Assert.assertNull(listain);
    }
    @Test
    public void testGetInitiatives() throws JtamsExceptions {
    	List<String> prueba=Arrays.asList(); 
    	//prueba.add("prueba");
    	//initiativeServices.createInitiative("descripcion", "area", 545,prueba, "name");
    	List<Initiative> listain=userService.dariniciativas();
        Assert.assertNull(listain);
    }
    


}
