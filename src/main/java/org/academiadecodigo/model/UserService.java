package org.academiadecodigo.model;

/**
 * Created by codecadet on 15/11/16.
 */
public interface UserService {

    boolean authenticate(String username, String password);

    void addUser(User user);

    User findByName(String username);

    int count();
}
