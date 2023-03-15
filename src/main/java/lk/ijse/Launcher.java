package lk.ijse;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Launcher extends Application {
    private static Stage stage;

    @Override
    public void start(Stage primaryStage) throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/view/dashboard_form.fxml"));
        Scene scene = new Scene(fxmlLoader.load());

        primaryStage.setTitle("Thogakade");
        primaryStage.setScene(scene);
        primaryStage.show();

        stage = primaryStage;
    }

    public static void main(String[] args) {
        launch();
    }
}
