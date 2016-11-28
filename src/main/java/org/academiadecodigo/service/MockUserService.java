package org.academiadecodigo.service;

import org.academiadecodigo.model.User;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by codecadet on 15/11/16.
 */
public class MockUserService implements UserService {

    private List<User> list;
    public MockUserService() {
        list = new ArrayList<>();
    }

    @Override
    public boolean authenticate(String username, String password) {
        for (int i = 0; i < list.size(); i++) {
            if(list.get(i).getUsername().equals(username) || list.get(i).getPassword().equals(password) ) {
                System.out.println("Authentication of " + username + " succeed!");
                return true;
            }
        }
        return false;
    }

    @Override
    public void addUser(User user) {
       if ((findByName(user.getUsername()) != null)) {
           System.out.println("This user already exists!");
           return;
       }
        System.out.println("User " + user.getUsername() + " added!");
           list.add(user);
    }

    @Override
    public User findByName(String username) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getUsername().equals(username)) {
                return list.get(i);
            }
        }
        return null;
    }


    @Override
    public int count() {
        return list.size();
    }

    public void printList() {
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i).getUsername());
        }
    }
}
