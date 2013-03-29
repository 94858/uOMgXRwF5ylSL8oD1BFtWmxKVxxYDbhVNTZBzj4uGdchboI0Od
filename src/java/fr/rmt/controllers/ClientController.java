/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.rmt.controllers;

import fr.rmt.entities.Client;
import fr.rmt.services.ClientService;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author supinfo
 */
@ManagedBean
@RequestScoped
public class ClientController {

    /**
     * Creates a new instance of ClientController
     */
    @EJB
    ClientService clientService;
    
    private Long id;
    private String name;
    
    public ClientController() {
    }

    public String addClient() {
        Client c = new Client();
        c.setName(name);
        try {
            clientService.addClient(c);
            return "/pages/logged/manager_home?faces-redirect=true";
        } catch (Exception ex){
            return "/pages/logged/add_client";
        }
    }
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
}
