package org.academiadecodigo.service.user;

import org.academiadecodigo.model.User;
import org.academiadecodigo.persistence.ConnectionManager;
import org.academiadecodigo.service.Service;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by codecadet on 28/11/16.
 */
public class JdbcUserService implements UserService {

    private ConnectionManager manager;
    private Connection dbConnection;

    public JdbcUserService(ConnectionManager manager) {
        this.manager = manager;
        dbConnection = manager.getConnection();
    }

    public void checkConnection() {
        try {
            if (dbConnection == null || dbConnection.isClosed()) {
                dbConnection = manager.getConnection();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        if (dbConnection == null) {
            throw new IllegalStateException("Error connecting to database!");
        }
    }

    @Override
    public boolean authenticate(String username, String password) {

        boolean toReturn = false;

        checkConnection();

        Statement statement = null;

        try {
            dbConnection.setAutoCommit(false);
            statement = dbConnection.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        String query = "SELECT * FROM users WHERE user_name = \'" + username + "\' AND password = \'" + password + "\';";

        try {
            ResultSet resultSet = statement.executeQuery(query);
            if (resultSet.next()) {
                toReturn = true;
                dbConnection.commit();
            }
        } catch (SQLException e) {
            try {
                dbConnection.rollback();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
        } finally {
            try {
                statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return toReturn;
    }

    @Override
    public void addUser(User user) {

        checkConnection();

        Statement statement = null;
        try {
            dbConnection.setAutoCommit(false);
            statement = dbConnection.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        String query = "INSERT INTO users(user_name, password, user_mail) VALUES (\'" + user.getUsername() + "\', \'" +
                user.getPassword() + "\',\'" + user.getEmail() + "\');";

        try {
            int resultSet = statement.executeUpdate(query);

            if (resultSet == 1) {
                dbConnection.commit();
                System.out.println("User added");
            }
        } catch (SQLException e) {
            try {
                dbConnection.rollback();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
        } finally {
            try {
                statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }



    }

    @Override
    public User findByName(String username) {

        User user = null;

        checkConnection();

        Statement statement = null;

        try {

            dbConnection.setAutoCommit(false);
            statement = dbConnection.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        String query = "SELECT * FROM users WHERE user_name =\'" + username + "\'";

        ResultSet resultSet = null;
        try {
            resultSet = statement.executeQuery(query);
            if (resultSet.next()) {

                String usernameValue = resultSet.getString(2);
                String passwordValue = resultSet.getString(3);
                String emaiValue = resultSet.getString(4);

                user = new User(usernameValue, passwordValue, emaiValue);

                dbConnection.commit();
            }
        } catch (SQLException e) {
            try {
                dbConnection.rollback();
            } catch (SQLException e1) {
                e1.printStackTrace();
            } finally {
                try {
                    statement.close();
                } catch (SQLException e1) {
                    e1.printStackTrace();
                }
            }
        }
        return user;
    }

    @Override
    public int count() {

        checkConnection();

        int result = 0;

        Statement statement = null;
        try {
            dbConnection.setAutoCommit(false);
            statement = dbConnection.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        String query = "SELECT COUNT(*) FROM users";

        ResultSet resultSet = null;
        try {
            resultSet = statement.executeQuery(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        try {
            if (resultSet.next()) {
                result = resultSet.getInt(1);
                dbConnection.commit();
            }
        } catch (SQLException e) {

            try {
                dbConnection.rollback();
            } catch (SQLException e1) {
                e1.printStackTrace();

            } finally {
                try {
                    statement.close();
                } catch (SQLException e1) {
                    e1.printStackTrace();
                }
            }
        }
        return result;
    }


    @Override
    public String getServiceName() {
        return "userService";
    }
}
