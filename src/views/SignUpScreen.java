package views;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

public class SignUpScreen extends Stage {
    private Scene scene;

    private Pane pane;

    private HBox screen;

    private VBox leftSide;

    private ImageView imageView;
    private Image image;
    private VBox rightSide;

    private Label screenName;

    private VBox nameVBox;

    private Label nameLabel;

    private TextField nameField;

    private VBox usernameVBox;

    private Label usernameLabel;

    private TextField usernameField;

    private VBox passwordVBox;

    private Label passwordLabel;

    private PasswordField passwordField;

    private HBox buttonsHBox;

    private Button loginButton;

    private Button signupButton;

    public SignUpScreen() {

        // left side
        image = new Image("resource/images1.png");
        imageView = new ImageView(image);
        imageView.setFitWidth(250);
        imageView.setFitHeight(200);

        leftSide = new VBox(imageView);
        leftSide.setAlignment(Pos.CENTER);
        leftSide.setMinWidth(211);
        leftSide.setMinHeight(500);
        leftSide.setId("leftSide");


        //right side
        screenName = new Label("SignUp");
        screenName.setMinWidth(141);
        screenName.setMinHeight(47);
        screenName.setTextAlignment(TextAlignment.CENTER);
        screenName.setAlignment(Pos.CENTER);
        screenName.setId("screenName");
// name
        nameLabel = new Label("Name");
        nameLabel.setTextAlignment(TextAlignment.LEFT);
        nameLabel.setAlignment(Pos.CENTER_LEFT);
        nameLabel.setMaxWidth(295);
        nameLabel.setMaxHeight(21);
        nameLabel.setStyle("-fx-text-fill: WHITE;");

        nameField = new TextField();
        nameField.setMaxWidth(300);
        nameField.setMaxHeight(38);
        nameField.setAlignment(Pos.CENTER_LEFT);
        nameField.setId("inputField");

        nameVBox = new VBox(nameLabel,nameField);
        nameVBox.setAlignment(Pos.CENTER);
        nameVBox.setMinWidth(470);
        nameVBox.setMinHeight(105);
        nameVBox.setPadding(new Insets(10));
        nameVBox.setSpacing(5);
        // username
        usernameLabel = new Label("Username");
        usernameLabel.setTextAlignment(TextAlignment.LEFT);
        usernameLabel.setAlignment(Pos.CENTER_LEFT);
        usernameLabel.setMaxWidth(295);
        usernameLabel.setMaxHeight(21);
        usernameLabel.setStyle("-fx-text-fill: WHITE;");

        usernameField = new TextField();
        usernameField.setMaxWidth(300);
        usernameField.setMaxHeight(38);
        usernameField.setAlignment(Pos.CENTER_LEFT);
        usernameField.setId("inputField");

        usernameVBox = new VBox(usernameLabel,usernameField);
        usernameVBox.setAlignment(Pos.CENTER);
        usernameVBox.setMinWidth(470);
        usernameVBox.setMinHeight(105);
        usernameVBox.setPadding(new Insets(0,10,10,10));
        usernameVBox.setSpacing(5);

// password
        passwordLabel = new Label("Password");
        passwordLabel.setTextAlignment(TextAlignment.LEFT);
        passwordLabel.setAlignment(Pos.CENTER_LEFT);
        passwordLabel.setMaxWidth(295);
        passwordLabel.setMaxHeight(21);
        passwordLabel.setStyle("-fx-text-fill: WHITE;");

        passwordField = new PasswordField();
        passwordField.setMaxWidth(300);
        passwordField.setMaxHeight(38);
        passwordField.setAlignment(Pos.CENTER_LEFT);
        passwordField.setId("inputField");

        passwordVBox = new VBox(passwordLabel,passwordField);
        passwordVBox.setAlignment(Pos.CENTER);
        passwordVBox.setMinWidth(470);
        passwordVBox.setMinHeight(77);
        passwordVBox.setPadding(new Insets(0, 10, 10, 10));
        passwordVBox.setSpacing(5);

// buttons
        loginButton = new Button("Login");
        loginButton.setPadding(new Insets(10, 30, 10, 30));
        loginButton.setMinWidth(130);
        loginButton.setMinHeight(41);
        loginButton.setAlignment(Pos.CENTER);
        loginButton.setId("signupButton");

        signupButton = new Button("SignUp");
        signupButton.setPadding(new Insets(10, 30, 10, 30));
        signupButton.setMinWidth(130);
        signupButton.setMinHeight(41);
        signupButton.setAlignment(Pos.CENTER);
        signupButton.setId("loginButton");

        buttonsHBox = new HBox(signupButton,loginButton);
        buttonsHBox.setAlignment(Pos.CENTER);
        buttonsHBox.setMinWidth(470);
        buttonsHBox.setMinHeight(100);
        buttonsHBox.setSpacing(10);
// rightSide
        rightSide = new VBox(screenName,nameVBox,usernameVBox,passwordVBox,buttonsHBox);
        rightSide.setAlignment(Pos.CENTER);
        rightSide.setMinWidth(544);
        rightSide.setMinHeight(500);

        screen = new HBox(leftSide,rightSide);
        screen.setMinWidth(754);
        screen.setMinHeight(500);


        pane = new Pane(screen);
        pane.setId("root");

        scene = new Scene(pane, 754, 500);
        scene.getStylesheets().add(getClass().getResource("../style/login.css").toExternalForm());

        this.setTitle("Login");
        this.setScene(scene);
    }

    public TextField getNameField() {
        return nameField;
    }

    public TextField getUsernameField() {
        return usernameField;
    }

    public PasswordField getPasswordField() {
        return passwordField;
    }

    public Button getLoginButton() {
        return loginButton;
    }

    public Button getSignupButton() {
        return signupButton;
    }
}
