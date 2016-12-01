package org.academiadecodigo.service.user;

import org.academiadecodigo.model.User;

/**
 * Created by codecadet on 01/12/16.
 */
public class HibernateUserService implements UserService {
    @Override
    public boolean authenticate(String username, String password) {
        return false;
    }

    @Override
    public void addUser(User user) {

    }

    @Override
    public User findByName(String username) {
        return null;
    }

    @Override
    public int count() {
        return 0;
    }

    @Override
    public String getServiceName() {
        return null;
    }
}
