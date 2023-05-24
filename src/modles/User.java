package modles;

import configurations.Database;
import javafx.scene.control.Alert;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class User {
    private String name , userName, password;

    public User() {
    }

    public User(String name, String userName,  String password) {
        this.name = name;
        this.userName = userName;
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }


    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public static boolean login(String userName, String password){
        boolean isLogin=false;

        if (userName.isEmpty() || password.isEmpty()){
            Alert usernamePasswordAlert = new Alert(Alert.AlertType.INFORMATION);
            usernamePasswordAlert.setTitle("Alert Message");
            usernamePasswordAlert.setHeaderText(null);
            usernamePasswordAlert.setContentText("the username and password are required");
            // Display the alert dialog
            usernamePasswordAlert.showAndWait();
        }else {

            try {
                String sql = "SELECT * FROM user WHERE username = ? AND password = ?";
                PreparedStatement statement = Database.getConnection().prepareStatement(sql);

                statement.setString(1, userName); // Replace with the actual user ID you want to retrieve
                statement.setString(2, password); // Replace with the actual user password you want to retrieve

                ResultSet resultSet = statement.executeQuery();



                if (resultSet.next()) {

                    isLogin=true;

                    resultSet.close();
                    statement.close();
                }else {
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Alert Message");
                    alert.setHeaderText(null);
                    alert.setContentText("the user data is incorct  or the user doesn't exist");

                    // Display the alert dialog
                    alert.showAndWait();
                }


            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }}

        return isLogin;
    }
    public boolean singUP(User uer){

        return false;
    }

    public boolean isExist(String userName){
        return false;
    }

}
