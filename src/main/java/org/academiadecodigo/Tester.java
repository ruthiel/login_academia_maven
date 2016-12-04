package org.academiadecodigo;

import org.academiadecodigo.model.User;
import org.academiadecodigo.model.dao.hibernate.HibernateUserDao;
import org.academiadecodigo.persistence.hibernate.HibernateTransactionManager;
import org.academiadecodigo.service.user.UserService;
import org.academiadecodigo.service.user.UserServiceImpl;

/**
 * Created by codecadet on 01/12/16.
 */
public class Tester {

    public static void main(String[] args) {

        UserService userService = new UserServiceImpl(
                new HibernateUserDao(),
                new HibernateTransactionManager());

        System.out.println("trying to add Ruthiel");
        userService.addUser(new User("Ruthiel", "ruthiel@", "123456"));

        System.out.println("trying to add Sofia");
        userService.addUser(new User("Sofia", "sofia@", "1223456"));

        System.out.println("trying to find Sofia");
        System.out.println(userService.findByName("Sofia"));

        System.out.println("trying to find ruthiel");
        System.out.println(userService.findByName("Ruthiel"));
    }
}
