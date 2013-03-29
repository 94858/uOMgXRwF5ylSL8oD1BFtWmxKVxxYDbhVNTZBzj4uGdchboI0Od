/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.rmt.daoImpl;

import fr.rmt.dao.ClientDao;
import fr.rmt.entities.Client;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author supinfo
 */
@Stateless
public class ClientDaoImpl implements ClientDao{

    @PersistenceContext(unitName = "RMTPU")
    private EntityManager em;
    
    @Override
    public void addClient(Client client) {
        em.persist(client);
    }

    @Override
    public Client findClientById(Long clientId) {
        return em.find(Client.class, clientId);
    }

    @Override
    public Client updateClient(Client client) {
        return em.merge(client);
    }

    @Override
    public List<Client> findAllClients() {
        Query query = em.createNamedQuery("Client.findAllClients");
        return query.getResultList();
    }

    @Override
    public boolean deleteClient(Long clientId) {
        Client c = em.find(Client.class, clientId);
        try {
            em.merge(c);
            em.remove(c);
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }


}
