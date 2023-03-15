package lk.ijse.Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class DashboardFormController {

    @FXML
    private AnchorPane root;

    @FXML
    void btnCustomerOnAction(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/view/customer_form"));
        Scene scene = new Scene(fxmlLoader.load());

        Stage stage = (Stage) root.getScene().getWindow();
        stage.setScene(scene);
    }

    @FXML
    void btnHomeOnAction(ActionEvent event) {
        root.setVisible(false);
    }

    @FXML
    void btnItemOnAction(ActionEvent event) {

    }

    @FXML
    void btnPlaceOrderOnAction(ActionEvent event) {

    }

}
