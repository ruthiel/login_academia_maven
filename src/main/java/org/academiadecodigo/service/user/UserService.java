package org.academiadecodigo.service.user;

import org.academiadecodigo.model.User;
import org.academiadecodigo.service.Service;

/**
 * Created by codecadet on 15/11/16.
 */
public interface UserService extends Service {

    boolean authenticate(String username, String password);

    void addUser(User user);

    User findByName(String username);

    int count();
}
