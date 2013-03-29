/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.rmt.servicesImpl;

import fr.rmt.dao.ClientDao;
import fr.rmt.entities.Client;
import fr.rmt.services.ClientService;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author supinfo
 */
@Stateless
public class ClientServiceImpl implements ClientService{

    @EJB
    ClientDao clientDao;
    
    @Override
    public void addClient(Client client) {
        clientDao.addClient(client);
    }

    @Override
    public Client findClientById(Long clientId) {
        return clientDao.findClientById(clientId);
    }

    @Override
    public Client updateEmployee(Client client) {
        return clientDao.updateClient(client);
    }

    @Override
    public List<Client> findAllClients() {
        return clientDao.findAllClients();
    }

    @Override
    public boolean deleteClient(Long employeeId) {
        return clientDao.deleteClient(employeeId);
    }


}
