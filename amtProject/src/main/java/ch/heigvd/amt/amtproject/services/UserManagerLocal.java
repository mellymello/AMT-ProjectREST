/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.heigvd.amt.amtproject.services;

import ch.heigvd.amt.amtproject.model.User;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Calixte
 */
@Local
public interface UserManagerLocal {

    User findUserById(long userId);

    List<User> findAllUser();

    long createUser(User user);

    void updateUser(User user);

    void deleteUser(long userId);
    
}
