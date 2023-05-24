package controllers;


import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Window;

public class LoginController {



    @FXML
    private TextField usernameField;

    @FXML
    private Button signupButton;

    @FXML
    private Button loginButton;

    @FXML
    private PasswordField passwordField;


    @FXML
    void loginAction() {
        if (usernameField.getText().equals("ahmad") && passwordField.getText().equals("123456")) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Alert Message");
            alert.setHeaderText(null);
            alert.setContentText("welcome");

            // Display the alert dialog
            alert.showAndWait();
        }else {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Alert Message");
            alert.setHeaderText(null);
            alert.setContentText("the username or password not vailed");

            // Display the alert dialog
            alert.showAndWait();
        }
    }

    @FXML
    void signupAction() {

    }
}
