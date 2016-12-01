package org.academiadecodigo.service.user;

import org.academiadecodigo.model.User;
import org.academiadecodigo.model.dao.RoleDao;
import org.academiadecodigo.model.dao.UserDao;
import org.academiadecodigo.persistence.TransactionManager;
import org.hibernate.HibernateException;

/**
 * Created by codecadet on 01/12/16.
 */
public class UserServiceImpl implements UserService {

    private TransactionManager transactionManager;
    private UserDao userDao;
    private RoleDao roleDao;

    public UserServiceImpl(TransactionManager transactionManager, UserDao userDao, RoleDao roleDao) {
        this.transactionManager = transactionManager;
        this.userDao = userDao;
        this.roleDao = roleDao;
    }

    @Override
    public boolean authenticate(String username, String password) {

        try {

            transactionManager.begin();
            User currentUser = findByName(username);

            if (currentUser == null) {

                return false;
            }

            transactionManager.commit();

            return currentUser.getPassword().equals(password);

        } catch (HibernateException ex) {
            transactionManager.rollBack();
        }

        return false;
    }

    @Override
    public void addUser(User user) {

        try {

            transactionManager.begin();

            if (userDao.findByName(user.getUsername()) == null) {
                userDao.create(user);
            }

            transactionManager.commit();

        } catch (HibernateException ex) { // TODO: 01/12/16 change the exception
            transactionManager.rollBack();
        }
    }

    @Override
    public User findByName(String username) {

        try {
            transactionManager.begin();
            userDao.findByName(username);

            transactionManager.commit();

        } catch (HibernateException ex) {
            transactionManager.rollBack();
        }

        return null;
    }

    @Override
    public int count() {

    }

    @Override
    public String getServiceName() {
        return null;
    }
}
