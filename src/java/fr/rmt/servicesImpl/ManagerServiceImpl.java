/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.rmt.servicesImpl;

import fr.rmt.dao.ManagerDao;
import fr.rmt.daoImpl.ManagerDaoImpl;
import fr.rmt.entities.Manager;
import fr.rmt.services.ManagerService;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.validation.ConstraintViolationException;

/**
 *
 * @author Doudoupe
 */
@Stateless
public class ManagerServiceImpl implements ManagerService {

    @EJB
    ManagerDao managerDao;
    
    @Override
    public void addManager(Manager manager) {
        try {
            managerDao.addManager(manager);
        } catch (ConstraintViolationException e) {
            System.err.println("Impossible d'ajouter l'employé");
            System.err.println(e.getConstraintViolations().size());
            System.err.println(e.getConstraintViolations().toString());
        }
    }

    @Override
    public Manager findManagerById(Long managerId) {
        return managerDao.findManagerById(managerId);
    }

    @Override
    public Manager updateManager(Manager manager) {
        return managerDao.updateManager(manager);
    }

    @Override
    public List<Manager> findAllManagers() {
        return managerDao.findAllManagers();
    }

    @Override
    public boolean deleteManager(Long managerId) {
        return managerDao.deleteManager(managerId);
    }
    
}
