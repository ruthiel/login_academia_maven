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

    private static SessionFactory sessionFactory;

    private HibernateSessionManager() {

    }

    static {
        try {

            ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();

            sessionFactory = new MetadataSources(serviceRegistry).buildMetadata().buildSessionFactory();

        } catch (HibernateException ex) {
            ex.printStackTrace();
            throw new ExceptionInInitializerError("Error creating hibernate session factory: " + ex.getMessage());
        }
    }

    public static Session getSession() {
        return sessionFactory.getCurrentSession();
    }

    public static void close() {
        sessionFactory.close();
    }

    public static Session beginTransaction() {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();

        return session;
    }

    public static void commitTransaction() {
        sessionFactory.getCurrentSession().getTransaction().commit();

    }

    public static void rollBackTransaction() {
        sessionFactory.getCurrentSession().getTransaction().rollback();
    }

}
