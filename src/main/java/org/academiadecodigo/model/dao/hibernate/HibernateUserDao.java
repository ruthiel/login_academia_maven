package org.academiadecodigo.model.dao.hibernate;

import org.academiadecodigo.model.User;
import org.academiadecodigo.model.dao.UserDao;
import org.academiadecodigo.persistence.hibernate.HibernateSessionManager;
import org.hibernate.Query;
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
        Session session = HibernateSessionManager.getSession();
        Query query = session.createQuery("FROM User WHERE username = :username");
        query.setString("username", username);

        User user = (User)query.uniqueResult();

        return user;
    }

    @Override
    public void delete(User user) {
        Session session = HibernateSessionManager.getSession();
        session.delete(user);

    }
}
