import configurations.Database;
import javafx.application.Application;
import javafx.stage.Stage;

import java.sql.Connection;

public class Main extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {

    }

    public static void main(String[] args) {

        Connection c = Database.getConnection();
        launch();
    }
}
