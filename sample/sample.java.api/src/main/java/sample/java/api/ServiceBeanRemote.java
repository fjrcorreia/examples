/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sample.java.api;

import java.util.List;
import javax.ejb.Remote;
import sample.java.api.model.User;
import sample.java.api.model.UserAttribute;

/**
 *
 * @author Francisco Correia {@literal <fjrcorreia@github.com>}
 */
@Remote
public interface ServiceBeanRemote {
    
    List<User> getUsers();
    
    List<UserAttribute> getUserAttributes(User user);
}
