package org.academiadecodigo.model.dao.hibernate;

import org.academiadecodigo.model.User;
import org.academiadecodigo.model.dao.UserDao;
import org.academiadecodigo.persistence.TransactionException;
import org.academiadecodigo.persistence.hibernate.HibernateSessionManager;
import org.hibernate.HibernateException;
import org.hibernate.criterion.Restrictions;

import java.util.List;

/**
 * Created by codecadet on 01/12/16.
 */
public class HibernateUserDao extends HibernateDao<User> implements UserDao {

    public HibernateUserDao(HibernateSessionManager sessionManager) {
        super((User.class), sessionManager);
    }

    @Override
    public User findByName(String name) {

        try {
            List<User> users = HibernateSessionManager.getSession()
                    .createCriteria(User.class)
                    .add(Restrictions.eq("username", name))
                    .list();

            return users.isEmpty() ? null : users.get(0);

        } catch (HibernateException hex) {
            throw new TransactionException(hex);
        }
    }

    @Override
    public List<User> findAll(String name) {
        return null;
    }
}
