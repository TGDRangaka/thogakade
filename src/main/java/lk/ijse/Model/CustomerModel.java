package lk.ijse.Model;

import lk.ijse.DTO.Customer;

import java.sql.*;
import java.util.ArrayList;
import java.util.Properties;

public class CustomerModel {
    private static String URL;
    private static Properties props = new Properties();

    static {
        URL = "jdbc:mysql://localhost:3306/thogakade";
        props.setProperty("user","root");
        props.setProperty("password","1234");
    }

    public static boolean save(Customer customer) throws SQLException {
        try(Connection con = DriverManager.getConnection(URL, props)){
            String sql = "INSERT INTO Customer(id,name,address,salary) VALUES(?,?,?,?)";

            PreparedStatement pstm = con.prepareStatement(sql);
            pstm.setString(1,customer.getId());
            pstm.setString(2,customer.getName());
            pstm.setString(3,customer.getAddress());
            pstm.setDouble(4,customer.getSalary());

            int affectedRows = pstm.executeUpdate();

            return affectedRows > 0;
        }
    }

    public static ArrayList<Customer> getAllCustomers() throws SQLException {
        try(Connection con = DriverManager.getConnection(URL, props)){
            String sql = "SELECT * FROM Customer";

            ResultSet rs = con.createStatement().executeQuery(sql);

            ArrayList<Customer> customersList = new ArrayList<>();
            while(rs.next()){
                String id = rs.getString(1);
                String name = rs.getString(2);
                String address = rs.getString(3);
                Double salary = rs.getDouble(4);

                customersList.add(new Customer(id, name, address, salary));
            }

            return customersList;
        }
    }

    public static Customer search(String id) throws SQLException {
        try(Connection con = DriverManager.getConnection(URL, props)){
            String sql = "SELECT * FROM Customer WHERE id = ?";

            PreparedStatement pstm = con.prepareStatement(sql);
            pstm.setString(1, id);

            ResultSet rs = pstm.executeQuery();

            if(rs.next()){
                String Id = rs.getString(1);
                String name = rs.getString(2);
                String address = rs.getString(3);
                Double salary = rs.getDouble(4);

                return new Customer(Id, name, address, salary);
            }
        }
        return null;
    }

    public static boolean update(Customer customer) throws SQLException {
        try(Connection con = DriverManager.getConnection(URL, props)){
            String sql = "UPDATE Customer SET name = ?, address = ?, salary = ? WHERE id = ?";

            PreparedStatement pstm = con.prepareStatement(sql);
            pstm.setString(1, customer.getName());
            pstm.setString(2, customer.getAddress());
            pstm.setDouble(3, customer.getSalary());
            pstm.setString(4, customer.getId());

            int affectedRows = pstm.executeUpdate();

            return affectedRows > 0;
        }
    }

    public static boolean delete(String id) throws SQLException {
        try(Connection con = DriverManager.getConnection(URL, props)){
            String sql = "DELETE FROM Customer WHERE id = ?";

            PreparedStatement pstm = con.prepareStatement(sql);
            pstm.setString(1, id);

            int affectedRows = pstm.executeUpdate();

            return affectedRows > 0;
        }
    }
}
