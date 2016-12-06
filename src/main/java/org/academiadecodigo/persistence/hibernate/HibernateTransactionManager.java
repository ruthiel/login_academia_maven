package org.academiadecodigo.persistence.hibernate;

import org.academiadecodigo.persistence.TransactionManager;
import org.hibernate.Session;

/**
 * Created by codecadet on 01/12/16.
 */
public class HibernateTransactionManager implements TransactionManager {

    private HibernateSessionManager sessionManager;

    public HibernateTransactionManager(HibernateSessionManager sessionManager) {
        this.sessionManager = sessionManager;
    }

    @Override
    public void begin() {
        sessionManager.beginTransaction();
    }

    @Override
    public void commit() {
        sessionManager.commitTransaction();
    }

    @Override
    public void rollBack() {
        sessionManager.rollBackTransaction();
    }

    public void setSessionManager(HibernateSessionManager sessionManager) {
        this.sessionManager = sessionManager;
    }

}
