package org.academiadecodigo.model.dao.hibernate;

import org.academiadecodigo.model.Role;
import org.academiadecodigo.model.dao.RoleDao;
import org.academiadecodigo.persistence.hibernate.HibernateSessionManager;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import java.util.List;

/**
 * Created by codecadet on 01/12/16.
 */
public class HibernateRoleDao extends HibernateDao<Role> implements RoleDao {

    public HibernateRoleDao() {
        super(Role.class);
    }


    @Override
    public Role findByName(String type) {

        try {

            List<Role> = HibernateSessionManager.getSession().createCriteria(type)
                    .add(Restrictions.eq( type))
        }

//        Session session = HibernateSessionManager.getSession();
//        Query query = session.createQuery("FROM Role WHERE type_role = :type_role ");
//
//        query.setString("type_role", type);
//
//        Role role = (Role) query.uniqueResult();
//
//        return role;

}
