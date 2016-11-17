package org.academiadecodigo;

import javafx.application.Application;
import javafx.stage.Stage;
import org.academiadecodigo.controller.LoginController;
import org.academiadecodigo.model.MockUserService;
import org.academiadecodigo.model.Navigation;
import org.academiadecodigo.model.User;
import org.academiadecodigo.model.UserService;

public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void init() {
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        Navigation.getInstance().setStage(primaryStage);
        Navigation.getInstance().loadScreen("login");

        UserService userService = new MockUserService();
        userService.addUser(new User("Ruthiel Trevisan", "ruthiel.trevisan@gmail.com", "qwerty"));

        ((LoginController)Navigation.getInstance().getController("login")).setUserService(userService);
    }
}



