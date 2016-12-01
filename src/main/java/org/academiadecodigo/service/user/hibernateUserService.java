package org.academiadecodigo.service.user;

import org.academiadecodigo.model.User;
import org.academiadecodigo.persistence.hibernate.HibernateSessionManager;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 * Created by codecadet on 01/12/16.
 */
public class HibernateUserService implements UserService {

    @Override
    public boolean authenticate(String username, String password) {

        try {
            Session session = HibernateSessionManager.beginTransaction();
            Query query = session.createQuery("FROM User WHERE username");


            HibernateSessionManager.commitTransaction();
            return true;

        } catch (HibernateException e) {
            HibernateSessionManager.rollBackTransaction();
        }

        return false;
    }

    @Override
    public void addUser(User user) {

        try {
            Session session = HibernateSessionManager.beginTransaction();
            session.save(user);
            HibernateSessionManager.commitTransaction();

        } catch (HibernateException ex) {
            HibernateSessionManager.rollBackTransaction();
            System.out.println("Error: " + ex.getStackTrace());


        }

    }

    @Override
    public User findByName(String username) {

        User user = null;

        try {
            Session session = HibernateSessionManager.beginTransaction();
            Query query = session.createQuery("FROM User WHERE username = :username");
            query.setString("username", username);

            user = (User) query.uniqueResult();

            HibernateSessionManager.commitTransaction();

        } catch (HibernateException ex) {
            HibernateSessionManager.rollBackTransaction();
            System.out.println("Error : " + ex.getMessage());

        } finally {
            HibernateSessionManager.close();
        }

        return user;
    }

    @Override
    public int count() {

        return 0;
    }

    @Override
    public String getServiceName() {
        return "userservice";
    }
}
