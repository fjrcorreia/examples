
import java.util.ArrayList;
import java.util.List;
import sample.java.api.model.User;
import sample.java.api.model.UserImpl;
import sample.java.jpa.model.UserDao;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Francisco Correia {@literal <fjrcorreia@github.com>}
 */
public class Main {
    
    
    public static void main(String args []){
        UserDao us = new UserDao("test-00", "123", "Test User");
        UserImpl ui = new UserImpl(us.getName(), us.getDisplayName());
        User u = (User) ui;
        List<User> l = new ArrayList<User>();
        l.add((User) ui);
        System.out.println("User: " + l);
    }
}
