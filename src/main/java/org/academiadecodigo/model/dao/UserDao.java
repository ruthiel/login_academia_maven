package org.academiadecodigo.model.dao;

import org.academiadecodigo.model.User;

/**
 * Created by codecadet on 01/12/16.
 */
public interface UserDao {

    void create(User user);

    User findByName(String username);

    void delete(User user);
}
