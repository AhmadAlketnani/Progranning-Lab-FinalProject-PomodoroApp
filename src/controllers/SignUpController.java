package controllers;

import modles.User;
import views.LoginScreen;
import views.SignUpScreen;

public class SignUpController {

    public SignUpScreen signUpScreen = new SignUpScreen();
    User user ;
    public SignUpController(){
        signUpScreen.getSignupButton().setOnAction(e -> {
            user=new User(signUpScreen.getNameField().getText(),
                    signUpScreen.getUsernameField().getText(),
                    signUpScreen.getPasswordField().getText());
            boolean isSignUp= user.singUP(user);
            if (isSignUp) {

            signUpScreen.close();
            new LoginController().loginScreen.show();
            }
        });
    signUpScreen.getLoginButton().setOnAction(event -> {
        signUpScreen.close();
        new LoginController().loginScreen.show();
    });

    }
}
