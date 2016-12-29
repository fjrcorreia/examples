/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sample.java.jpa.model;

import java.io.Serializable;
import java.security.Principal;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

/**
 *
 * @author Francisco Correia {@literal <fjrcorreia@github.com>}
 */
@Entity(name = "users")
@SequenceGenerator(name = "users_sequence", sequenceName = "users_sequence")
public class User implements Principal, Serializable {
    
    @Id
    @GeneratedValue(generator = "users_sequence")
    private int id;
    
    private String username;
    
    private byte[] password;
    
    @Column(name = "display_name")
    private String displayName;

    
    
    @Override
    public String getName() {
        return username;
    }
    
    
}
