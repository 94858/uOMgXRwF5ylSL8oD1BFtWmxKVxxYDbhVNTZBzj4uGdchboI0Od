package fr.rmt.daoImpl;

import fr.rmt.dao.ManagerDao;
import fr.rmt.entities.Manager;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Doudoupe
 */
@Stateless
public class ManagerDaoImpl implements ManagerDao {

    @PersistenceContext(unitName = "RMTPU")
    private EntityManager em;

    @Override
    public void addManager(Manager manager) {
        em.persist(manager);
    }

    @Override
    public Manager findManagerById(Long managerId) {
        return em.find(Manager.class, managerId);
    }

    @Override
    public Manager updateManager(Manager manager) {
        return em.merge(manager);
    }

    @Override
    public List<Manager> findAllManagers() {
        Query query = em.createNamedQuery("Manager.findAllManagers");
        return query.getResultList();
    }

    @Override
    public boolean deleteManager(Long managerId) {
        Manager m = em.find(Manager.class, managerId);
        try {
            em.merge(m);
            em.remove(m);
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }
}
