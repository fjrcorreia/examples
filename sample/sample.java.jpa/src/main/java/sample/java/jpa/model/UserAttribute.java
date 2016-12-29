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

/**
 *
 * @author Francisco Correia {@literal <fjrcorreia@github.com>}
 */
@Entity(name = "user_attributes")
public class UserAttribute implements Serializable {
    
    @Id
    @ManyToOne
    private User user;
    
    @Id
    @ManyToOne
    private Attribute attribute;
    
    @Column(name = "attr_value")
    private String value;
    
    
    
}
