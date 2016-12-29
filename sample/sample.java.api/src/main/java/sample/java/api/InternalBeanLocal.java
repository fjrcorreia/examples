/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sample.java.api;

import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Francisco Correia {@literal <fjrcorreia@github.com>}
 */
@Local
public interface InternalBeanLocal {
    
    List<String> getUsers();
    
}
