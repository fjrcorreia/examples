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
public class UserAttributeImpl implements UserAttribute, Serializable {

    String name;
    String value;
    String type;
    
    public UserAttributeImpl(String name, String value, String type){
        this.name = name;
        this.value = value;
        this.type = type;
    }
    
    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getValue() {
        return value;
    }

    @Override
    public String getType() {
        return type;
    }

}
