package fr.rmt.services;

import fr.rmt.entities.Employee;
import fr.rmt.entities.Manager;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Doudoupe
 */
@Local
public interface EmployeeService {

    public void addEmployee(Employee employee);
    public Employee findEmployeeById(Long employeeId);
    public Employee updateEmployee(Employee employee);
    public List<Employee> findAllEmployees();
    public List<Employee> findAllEmployeesByManager(Manager m);
    public boolean deleteEmployee(Long employeeId);
    
}
