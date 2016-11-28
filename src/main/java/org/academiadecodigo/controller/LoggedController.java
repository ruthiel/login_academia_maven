package org.academiadecodigo.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import org.academiadecodigo.Navigation;
import org.academiadecodigo.service.ServiceRegistry;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by codecadet on 16/11/16.
 */
public class LoggedController implements Initializable {

    @FXML
    private Pane login_pane_image;

    @FXML
    private ImageView login_image;

    @FXML
    private Pane login_pane_message;

    @FXML
    private Label login_message;

    @FXML
    private Pane login_button_pane;

    @FXML
    private Button button_back;

    @FXML
    void backPressed(ActionEvent event) {
        Navigation.getInstance().back();
    }

    public void showLoggedScreen() {
        login_message.setText("Bem-vindo à Academia!");
    }



    @Override
    public void initialize(URL location, ResourceBundle resources) {
        showLoggedScreen();

    }


}
