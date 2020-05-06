package edu.eci.cvds.jtams.authenticator;


import com.google.inject.Inject;
import edu.eci.cvds.jtams.exceptions.JtamsExceptions;
import edu.eci.cvds.jtams.model.User;
import edu.eci.cvds.jtams.model.UserType;
import edu.eci.cvds.jtams.services.UserServices;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.crypto.hash.Sha256Hash;
import org.apache.shiro.subject.Subject;

public class ShiroSession implements SessionLogger {

    @Inject
    private UserServices userServices;

    public UserServices getUserServices() {
        return userServices;
    }

    public void setUserServices(UserServices userServices) {
        this.userServices = userServices;
    }

    @Override
    public UserType login(String correo, String password, boolean hist) throws JtamsExceptions {
        try{

            Subject currentUser = SecurityUtils.getSubject();
            UsernamePasswordToken token = new UsernamePasswordToken(correo, new Sha256Hash(password).toHex(),hist);
            currentUser.getSession().setAttribute("Correo",correo);
            currentUser.login( token );
            User user = userServices.getUser(correo);

            return user != null ? user.getType() : null;

        } catch ( UnknownAccountException a ) {
            throw new JtamsExceptions("Usuario incorrecto",a);
        } catch ( IncorrectCredentialsException b ) {
            throw new JtamsExceptions("Contraseña incorrecta",b);
        }
    }

    @Override
    public boolean isLogged() {
        return SecurityUtils.getSubject().isAuthenticated();
    }

    @Override
    public void logout() {
        SecurityUtils.getSubject().logout();
    }
}
