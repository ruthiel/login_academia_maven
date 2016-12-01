package org.academiadecodigo.persistence.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by codecadet on 28/11/16.
 */
public class ConnectionManager {

    private static final String DEFAULT_USER = "root";
    private static final String DEFAULT_PASS = "";
    private static final String DEFAULT_HOST = "localhost";
    private static final String DEFAULT_DB = "users";

    private static final String CONNECTOR = "jdbc:mysql:";

    private String dbURL;
    private String user;
    private String pass;
    private Connection connection;


    public ConnectionManager(String user, String pass, String host, String dataBase) {
        this.user = user;
        this.pass = pass;
        this.dbURL = CONNECTOR + "//" + host + "/" + dataBase + "?useSSL=false";
    }

    public ConnectionManager() {
        this(DEFAULT_USER, DEFAULT_PASS, DEFAULT_HOST, DEFAULT_DB);
    }


    public Connection getConnection() {

        try {
            System.out.println("Making Connection...");
            if (connection == null) {
                connection = DriverManager.getConnection(dbURL, user, pass);
            }
        } catch (SQLException e) {
            System.out.println("Fail to connect to DataBase!" + e.getMessage());
        }

        return connection;
    }

    public void close() {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                System.out.println("Fail to close!" +  e.getMessage());
            }
        }
    }

}
