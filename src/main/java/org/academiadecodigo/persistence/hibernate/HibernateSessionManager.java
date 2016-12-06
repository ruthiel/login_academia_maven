package org.academiadecodigo.persistence.hibernate;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.service.ServiceRegistry;

/**
 * Created by codecadet on 29/11/16.
 */
public class HibernateSessionManager {

    private SessionFactory sessionFactory;

    private HibernateSessionManager() {

    }

    public Session getSession() {
        return sessionFactory.getCurrentSession();
    }

    public void close() {
        sessionFactory.close();
    }

    public Session beginTransaction() {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();

        return session;
    }

    public void commitTransaction() {
        sessionFactory.getCurrentSession().getTransaction().commit();

    }

    public void rollBackTransaction() {
        sessionFactory.getCurrentSession().getTransaction().rollback();
    }


    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
}
