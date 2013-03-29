package fr.rmt.dao;

import fr.rmt.entities.Manager;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Doudoupe
 */
@Local
public interface ManagerDao {
    
    public void addManager(Manager manager);
    public Manager findManagerById(Long managerId);
    public Manager updateManager(Manager manager);
    public List<Manager> findAllManagers();
    public boolean deleteManager(Long managerId);
    
}
