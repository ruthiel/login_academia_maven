package org.academiadecodigo.model.dao;

import org.academiadecodigo.model.Role;
import org.academiadecodigo.model.User;

/**
 * Created by codecadet on 01/12/16.
 */
public interface RoleDao extends Dao<Role> {


    Role findByName(String name);

}
