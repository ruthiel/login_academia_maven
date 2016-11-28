package org.academiadecodigo;

import javafx.application.Application;
import javafx.stage.Stage;
import org.academiadecodigo.controller.LoginController;
import org.academiadecodigo.model.User;
import org.academiadecodigo.persistence.ConnectionManager;
import org.academiadecodigo.service.ServiceRegistry;
import org.academiadecodigo.service.user.JdbcUserService;
import org.academiadecodigo.service.user.UserService;

public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void init() {

        ConnectionManager connectionManager = new ConnectionManager();

        UserService userService = new JdbcUserService(connectionManager);
//        userService.addUser(new User("Ruthiel Trevisan", "ruthiel.trevisan@gmail.com", "qwerty"));

        ServiceRegistry.getInstance().addService(userService);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        Navigation.getInstance().setStage(primaryStage);
        Navigation.getInstance().loadScreen("login");





//        ((LoginController)Navigation.getInstance().getController("login")).setUserService(userService);
    }
}



