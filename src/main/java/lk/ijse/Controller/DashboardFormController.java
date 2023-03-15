package lk.ijse.Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class DashboardFormController {
    @FXML
    private AnchorPane rootMain;
    @FXML
    private AnchorPane root;

    @FXML
    void btnCustomerOnAction(ActionEvent event) throws IOException {
        root.setVisible(true);

        Node node = (Node)FXMLLoader.load(getClass().getResource("/view/customer_form.fxml"));
        root.getChildren().setAll(node);

    }

    @FXML
    void btnHomeOnAction(ActionEvent event) {
        root.setVisible(false);
    }

    @FXML
    void btnItemOnAction(ActionEvent event) throws IOException {
        root.setVisible(true);

        Node node = (Node)FXMLLoader.load(getClass().getResource("/view/item_form.fxml"));
        root.getChildren().setAll(node);
    }

    @FXML
    void btnPlaceOrderOnAction(ActionEvent event) throws IOException {
        root.setVisible(true);

        Node node = (Node)FXMLLoader.load(getClass().getResource("/view/place_order_form.fxml"));
        root.getChildren().setAll(node);
    }

}
