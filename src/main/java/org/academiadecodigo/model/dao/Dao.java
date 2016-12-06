package org.academiadecodigo.model.dao;

import org.academiadecodigo.model.User;

import java.util.List;

/**
 * Created by codecadet on 05/12/16.
 */
public interface Dao<O> {

    void create(O object);

    List<O> findAll(String name);

    void delete(O object);

    long count();
}
