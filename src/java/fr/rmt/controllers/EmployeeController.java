/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.rmt.controllers;

import fr.rmt.entities.Employee;
import fr.rmt.entities.Manager;
import fr.rmt.services.EmployeeService;
import java.util.GregorianCalendar;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;

/**
 *
 * @author Doudoupe
 */
@ManagedBean
@RequestScoped
public class EmployeeController {
    
    @EJB
    EmployeeService employeeService;
    
    // permet de référencer le bean loginController 
    // contenant le manager authentifé au moment de l'ajout
    // !!! Getter&Setters obligatoires
    @ManagedProperty(value="#{loginController}")
    LoginController loginController;
    
    // Binding avec le form de add_employee.xhtml
    private String username;
    private String password;
    private String firstname;
    private String lastname;
    private String email;
    private GregorianCalendar birth;
    
    // DataModel utilisé pour le tableau d'employees
    DataModel employeeModel; 

    // Utilisé pour itialisisé la liste d'employée en fonction du manager
    @PostConstruct
    public void init() {
        System.out.println(loginController);
        Manager m = (Manager) loginController.getLoggedUser();
        List<Employee> employees = employeeService.findAllEmployeesByManager(m);
        this.employeeModel = new ListDataModel(employees);
    }
    // Logic methods
    
    public String addEmployee() {
        
        Employee e = new Employee(username, password, firstname, lastname, email, birth, new GregorianCalendar(), (Manager) loginController.getLoggedUser());
        try {
            employeeService.addEmployee(e);
            // Add message : employee ajouté
            return "/pages/logged/manager_home?faces-redirect=true";    // Redirect necessaire pour recharger la vue (forward = meme request)
        } catch(Exception ex) {
            // Add message : erreur (peut venir d'une exeption mysql par ex)
            return "/pages/logged/add_employee";
        }
        
    }
    // Getters & Setters

    public LoginController getLoginController() {
        return loginController;
    }

    public void setLoginController(LoginController loginController) {
        this.loginController = loginController;
    }
    
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public GregorianCalendar getBirth() {
        return birth;
    }

    public void setBirth(GregorianCalendar birth) {
        this.birth = birth;
    }

    public DataModel getEmployeeModel() {
        return employeeModel;
    }

    public void setEmployeeModel(DataModel employeeModel) {
        this.employeeModel = employeeModel;
    }
       
}
