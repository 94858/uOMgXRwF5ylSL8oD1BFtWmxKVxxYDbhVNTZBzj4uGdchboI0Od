/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.rmt.servicesImpl;

import fr.rmt.dao.UserRMTDao;
import fr.rmt.entities.UserRMT;
import fr.rmt.services.LoginService;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author Doudoupe
 */
@Stateless
public class LoginServiceImpl implements LoginService {

    @EJB
    UserRMTDao userDao;
    
    @Override
    public UserRMT findUserByUsername(String username) {
        return userDao.findUserByUsername(username);
    }

    @Override
    public boolean populateUsers() {
        return userDao.populateUsers();
    }
}
