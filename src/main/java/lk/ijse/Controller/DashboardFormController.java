package lk.ijse.Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Line;
import javafx.stage.Stage;

import java.io.IOException;

public class DashboardFormController {
    @FXML
    private Line lineCustomer;

    @FXML
    private Line lineItem;

    @FXML
    private Line linePlaceOrder;

    @FXML
    private Line lineHome;

    private Line[] lines = {lineHome,lineCustomer,lineItem,linePlaceOrder};
    @FXML
    private AnchorPane rootMain;
    @FXML
    private AnchorPane root;

    @FXML
    void btnCustomerOnAction(ActionEvent event) throws IOException {
        root.setVisible(true);

        lineHome.setVisible(false);
        lineItem.setVisible(false);
        lineCustomer.setVisible(true);
        linePlaceOrder.setVisible(false);

        Node node = (Node)FXMLLoader.load(getClass().getResource("/view/customer_form.fxml"));
        root.getChildren().setAll(node);

    }

    @FXML
    void btnHomeOnAction(ActionEvent event) {
        root.setVisible(false);

        lineHome.setVisible(true);
        lineItem.setVisible(false);
        lineCustomer.setVisible(false);
        linePlaceOrder.setVisible(false);
    }

    @FXML
    void btnItemOnAction(ActionEvent event) throws IOException {
        root.setVisible(true);

        lineHome.setVisible(false);
        lineItem.setVisible(true);
        lineCustomer.setVisible(false);
        linePlaceOrder.setVisible(false);

        Node node = (Node)FXMLLoader.load(getClass().getResource("/view/item_form.fxml"));
        root.getChildren().setAll(node);
    }

    @FXML
    void btnPlaceOrderOnAction(ActionEvent event) throws IOException {
        root.setVisible(true);

        lineHome.setVisible(false);
        lineItem.setVisible(false);
        lineCustomer.setVisible(false);
        linePlaceOrder.setVisible(true);

        Node node = (Node)FXMLLoader.load(getClass().getResource("/view/place_order_form.fxml"));
        root.getChildren().setAll(node);
    }
}
