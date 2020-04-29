package edu.eci.cvds.jtams.authenticator;


import edu.eci.cvds.jtams.exceptions.JtamsExceptions;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.crypto.hash.Sha256Hash;
import org.apache.shiro.subject.Subject;

public class ShiroSession implements SessionLogger {
    @Override
    public void login(String correo,String password,boolean hist) throws JtamsExceptions {
        try{

            Subject currentUser = SecurityUtils.getSubject();

            UsernamePasswordToken token = new UsernamePasswordToken(correo, new Sha256Hash(password).toHex(),hist);

            currentUser.getSession().setAttribute("Correo",correo);

            currentUser.login( token );

        } catch ( UnknownAccountException a ) {
            throw new JtamsExceptions("Usuario o contraseña incorrectos",a);
        } catch ( IncorrectCredentialsException b ) {
            throw new JtamsExceptions("Usuario o contraseña incorrectos",b);
        }
    }

    @Override
    public boolean isLogged() {
        return SecurityUtils.getSubject().isAuthenticated();
    }
}
