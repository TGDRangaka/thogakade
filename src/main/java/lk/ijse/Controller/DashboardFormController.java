package lk.ijse.Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;

public class DashboardFormController {

    @FXML
    private AnchorPane root;

    @FXML
    void btnCustomerOnAction(ActionEvent event) {
        root.setVisible(false);
    }

    @FXML
    void btnHomeOnAction(ActionEvent event) {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/view/"));
    }

    @FXML
    void btnItemOnAction(ActionEvent event) {

    }

    @FXML
    void btnPlaceOrderOnAction(ActionEvent event) {

    }

}
