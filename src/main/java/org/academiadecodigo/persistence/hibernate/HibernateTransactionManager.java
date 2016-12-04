package org.academiadecodigo.persistence.hibernate;

import org.academiadecodigo.persistence.TransactionManager;
import org.hibernate.Session;

/**
 * Created by codecadet on 01/12/16.
 */
public class HibernateTransactionManager implements TransactionManager {





    @Override
    public void begin() {
        HibernateSessionManager.beginTransaction();
    }

    @Override
    public void commit() {
        HibernateSessionManager.commitTransaction();
    }

    @Override
    public void rollBack() {
        HibernateSessionManager.rollBackTransaction();
    }
}
