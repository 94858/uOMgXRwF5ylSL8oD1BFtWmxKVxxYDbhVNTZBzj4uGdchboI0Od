/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.rmt.services;

import fr.rmt.entities.Client;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author supinfo
 */
@Local
public interface ClientService {

    public void addClient(Client client);
    public Client findClientById(Long clientId);
    public Client updateEmployee(Client client);
    public List<Client> findAllClients();
    public boolean deleteClient(Long employeeId);

}
