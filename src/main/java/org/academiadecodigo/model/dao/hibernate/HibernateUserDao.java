package org.academiadecodigo.model.dao.hibernate;

import org.academiadecodigo.model.User;
import org.academiadecodigo.model.dao.UserDao;
import org.academiadecodigo.persistence.hibernate.HibernateSessionManager;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 * Created by codecadet on 01/12/16.
 */
public class HibernateUserDao extends HibernateDao<User> implements UserDao {

    public HibernateUserDao(Class<User> type) {
        super(type);
    }

    @Override
    public User findByName(User user) {
        return null;
    }
}
