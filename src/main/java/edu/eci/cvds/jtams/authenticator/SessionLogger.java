package edu.eci.cvds.jtams.authenticator;

import edu.eci.cvds.jtams.exceptions.JtamsExceptions;

public interface SessionLogger {
    public void login(String correo,String password,boolean hist) throws JtamsExceptions;

    public boolean isLogged();
}