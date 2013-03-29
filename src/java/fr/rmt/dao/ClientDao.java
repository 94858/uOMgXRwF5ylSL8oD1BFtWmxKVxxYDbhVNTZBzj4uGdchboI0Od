/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.rmt.dao;

import fr.rmt.entities.Client;
import java.util.List;
import javax.ejb.Local;
import javax.ejb.Stateless;

/**
 *
 * @author supinfo
 */
@Local
public interface ClientDao  {

    public void addClient(Client client);
    public Client findClientById(Long clientId);
    public Client updateClient(Client client);
    public List<Client> findAllClients();
    public boolean deleteClient(Long clientId);

}
