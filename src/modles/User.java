package modles;

import com.sun.org.apache.xerces.internal.impl.dv.util.HexBin;
import configurations.Database;
import javafx.scene.control.Alert;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class User {
    private String name, userName, password;

    public User() {
    }

    public User(String name, String userName, String password) {
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


    public static boolean isExist(String userName) {
        boolean isExist = false;
        try {
            String sql = "SELECT * FROM user WHERE username = ?";
            PreparedStatement statement = Database.getConnection().prepareStatement(sql);

            statement.setString(1, userName); // Replace with the actual user ID you want to retrieve
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                isExist = true;

                resultSet.close();
                statement.close();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return isExist;
    }

    public static boolean login(String userName, String password) {
        boolean isLogin = false;

        if (userName.isEmpty() || password.isEmpty()) {
            Alert usernamePasswordAlert = new Alert(Alert.AlertType.INFORMATION);
            usernamePasswordAlert.setTitle("Alert Message");
            usernamePasswordAlert.setHeaderText(null);
            usernamePasswordAlert.setContentText("the username and password are required");
            // Display the alert dialog
            usernamePasswordAlert.showAndWait();
        } else {

            try {
                if (!isExist(userName)) {
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Alert Message");
                    alert.setHeaderText(null);
                    alert.setContentText("The user doesn't exist");

                    // Display the alert dialog
                    alert.showAndWait();
                } else {
                    String sql = "SELECT * FROM user WHERE username = ? ";
                    PreparedStatement statement = Database.getConnection().prepareStatement(sql);
                    statement.setString(1, userName);
                    ResultSet resultSet = statement.executeQuery();
                    if (resultSet.next()) {
                        String pass = resultSet.getString("password");
                        String MD5Pass = md5(password);
                        if (!pass.equals(MD5Pass)) {
                            Alert alert = new Alert(Alert.AlertType.INFORMATION);
                            alert.setTitle("Alert Message");
                            alert.setHeaderText(null);
                            alert.setContentText("The user data is incorrect");

                            // Display the alert dialog
                            alert.showAndWait();
                        } else {


                            isLogin = true;
                        }
                        resultSet.close();
                        statement.close();
                    } else {

                    }
                }

            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
        }

        return isLogin;
    }

    public boolean singUP(User user) {
        boolean isSingUP = false;

        if (user.getName().isEmpty() || user.getUserName().isEmpty() || user.getPassword().isEmpty()) {
            Alert usernamePasswordAlert = new Alert(Alert.AlertType.INFORMATION);
            usernamePasswordAlert.setTitle("Alert Message");
            usernamePasswordAlert.setHeaderText(null);
            usernamePasswordAlert.setContentText("the user data are required");
            // Display the alert dialog
            usernamePasswordAlert.showAndWait();
        } else {
            if (isExist(user.getUserName())) {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Alert Message");
                alert.setHeaderText(null);
                alert.setContentText("The user is exist");

                // Display the alert dialog
                alert.showAndWait();
            }
        }
        return isSingUP;
    }

    public static String md5(String text) {


        MessageDigest md = null;
        try {
            md = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
        md.update(text.getBytes());
        byte[] hash = md.digest();

        String hashString = new String(HexBin.encode(hash));

        return hashString;

    }


}
