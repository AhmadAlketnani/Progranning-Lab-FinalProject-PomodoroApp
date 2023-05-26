import controllers.LoginController;
import controllers.SignUpController;
import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
//        LoginController loginController = new LoginController();
//        primaryStage = loginController.loginScreen;
        SignUpController  signUpController= new SignUpController();
        primaryStage = signUpController.signUpScreen;



        primaryStage.show();
    }

    public static void main(String[] args) {


        launch();
    }
}
