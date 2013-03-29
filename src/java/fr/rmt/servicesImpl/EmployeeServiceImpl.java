package fr.rmt.servicesImpl;

import fr.rmt.dao.EmployeeDao;
import fr.rmt.entities.Employee;
import fr.rmt.entities.Manager;
import fr.rmt.services.EmployeeService;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.validation.ConstraintViolationException;

/**
 *
 * @author Doudoupe
 */
@Stateless
public class EmployeeServiceImpl implements EmployeeService {
    
    @EJB
    EmployeeDao employeeDao;
    
    @Override
    public void addEmployee(Employee employee) {
        try {
            employeeDao.addEmployee(employee);
        } catch (ConstraintViolationException e) {
            System.err.println("Impossible d'ajouter l'employé");
            System.err.println(e.getConstraintViolations().size());
            System.err.println(e.getConstraintViolations().toString());
        }
    }
    
    @Override
    public Employee findEmployeeById(Long employeeId) {
        return employeeDao.findEmployeeById(employeeId);
    }
    
    @Override
    public Employee updateEmployee(Employee employee) {
        return employeeDao.updateEmployee(employee);
    }
    
    @Override
    public List<Employee> findAllEmployees() {
        return employeeDao.findAllEmployees();
    }
    
    @Override
    public List<Employee> findAllEmployeesByManager(Manager m) {
        return employeeDao.findEmployeesByManager(m);
    }
    
    @Override
    public boolean deleteEmployee(Long employeeId) {
        return employeeDao.deleteEmployee(employeeId);
    }
}
