package fr.rmt.controllers;

import fr.rmt.entities.Employee;
import fr.rmt.entities.Manager;
import fr.rmt.entities.UserRMT;
import fr.rmt.services.LoginService;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Doudoupe
 */
@ManagedBean(name="loginController")
@SessionScoped
public class LoginController implements Serializable {

    @EJB
    LoginService loginService;
    
    // L'utilisation d'un objet de type UserRMT pour binder les champs du 
    // formulaire est aussi possible. La présente solution permet de mieux
    // distinguer les éléments et l'utilité de ces derniers.
    private String username;
    private String password;
    private UserRMT loggedUser;

    // Initialisation de l'utilisateur (correspondant aux champs de login)
//    public LoginController() {
//        this.loginUser = new UserRMT();
//    }
    
    // Logic methods

    public String login() {

        UserRMT testedUser = loginService.findUserByUsername(username);

        // Si user trouvé en BDD
        if (testedUser != null) {
            
            //Check password
            if (password.equals(testedUser.getPassword())) {
                
                // Check "role"
                if(testedUser instanceof Manager) {
                    // Ajout en session
                    this.loggedUser = testedUser;
                    return "login_success_manager";
                } else if(testedUser instanceof Employee) {
                    // Ajout en session
                    this.loggedUser = testedUser;
                    return "login_success_employee";
                } else {
                    // Add message with FaceMessage : erreur serveur
                    return "login_failed";
                }
                
            } else {
                // Add message with FacesMessage : mdp incorrect
                return "login_failed";
            }
            
        } else {
            // Add message with FacesMessage : email introuvable
            return "login_failed";
        }

    }
    
    public String logout() {
        // loggedUser = null est inutile puisqu'il est détruit lorsque la session est invalidée. C'est une simple précaution.
        loggedUser = null;
        ((HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false)).invalidate();
        // naviguation implicite -> vers page login.xhtml
        return "/pages/public/login";
    }
    
    public String addTwoUsers() {

        boolean added = loginService.populateUsers();
        if (added) {
            return "init_success";
        } else {
            return "init_failed";
        }
    }
    
    // Getters & Setters
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

    public UserRMT getLoggedUser() {
        return loggedUser;
    }

    public void setLoggedUser(UserRMT loggedUser) {
        this.loggedUser = loggedUser;
    }
}
