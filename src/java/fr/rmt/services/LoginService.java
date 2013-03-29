package fr.rmt.services;

import fr.rmt.entities.UserRMT;
import javax.ejb.Local;

/**
 *
 * @author Doudoupe
 */
@Local
public interface LoginService {

    public UserRMT findUserByUsername(String username);
    public boolean populateUsers();
    
}
