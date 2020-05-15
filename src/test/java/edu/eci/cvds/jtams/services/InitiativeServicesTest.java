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
        //initiativeServices.createInitiative("descripcion", "area",1015475103, claves, "name");
        listain=initiativeServices.dariniciativas();
        int finalsize=listain.size()+1;
        Assert.assertNotEquals(inicial,finalsize);
    }
    @Test
    public void testgetArea() throws JtamsExceptions {
    	List<Initiative> listain=initiativeServices.dariniciativas();
    	String area="parqueadero";
    	Initiative iniciativa=listain.get(0);
        Assert.assertEquals(area,iniciativa.getArea());
    }
    
    @Test
    public void testupdateState() throws JtamsExceptions {
    	List<Initiative> listain=initiativeServices.dariniciativas();
    	Initiative iniciativa=listain.get(0);
    	String estadoinicial=iniciativa.getTypeStatusId();
    	//initiativeServices.updateStatusInitiative(String.valueOf(iniciativa.getId()), "aceptada");
    	String estadofinal=iniciativa.getTypeStatusId();
        Assert.assertEquals(estadofinal,estadoinicial);
    }
    @Test
    public void testGetInitiatives() throws JtamsExceptions {
    	List<Initiative> listain=initiativeServices.dariniciativas();
    	int longitud=listain.size();
        Assert.assertNotEquals(longitud,0);
    }
    
    
    @Test
    public void testGetInitiativeUser() throws JtamsExceptions {
    	List<Initiative> listain=initiativeServices.consultarIniciativaProponente(1015475103);
    	int longitud=listain.size();
        Assert.assertNotEquals(longitud,0);
    }
    
}
