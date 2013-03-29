/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.rmt.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.GregorianCalendar;
import javax.persistence.Entity;

/**
 *
 * @author Doudoupe
 */
@Entity
public class Manager extends UserRMT implements Serializable {
    private static final long serialVersionUID = 1L;

    private String suitSize;

    // Constructors
    public Manager(){}
    public Manager(String username, String password, String firstname, String lastname, String email, GregorianCalendar birth, String suitSize){
        super.setUsername(username);
        super.setPassword(password);
        super.setFirstname(firstname);
        super.setLastname(lastname);
        super.setEmail(email);
        super.setBirth(new GregorianCalendar());
        this.suitSize = suitSize;
    }
    
    // Getters & Setters
    public String getSuitSize() {
        return suitSize;
    }

    public void setSuitSize(String suitSize) {
        this.suitSize = suitSize;
    }

}
