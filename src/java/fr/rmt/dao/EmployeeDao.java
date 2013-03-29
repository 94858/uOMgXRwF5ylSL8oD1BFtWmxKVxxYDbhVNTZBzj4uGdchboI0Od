package fr.rmt.dao;

import fr.rmt.entities.Employee;
import fr.rmt.entities.Manager;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Doudoupe
 */
@Local
public interface EmployeeDao {
    
    public void addEmployee(Employee employee);
    public Employee findEmployeeById(Long employeeId);
    public Employee updateEmployee(Employee employee);
    public List<Employee> findAllEmployees();
    public List<Employee> findEmployeesByManager(Manager manager);
    public boolean deleteEmployee(Long employeeId);
    
}
