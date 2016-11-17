package org.academiadecodigo.model;

import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * Created by codecadet on 16/11/16.
 */
public final class Navigation {

    public static Navigation instance = null;
    private LinkedList<Scene> scenes = new LinkedList<Scene>();
    private Map<String, Initializable> controllers = new HashMap<>();
    private Stage stage;
    private Scene scene;


    private final String PATH = "";

    private Navigation() {
    }

    public static synchronized Navigation getInstance() {

        if (instance == null) {
            instance = new Navigation();
        }
        return instance;
    }


    public void loadScreen(String view) {
        try {
            FXMLLoader fxmlLoader;
            System.out.println(PATH + "/" + view);
            fxmlLoader = new FXMLLoader(getClass().getResource(PATH + "/" + view + ".fxml"));
            Parent root = fxmlLoader.load();
            controllers.put(view, (Initializable)fxmlLoader.getController());

            Scene scene = new Scene(root);
            scenes.push(scene);
            setScene(scene);

        } catch (IOException e) {
            System.out.println("Failure to load view " + view + " : " + e.getMessage());
        }
    }

    public void back() {
        if (scenes.isEmpty()) {
            scenes.pop();
            setScene(scenes.peek());
        }
    }


    public void setStage(Stage stage) {
        this.stage = stage;
    }

    public void setScene(Scene scene) {
        stage.setScene(scene);
        stage.show();
    }

    public Initializable getController(String view) {
        return controllers.get(view);
    }
}
