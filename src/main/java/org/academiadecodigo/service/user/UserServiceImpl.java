package org.academiadecodigo.service.user;

import org.academiadecodigo.model.User;
import org.academiadecodigo.model.dao.RoleDao;
import org.academiadecodigo.model.dao.UserDao;
import org.academiadecodigo.persistence.TransactionManager;
import org.hibernate.HibernateException;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by codecadet on 01/12/16.
 */
@Transactional
public class UserServiceImpl implements UserService {
    private UserDao userDao;
    private RoleDao roleDao;

    public UserServiceImpl(UserDao userDao, RoleDao roleDao) {
        this.userDao = userDao;
        this.roleDao = roleDao;
    }

    @Override
    public boolean authenticate(String username, String password) {

        User currentUser = findByName(username);
        if (currentUser == null) {
            return false;
        }

        return currentUser.getPassword().equals(password);
    }

    @Override
    public void addUser(User user) {

        if (userDao.findByName(user.getUsername()) == null) {
            userDao.create(user);
            System.out.println("added a new user" + user.getUsername());
        }

    }

    @Override
    public User findByName(String username) {

        User u = userDao.findByName(username);

        return u;

    }

    // TODO: 01/12/16 fazer count
    @Override
    public int count() {
        return 0;
    }

    @Override
    public String getServiceName() {
        return UserService.class.getSimpleName();
    }

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    public void setRoleDao(RoleDao roleDao) {
        this.roleDao = roleDao;
    }
}
