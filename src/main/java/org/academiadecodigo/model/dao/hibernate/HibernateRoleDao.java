package org.academiadecodigo.model.dao.hibernate;

import org.academiadecodigo.model.Role;
import org.academiadecodigo.model.User;
import org.academiadecodigo.model.dao.RoleDao;

/**
 * Created by codecadet on 01/12/16.
 */
public class HibernateRoleDao extends HibernateDao<Role> implements RoleDao {


    @Override
    public Role findByName(String name) {
        return null;
    }
}
