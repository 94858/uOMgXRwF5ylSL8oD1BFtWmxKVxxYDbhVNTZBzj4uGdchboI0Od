package fr.rmt.daoImpl;

import fr.rmt.dao.EmployeeDao;
import fr.rmt.dao.ManagerDao;
import fr.rmt.dao.UserRMTDao;
import fr.rmt.entities.Employee;
import fr.rmt.entities.Manager;
import fr.rmt.entities.UserRMT;
import java.util.GregorianCalendar;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Doudoupe
 */
@Stateless
public class UserRMTDaoImpl implements UserRMTDao {
    
    @EJB
    ManagerDao managerDao;
    
    @EJB
    EmployeeDao employeeDao;
 
    @PersistenceContext(unitName = "RMTPU")
    private EntityManager em;
    
    @Override
    public UserRMT findUserByUsername(String username) {
        Query query = em.createNamedQuery("User.findByUsername").setParameter("username", username);
        try {
            return (UserRMT) query.getSingleResult();
        } catch (javax.persistence.NoResultException e) {
            return null;
        }
    }

    @Override
    public boolean populateUsers() {
        
        GregorianCalendar birthM = new GregorianCalendar();
        birthM.set(1989, 02, 23);
        GregorianCalendar birthE = new GregorianCalendar();
        birthM.set(1991, 10, 4);

        Manager m = new  Manager("manager1", "Supinf0", "Man", "Ager", "manager1@test.fr", birthM,"L");
        Employee e = new Employee("emp1", "Supinf0", "Emp", "Loyee", "emp1@rmt.com", birthE, new GregorianCalendar(), m);
        
        try {
            
            managerDao.addManager(m);
            employeeDao.addEmployee(e);
            return true;
            
        } catch(Exception ex) {
            System.out.println(ex.getMessage());
            return false;
        }  
    }
}
