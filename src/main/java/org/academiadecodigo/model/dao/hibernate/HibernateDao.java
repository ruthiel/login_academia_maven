package org.academiadecodigo.model.dao.hibernate;

import org.academiadecodigo.model.dao.Dao;
import org.academiadecodigo.persistence.hibernate.HibernateSessionManager;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.TransactionException;
import org.hibernate.criterion.Projections;

import java.util.List;

/**
 * Created by codecadet on 05/12/16.
 */
public abstract class HibernateDao<O> implements Dao<O> {

    private Class<O> type;

    public HibernateDao(Class<O> type) {
        this.type = type;
    }

    public void create(O object) {

        Session session = HibernateSessionManager.getSession();
        session.save(object);
    }

    public void delete(O object) {
        Session session = HibernateSessionManager.getSession();
        session.delete(object);

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

            return (Long) HibernateSessionManager.getSession().createCriteria(type)
                    .setProjection(Projections.rowCount())
                    .uniqueResult();

        } catch (HibernateException hex) {
            throw new TransactionException(hex);
        }
    }

}
