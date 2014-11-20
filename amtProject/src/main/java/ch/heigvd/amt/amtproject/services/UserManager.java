/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.heigvd.amt.amtproject.services;

import ch.heigvd.amt.amtproject.model.User;
import java.util.List;
import javax.ejb.Stateless;

/**
 *
 * @author Calixte
 */
@Stateless
public class UserManager implements UserManagerLocal {

    @Override
    public User findUserById(long userId) {
        return null;
    }

    @Override
    public List<User> findAllUser() {
        return null;
    }

    @Override
    public long createUser(User user) {
        return 0L;
    }

    @Override
    public void updateUser(User user) {
    }

    @Override
    public void deleteUser(long userId) {
    }
      
    
}
