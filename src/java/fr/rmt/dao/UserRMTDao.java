package fr.rmt.dao;

import fr.rmt.entities.UserRMT;
import javax.ejb.Local;

/**
 *
 * @author Doudoupe
 */
@Local
public interface UserRMTDao {
     public UserRMT findUserByUsername(String username);
     public boolean populateUsers();
}
