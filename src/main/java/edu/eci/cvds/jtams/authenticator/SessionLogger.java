package edu.eci.cvds.jtams.authenticator;

import edu.eci.cvds.jtams.exceptions.JtamsExceptions;
import edu.eci.cvds.jtams.model.UserType;

public interface SessionLogger {
    public UserType login(String correo, String password, boolean hist) throws JtamsExceptions;

    public boolean isLogged();

    public void logout();
}