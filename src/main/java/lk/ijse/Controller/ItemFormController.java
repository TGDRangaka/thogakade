package lk.ijse.Controller;

import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

public class ItemFormController {

    @FXML
    private JFXTextField txtCode;

    @FXML
    private JFXTextField txtDescription;

    @FXML
    private JFXTextField txtUnitPrice;

    @FXML
    private JFXTextField txtQtyOnHand;

    @FXML
    void btnClearOnAction(ActionEvent event) {
        txtCode.setText(null);
        txtDescription.setText(null);
        txtUnitPrice.setText(null);
        txtQtyOnHand.setText(null);
    }

    @FXML
    void btnDeleteOnAction(ActionEvent event) {

    }

    @FXML
    void btnSaveOnAction(ActionEvent event) {

    }

    @FXML
    void btnShowItemsOnAction(ActionEvent event) {

    }

    @FXML
    void btnUpdateOnAction(ActionEvent event) {

    }

    @FXML
    void txtCodeOnAction(ActionEvent event) {

    }

}
