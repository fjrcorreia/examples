/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sample.java.ejb;

import sample.java.api.InternalBeanLocal;
import java.util.Collections;
import java.util.List;
import javax.ejb.Local;
import javax.ejb.Stateless;

/**
 *
 * @author Francisco Correia {@literal <fjrcorreia@github.com>}
 */
@Stateless
@Local(InternalBeanLocal.class)
public class InternalBean implements InternalBeanLocal {

    @Override
    public List<String> getUsers() {
        return Collections.emptyList();
    }
}
