/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sample.java.jpa.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import sample.java.api.model.UserAttribute;

/**
 *
 * @author Francisco Correia {@literal <fjrcorreia@github.com>}
 */
@Entity(name = "user_attributes")
public class UserAttributeDao implements UserAttribute, Serializable {
    
    @Id
    @ManyToOne
    private UserDao user;
    
    @Id
    @ManyToOne
    private AttributeDao attribute;
    
    @Column(name = "attr_value")
    private String value;

    
    public UserAttributeDao(){}
    
    public UserAttributeDao(UserDao u, AttributeDao a, String value){
        user = u;
        attribute = a;
        this.value = value;
    }
    
    
    
    @Override
    public String getName() {
        return attribute.getName();
    }

    @Override
    public String getValue() {
        return value;
    }

    @Override
    public String getType() {
        return attribute.getType();
    }
    
    
    
}
