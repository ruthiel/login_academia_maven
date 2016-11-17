
    package org.academiadecodigo.controller;

    import javafx.event.ActionEvent;
    import javafx.fxml.FXML;
    import javafx.fxml.FXMLLoader;
    import javafx.fxml.Initializable;
    import javafx.scene.Parent;
    import javafx.scene.control.Button;
    import javafx.scene.control.Label;
    import javafx.scene.control.PasswordField;
    import javafx.scene.control.TextField;
    import javafx.scene.image.ImageView;
    import javafx.scene.layout.GridPane;
    import javafx.scene.layout.Pane;
    import javafx.scene.layout.VBox;
    import org.academiadecodigo.model.Navigation;
    import org.academiadecodigo.model.User;
    import org.academiadecodigo.model.UserService;

    import java.net.URL;
    import java.util.ResourceBundle;


    public class LoginController implements Initializable {

        @FXML
        private VBox vbox;

        @FXML
        private Pane imagepane;

        @FXML
        private ImageView image;

        @FXML
        private GridPane gridpane;

        @FXML
        private Label user;

        @FXML
        private Label password;


        @FXML
        private Label email;

        @FXML
        private PasswordField passfield;

        @FXML
        private TextField textfielduser;

        @FXML
        private TextField textfieldemail;

        @FXML
        private Pane buttonpane;

        @FXML
        private Button loginbutton;

        @FXML
        private Button registerbutton;

        @FXML
        private Label message;

        private UserService userService;

        private boolean isLoginMode;

        @FXML
        void loginPressed(ActionEvent event) {
            if (isLoginMode) {
                doLogin();
            } else {
                doRegister();
            }


        }

        @FXML
        void registerPressed(ActionEvent event) {
            if (isLoginMode) {
                showRegister();
            } else {
                showLogin();
            }
        }



        private void showLogin() {
            isLoginMode = true;
            email.setVisible(false);
            textfieldemail.setVisible(false);
            message.setText("Enter your credentials");
        }

        private void showRegister() {
            isLoginMode = false;
            registerbutton.setVisible(false);
            loginbutton.setText("Create");
            email.setVisible(true);
            textfieldemail.setVisible(true);
            message.setText("Choose your username, password and e-mail");

        }

        private void doLogin() {
            if(userService.authenticate(textfielduser.getText(), passfield.getText())) {
                Navigation.getInstance().back();
            }
        }

        private void doRegister() {
            //verification of empty field and duplicate user
            if(textfielduser.getText().isEmpty() || userService.findByName(textfielduser.getText()) != null) {
                message.setText("Error in UserName");
                return;
            }




            userService.addUser(new User(textfielduser.getText(), textfieldemail.getText(), passfield.getText()));
            message.setText("Sucess");

        }

        public void setUserService(UserService userService) {
            this.userService = userService;
        }


        @Override
        public void initialize(URL location, ResourceBundle resources) {
            showLogin();

        }
    }

