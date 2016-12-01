package org.academiadecodigo.model.dao.hibernate;

import org.academiadecodigo.model.User;
import org.academiadecodigo.model.dao.UserDao;
import org.academiadecodigo.persistence.hibernate.HibernateSessionManager;
import org.hibernate.Session;

/**
 * Created by codecadet on 01/12/16.
 */
public class HibernateUserDao implements UserDao {

    @Override
    public void create(User user) {
        Session session = HibernateSessionManager.getSession();
        session.save(user);
    }

    @Override
    public User findByName(String username) {


        return null;
    }

    @Override
    public void delete() {

    }
}
