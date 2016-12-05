package org.academiadecodigo.model.dao.hibernate;

import org.academiadecodigo.model.dao.Dao;
import org.academiadecodigo.persistence.hibernate.HibernateSessionManager;
import org.hibernate.Session;

import java.util.List;

/**
 * Created by codecadet on 05/12/16.
 */
public abstract class HibernateDao<O> implements Dao<O> {

    @Override
    public void create(O object) {
        Session session = HibernateSessionManager.getSession();
        session.save(object);
    }

    @Override
    public List<O> findAll(String name) {
        return null;
    }

    @Override
    public void delete(O object) {
        Session session = HibernateSessionManager.getSession();
        session.delete(object);

    }

    @Override
    public void count() {

    }

}
