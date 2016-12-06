package org.academiadecodigo.model.dao.hibernate;

import org.academiadecodigo.model.dao.Dao;
import org.academiadecodigo.persistence.TransactionException;
import org.academiadecodigo.persistence.hibernate.HibernateSessionManager;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Projections;

import java.util.List;

/**
 * Created by codecadet on 05/12/16.
 */
public abstract class HibernateDao<O> implements Dao<O> {

    private Class<O> type;
    private HibernateSessionManager sessionManager;

    public HibernateDao(Class<O> type, HibernateSessionManager sessionManager) {
        this.type = type;
        this.sessionManager = sessionManager;
    }

    public void create(O object) {

        try {

            Session session = HibernateSessionManager.getSession();
            session.save(object);

        } catch (HibernateException hex) {
            throw new TransactionException(hex);
        }
    }

    public void delete(O object) {

        try {

        Session session = HibernateSessionManager.getSession();
        session.delete(object);

        } catch (HibernateException hex) {
            throw new TransactionException(hex);
        }
    }

    @SuppressWarnings("unchecked")
    public List<O> findAll() {

        try {

            return HibernateSessionManager.getSession().createCriteria(type).list();

        } catch (HibernateException hex) {
            throw new TransactionException(hex);
        }

    }


    @Override
    public long count() {

        try {

            return (long) HibernateSessionManager.getSession().createCriteria(type)
                    .setProjection(Projections.rowCount())
                    .uniqueResult();

        } catch (HibernateException hex) {
            throw new TransactionException(hex);
        }
    }

}
