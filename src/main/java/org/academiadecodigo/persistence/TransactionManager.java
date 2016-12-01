package org.academiadecodigo.persistence;

/**
 * Created by codecadet on 01/12/16.
 */
public interface TransactionManager {

    void begin();

    void commit();

    void rollBack();
}
