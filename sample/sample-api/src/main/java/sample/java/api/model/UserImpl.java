/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sample.java.api.model;

import java.io.Serializable;

/**
 *
 * @author Francisco Correia {@literal <fjrcorreia@github.com>}
 */
public class UserImpl implements User, Serializable {

    private static final long serialVersionUID = 1L;

    
    private String username;
    
    
    private String displayName;

    
    public UserImpl(String username,  String displayName){
        this.username = username;
        this.displayName = displayName;
    }
    
    
    
    @Override
    public String getName() {
        return username;
    }

    @Override
    public String toString() {
        return "UserImpl{ username=" + username + ", displayName=" + displayName + '}';
    }
    
    

}
