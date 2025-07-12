package com.pets.client;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import com.pets.ejb.UserServiceBean;
import com.pets.ejb.UserService;

import java.util.Hashtable;
import java.util.Properties;

public class PetsApp {
    public static void main(String[] args) throws Exception {
        Properties props = new Properties();
        props.setProperty(Context.INITIAL_CONTEXT_FACTORY, "org.wildfly.naming.client.WildFlyInitialContextFactory");
        props.setProperty(Context.PROVIDER_URL, "http-remoting://localhost:8080");
        props.setProperty(Context.URL_PKG_PREFIXES, "org.jboss.ejb.client.naming");

        UserService service = (UserService) new InitialContext(props).lookup("ejb:/pets-app-ejb/UserServiceBean!com.pets.ejb.UserService");
        new LoginFrame(service).setVisible(true);
        //new LoginFrame().setVisible(true);
    }

    private static UserService lookupHelloService() throws NamingException {
        final Hashtable<String, Object> jndiProps = new Hashtable<>();
        jndiProps.put(Context.INITIAL_CONTEXT_FACTORY, "org.wildfly.naming.client.WildFlyInitialContextFactory");
        jndiProps.put(Context.PROVIDER_URL, "http-remoting://localhost:8080"); // or your WildFly host
        //jndiProps.put(Context.SECURITY_PRINCIPAL, "admin"); // WildFly user
        //jndiProps.put(Context.SECURITY_CREDENTIALS, "password"); // WildFly user password

        final Context context = new InitialContext(jndiProps);

        String jndiName = "ejb:/YourAppName/HelloServiceBean!com.example.HelloService";
        return (UserService) context.lookup(jndiName);
    }
}