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
public class InitiativeServicesTest {
	@Inject
    private UserServices userService;
    private InitiativeServices initiativeServices;
    private CommentServices commentServices;
    private Random random = new Random();
    public InitiativeServicesTest() {

    	initiativeServices = InitiativeServicesFactory.getInstance().getInitiativeServicesTesting();
    }

    @Test(expected = JtamsExceptions.class)
    public void testCreateUserWithNullUser() throws JtamsExceptions {
    	initiativeServices.createInitiative(null, null, 0, null, null);
    }
    @Test
    public void testCreateInitiative() throws JtamsExceptions {
    	List<Initiative> listain=initiativeServices.dariniciativas();
    	int inicial=listain.size();
    	String palabra="palabra";
        List<String>claves=Arrays.asList(palabra.split(",")); 
        initiativeServices.createInitiative("descripcion", "area",1015475103, claves, "name");
        listain=initiativeServices.dariniciativas();
        int finalsize=listain.size();
        Assert.assertNotEquals(inicial,finalsize);
    }
}
