/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sample.java.jpa.model;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

/**
 *
 * @author Francisco Correia {@literal <fjrcorreia@github.com>}
 */
@Entity(name = "attributes")
@SequenceGenerator(name = "attributes_sequence", sequenceName = "attributes_sequence")
public class AttributeDao implements Serializable {
    
    @Id
    @GeneratedValue(generator = "attributes_sequence")
    private int id;
    private String name;
    private String type;

    
    public AttributeDao(){}
    
    public AttributeDao(String name, String type){
        this.name = name;
        this.type = type;
    }
    
    
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }
    
    
    
    
    
}
