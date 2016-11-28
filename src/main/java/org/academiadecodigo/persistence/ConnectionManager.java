package org.academiadecodigo.persistence;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by codecadet on 28/11/16.
 */
public class ConnectionManager {

    private String dbURL;
    private String user;
    private String pass;

    Connection connection = null;

    public Connection getConnection() {

        try {
            if (connection == null) {
                connection = DriverManager.getConnection(dbURL, user, pass);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return connection;
    }

    public void close() {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

}
