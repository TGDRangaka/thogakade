package lk.ijse.Controller;

import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import lk.ijse.DTO.Customer;
import lk.ijse.Model.CustomerModel;

import java.sql.SQLException;
import java.util.ArrayList;

public class CustomerFormController {

    @FXML
    private JFXTextField txtId;

    @FXML
    private JFXTextField txtName;

    @FXML
    private JFXTextField txtAddress;

    @FXML
    private JFXTextField txtSalary;

    @FXML
    void btnClearOnAction(ActionEvent event) {
        txtId.setText(null);
        txtName.setText(null);
        txtAddress.setText(null);
        txtSalary.setText(null);
    }

    @FXML
    void btnDeleteOnAction(ActionEvent event) {
        String id = txtId.getText();

        try {
            boolean isDeleted = CustomerModel.delete(id);

            if(isDeleted){
                new Alert(Alert.AlertType.CONFIRMATION, "Customer is deleted!").show();
            }
        } catch (SQLException e) {
            new Alert(Alert.AlertType.ERROR, "Oops...Something Wrong!!!").show();
        }
    }

    @FXML
    void btnSaveOnAction(ActionEvent event) {
        Customer customer = new Customer(txtId.getText(),txtName.getText(),txtAddress.getText(),Double.parseDouble(txtSalary.getText()));

        try {
            boolean isSaved = CustomerModel.save(customer);
            if(isSaved){
                new Alert(Alert.AlertType.CONFIRMATION,"Customer is Saved!").show();
            }
        } catch (SQLException e) {
            new Alert(Alert.AlertType.ERROR, "Oops... Something Wrong!!!").show();
        }
    }

    @FXML
    void btnShowCustomersOnAction(ActionEvent event) {
        try {
            ArrayList<Customer> customerList = CustomerModel.getAllCustomers();

            for(Customer customer : customerList){
                System.out.println(customer.getId() + "-" + customer.getName() + "-" + customer.getAddress() + "-" + customer.getSalary());
            }
        } catch (SQLException e) {
            new Alert(Alert.AlertType.ERROR, "Oops.. Something Wrong!!!").show();
        }
    }

    @FXML
    void btnUpdateOnAction(ActionEvent event) {
        String id = txtId.getText();
        String name = txtName.getText();
        String address = txtAddress.getText();
        Double salary = Double.valueOf(txtSalary.getText());

        try {
            boolean isUpdated = CustomerModel.update(new Customer(id, name, address, salary));

            if(isUpdated) {
                new Alert(Alert.AlertType.CONFIRMATION, "Customer Updated!").show();
            }
        } catch (SQLException e) {
            new Alert(Alert.AlertType.ERROR, "Oops...Something Wrong!!!").show();
        }
    }

    @FXML
    void txtIdOnAction(ActionEvent event) {
        String id = txtId.getText();

        try {
            Customer customer = CustomerModel.search(id);

            if(customer != null) {
                txtName.setText(customer.getName());
                txtAddress.setText(customer.getAddress());
                txtSalary.setText(String.valueOf(customer.getSalary()));
            }else{
                new Alert(Alert.AlertType.WARNING, "No Customer Found!!!").show();
            }
        } catch (SQLException e) {
            new Alert(Alert.AlertType.ERROR, "Oops... Something Wrong!!!").show();
        }
    }

}
