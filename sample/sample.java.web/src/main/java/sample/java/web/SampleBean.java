/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sample.java.web;

import java.util.Collections;
import java.util.List;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import sample.java.api.InternalBeanLocal;
import sample.java.api.ServiceBeanRemote;
import sample.java.api.model.User;
import sample.java.api.model.UserAttribute;

/**
 *
 * @author Francisco Correia {@literal <fjrcorreia@github.com>}
 */
public class SampleBean {

    @EJB
    private ServiceBeanRemote sampleEjb;

    public SampleBean() {
        System.out.println("Remote EJB: " + sampleEjb);

        if (sampleEjb == null) {
            try {
                doLookup();
                System.out.println("Remote EJB (2): " + sampleEjb);
            } catch (NamingException ex) {
                Logger.getLogger(SampleBean.class.getName()).log(Level.SEVERE, null, ex);
            }

        }

    }

    private void doLookup() throws NamingException {
        Properties jndiProps = new Properties();
        //jndiProps.put(Context.INITIAL_CONTEXT_FACTORY, "org.jboss.naming.remote.client.InitialContextFactory");
        jndiProps.put(Context.PROVIDER_URL, "http-remoting://localhost:8080");

        // create a context passing these properties
        Context ctx = new InitialContext(jndiProps);
        
        // lookup
        sampleEjb = (ServiceBeanRemote) ctx.lookup("java:global/sample.java.ear-1.0.0-SNAPSHOT/sample.java.ejb-1.0.0-SNAPSHOT/ServiceBean!sample.java.api.ServiceBeanRemote");
    }

    public List<User> getUsers() {
        return sampleEjb.getUsers();
    }

    
    public List<UserAttribute> getUserAttributes(User user){
        return sampleEjb.getUserAttributes(user);
    }
    
    
    
    
    private String getJndiName(){
        //=========================================================
//=====    Montando jndiName

        // nome do file.ear sem sufixo.ear('file') ou app_name in application.xml
        // se nao tiver .ear deixar vazio
        String appName = "sample.java.ear-1.0.0-SNAPSHOT.ear";

        // nome do .jar ou .war (-sufixo) ou module-name in web.xml/ejb-jar.xml
        String moduleName = "dado";

        String distinctName = "";

        // Nome da classe do bean ou apelido<(@Stateless(name="apelido")> ou ainda ejb-jar.xml
        String beanName = "LancadorDadosBean";

        // Interface fully qualified
        String interfaceFullName = "ServiceBean!sample.java.api.ServiceBeanRemote";

        // ejb:{app-Name}/{module-Name}/{distinct-Name}/{bean-Name}!{fullPath-remote-Interface}

        //Meu caso:ejb:/dado//LancadorDadosBean!br.com.eder.sessionbean.LancadorDados
        String jndiName = "ejb:" + appName + "/" + moduleName + "/"
                + distinctName + "/" + beanName + "!" + interfaceFullName;

        // IMPORTANTE:
        // |=> No deploy, o objBeam deve aparecer em "java:jboss/exported/namespaceJNDI"
        // |=> O objBean tem de ser serializable
//        Tentativa_1(fail): setando propriedades
//        LancadorDados lancadorDados = (LancadorDados) jndi.lookup(jndiName);

        return jndiName;
    }
}
