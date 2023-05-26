package controllers;


import modles.User;
import views.LoginScreen;
import views.SignUpScreen;


public class LoginController {
    public LoginScreen loginScreen = new LoginScreen();
    User user = new User();

    public LoginController() {

        loginScreen.getLoginButton().setOnAction(e -> {
          boolean isLogin=  User.login(loginScreen.getUsernameField().getText(),
                    loginScreen.getPasswordField().getText());
            if (isLogin) {
//                Date currentDate = new Date();
//                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd hh:mm:ss");
//                String formattedDate = dateFormat.format(currentDate);
//                System.out.println(formattedDate);
//
//                String content = "["+formattedDate+",A select user from user table]";
//
//                try (FileWriter fileWriter = new FileWriter(getClass().getResource("database.txt").getFile())) {
//                    fileWriter.append(content);
//                } catch (IOException i) {
//                    i.printStackTrace();
//                }

                loginScreen.close();
//                new
            }

        });

        loginScreen.getSignupButton().setOnAction(e -> {
            loginScreen.close();
            new SignUpController().signUpScreen.show();
        });

    }

}
