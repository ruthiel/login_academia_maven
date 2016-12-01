package org.academiadecodigo;

import javafx.application.Application;
import javafx.stage.Stage;
import org.academiadecodigo.model.dao.hibernate.HibernateRoleDao;
import org.academiadecodigo.model.dao.hibernate.HibernateUserDao;
import org.academiadecodigo.persistence.hibernate.HibernateSessionManager;
import org.academiadecodigo.persistence.hibernate.HibernateTransactionManager;
import org.academiadecodigo.persistence.jdbc.ConnectionManager;
import org.academiadecodigo.service.ServiceRegistry;
import org.academiadecodigo.service.user.HibernateUserService;
import org.academiadecodigo.service.user.UserService;
import org.academiadecodigo.service.user.UserServiceImpl;

public class Main extends Application {

    private ConnectionManager connectionManager;
    private UserService userService;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void init() {

        UserService userService = new UserServiceImpl(
                new HibernateUserDao(),
                new HibernateRoleDao(),
                new HibernateTransactionManager());

        ServiceRegistry.getServiceRegistry()
                .registerService(UserService.class.getSimpleName(), userService);

    }

    @Override
    public void start(Stage primaryStage) {

        Navigation navigation = Navigation.getInstance();
        navigation.setStage(primaryStage);

        Navigation.getInstance().loadScreen("login");

        primaryStage.setTitle("Academia de Código");
        primaryStage.show();

    }

    @Override
    public void stop() {
        HibernateSessionManager.close();
    }
}



