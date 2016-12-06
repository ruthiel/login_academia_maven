package org.academiadecodigo.model.dao.hibernate;

import org.academiadecodigo.model.Role;
import org.academiadecodigo.model.dao.RoleDao;
import org.academiadecodigo.persistence.TransactionException;
import org.academiadecodigo.persistence.hibernate.HibernateSessionManager;
import org.hibernate.HibernateException;
import org.hibernate.criterion.Restrictions;

import java.util.List;

/**
 * Created by codecadet on 01/12/16.
 */
public class HibernateRoleDao extends HibernateDao<Role> implements RoleDao {

    public HibernateRoleDao(HibernateSessionManager sessionManager) {
        super(Role.class, sessionManager);
    }


    @Override
    public Role findByName(String type) {

        try {

            List<Role> roles = hibernateSessionManager.getSession().createCriteria(Role.class)
                    .add(Restrictions.eq("type", type))
                    .list();

            return roles.isEmpty() ? null : roles.get(0);

        } catch (HibernateException hex) {
            throw new TransactionException(hex);
        }

    }

    @Override
    public List<Role> findAll(String name) {
        return null;
    }
}
