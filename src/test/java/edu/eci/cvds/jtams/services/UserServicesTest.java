package edu.eci.cvds.jtams.services;


import com.google.inject.Inject;
import edu.eci.cvds.jtams.exceptions.JtamsExceptions;
import edu.eci.cvds.jtams.model.User;
import edu.eci.cvds.jtams.model.UserType;
import org.junit.Assert;
import org.junit.Test;

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

}
