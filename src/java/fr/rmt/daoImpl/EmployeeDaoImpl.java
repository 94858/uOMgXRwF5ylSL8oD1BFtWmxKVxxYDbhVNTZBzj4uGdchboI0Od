package fr.rmt.daoImpl;

import fr.rmt.dao.EmployeeDao;
import fr.rmt.entities.Employee;
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
public class EmployeeDaoImpl implements EmployeeDao {

    @PersistenceContext(unitName = "RMTPU")
    private EntityManager em;

    @Override
    public void addEmployee(Employee employee) {
        em.persist(employee);
    }

    @Override
    public Employee findEmployeeById(Long employeeId) {
        return em.find(Employee.class, employeeId);
    }

    @Override
    public Employee updateEmployee(Employee employee) {
        return em.merge(employee);
    }

    @Override
    public List<Employee> findAllEmployees() {
        Query query = em.createNamedQuery("Employee.findAllEmployees");
        return query.getResultList();
    }
    
    @Override
    public List<Employee> findEmployeesByManager(Manager m) {
        Query query = em.createNamedQuery("Employee.findAllByManager").setParameter("manager", m);
        return query.getResultList();
    }

    @Override
    public boolean deleteEmployee(Long employeeId) {
        Employee c = em.find(Employee.class, employeeId);
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
