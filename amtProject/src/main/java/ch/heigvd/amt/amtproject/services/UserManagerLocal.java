/**
 * @Authors : Melly Calixte And Saam Frederic
 * @Name : UserManagerLocal.java
 * @Description : Business layer for the User
 * @Version 1.0
 **/
package ch.heigvd.amt.amtproject.services;

import ch.heigvd.amt.amtproject.model.User;
import java.util.List;
import javax.ejb.Local;

@Local
public interface UserManagerLocal {

    User findUserById(long userId);

    List<User> findAllUser();

    long createUser(User user);

    void updateUser(User user);

    void deleteUser(long userId);
    
}
