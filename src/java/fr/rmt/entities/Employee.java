/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.rmt.entities;

import java.io.Serializable;
import java.util.GregorianCalendar;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Past;

/**
 *
 * @author Doudoupe
 */
@Entity
@NamedQuery(name="Employee.findAllByManager", query="select e from Employee e where e.manager = :manager")
public class Employee extends UserRMT implements Serializable {
    private static final long serialVersionUID = 1L;
    
    @ManyToOne
    private Manager manager;
    @Temporal(TemporalType.DATE)
    @Past
    private GregorianCalendar hireDate;

    // Constructors
    public Employee(){}
    public Employee(String username, String password, String firstname, String lastname, String email, GregorianCalendar birth, GregorianCalendar hireDate, Manager manager){
        super.setUsername(username);
        super.setPassword(password);
        super.setFirstname(firstname);
        super.setLastname(lastname);
        super.setEmail(email);
        super.setBirth(new GregorianCalendar());
        this.hireDate = hireDate;
        this.manager = manager;
    }
    
    // Getters & Setters
    public Manager getManager() {
        return manager;
    }

    public void setManager(Manager manager) {
        this.manager = manager;
    }

    public GregorianCalendar getHireDate() {
        return hireDate;
    }

    public void setHireDate(GregorianCalendar hireDate) {
        this.hireDate = hireDate;
    }

}
