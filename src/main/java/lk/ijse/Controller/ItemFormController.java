package lk.ijse.Controller;

import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import lk.ijse.DTO.Customer;
import lk.ijse.DTO.Item;
import lk.ijse.Model.CustomerModel;
import lk.ijse.Model.ItemModel;

import java.sql.SQLException;
import java.util.ArrayList;

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
        String code = txtCode.getText();

        try {
            boolean isDeleted = ItemModel.delete(code);

            if(isDeleted){
                new Alert(Alert.AlertType.CONFIRMATION, "Item is deleted").show();
            }
        } catch (SQLException e) {
            new Alert(Alert.AlertType.ERROR, "Oops...Something Wrong!!!").show();
        }
    }

    @FXML
    void btnSaveOnAction(ActionEvent event) {
        String code = txtCode.getText();
        String description = txtDescription.getText();
        Double unitPrice = Double.valueOf(txtUnitPrice.getText());
        Integer qtyOnHand = Integer.valueOf(txtQtyOnHand.getText());

        try {
            boolean isSaved = ItemModel.save(new Item(code, description, unitPrice, qtyOnHand));
            if(isSaved){
                new Alert(Alert.AlertType.CONFIRMATION,"Item is Saved!").show();
            }
        } catch (SQLException e) {
            new Alert(Alert.AlertType.ERROR, "Oops... Something Wrong!!!").show();
        }
    }

    @FXML
    void btnShowItemsOnAction(ActionEvent event) {
        try {
            ArrayList<Item> itemsList = ItemModel.getAllItems();

            for(Item item : itemsList){
                System.out.println(item.getCode() + "-" + item.getDescription() + "-" + item.getUnitPrice() + "-" + item.getQtyOnHand());
            }
        } catch (SQLException e) {
            new Alert(Alert.AlertType.ERROR, "Oops.. Something Wrong!!!").show();
        }
    }

    @FXML
    void btnUpdateOnAction(ActionEvent event) {
        String code = txtCode.getText();
        String description = txtDescription.getText();
        Double unitPrice = Double.valueOf(txtUnitPrice.getText());
        Integer qtyOnHand = Integer.valueOf(txtQtyOnHand.getText());

        try {
            boolean isUpdated = ItemModel.update(new Item(code, description, unitPrice, qtyOnHand));

            if(isUpdated) {
                new Alert(Alert.AlertType.CONFIRMATION, "Item Updated!").show();
            }
        } catch (SQLException e) {
            new Alert(Alert.AlertType.ERROR, "Oops...Something Wrong!!!").show();
        }
    }

    @FXML
    void txtCodeOnAction(ActionEvent event) {
        String code = txtCode.getText();

        try {
            Item item = ItemModel.search(code);

            if(item != null) {
                txtDescription.setText(item.getDescription());
                txtUnitPrice.setText(String.valueOf(item.getUnitPrice()));
                txtQtyOnHand.setText(String.valueOf(item.getQtyOnHand()));
            }else{
                new Alert(Alert.AlertType.WARNING, "No Item Found!!!").show();
            }
        } catch (SQLException e) {
            new Alert(Alert.AlertType.ERROR, "Oops... Something Wrong!!!").show();
        }
    }

}
