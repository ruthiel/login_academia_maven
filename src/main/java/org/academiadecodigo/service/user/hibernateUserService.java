package org.academiadecodigo.service.user;

import org.academiadecodigo.model.User;
import org.academiadecodigo.persistence.hibernate.HibernateSessionManager;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by codecadet on 01/12/16.
 */
public class HibernateUserService implements UserService {

    private HibernateSessionManager hibernateSessionManager;

    @Transactional
    @Override
    public boolean authenticate(String username, String password) {

        try {
            Session session = hibernateSessionManager.beginTransaction();
            //Query query = session.createQuery("FROM User WHERE username");


            hibernateSessionManager.commitTransaction();
            return true;

        } catch (HibernateException e) {
            hibernateSessionManager.rollBackTransaction();
        }

        return false;
    }

    @Override
    public void addUser(User user) {

        try {
            Session session = hibernateSessionManager.beginTransaction();
            session.save(user);
            hibernateSessionManager.commitTransaction();

        } catch (HibernateException ex) {
            hibernateSessionManager.rollBackTransaction();
            System.out.println("Error: " + ex.getStackTrace());


        }

    }

    @Override
    public User findByName(String username) {

        User user = null;

        try {
            Session session = hibernateSessionManager.beginTransaction();
            Query query = session.createQuery("FROM User WHERE username = :username");
            query.setString("username", username);

            user = (User) query.uniqueResult();

            hibernateSessionManager.commitTransaction();

        } catch (HibernateException ex) {
            hibernateSessionManager.rollBackTransaction();
            System.out.println("Error : " + ex.getMessage());

        } finally {
            hibernateSessionManager.close();
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
