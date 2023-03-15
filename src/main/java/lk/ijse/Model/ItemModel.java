package lk.ijse.Model;

import lk.ijse.DTO.Item;

import java.sql.*;
import java.util.ArrayList;
import java.util.Properties;

public class ItemModel {
    private static String URL;
    private static Properties props = new Properties();

    static {
        URL = "jdbc:mysql://localhost:3306/thogakade";
        props.setProperty("user","root");
        props.setProperty("password","1234");
    }

    public static boolean save(Item item) throws SQLException {
        try(Connection con = DriverManager.getConnection(URL, props)){
            String sql = "INSERT INTO Item(code,description,unitPrice,qtyOnHand) VALUES(?,?,?,?)";

            PreparedStatement pstm = con.prepareStatement(sql);
            pstm.setString(1, item.getCode());
            pstm.setString(2, item.getDescription());
            pstm.setDouble(3, item.getUnitPrice());
            pstm.setInt(4, item.getQtyOnHand());

            int affectedRows = pstm.executeUpdate();

            return affectedRows > 0;
        }
    }

    public static ArrayList<Item> getAllItems() throws SQLException {
        try(Connection con = DriverManager.getConnection(URL, props)){
            String sql = "SELECT * FROM Item";

            ResultSet rs = con.createStatement().executeQuery(sql);

            ArrayList<Item> itemsList = new ArrayList<>();
            while(rs.next()){
                String code = rs.getString(1);
                String description = rs.getString(2);
                Double unitPrice = rs.getDouble(3);
                Integer qtyOnHand = rs.getInt(4);

                itemsList.add(new Item(code, description, unitPrice, qtyOnHand));
            }

            return itemsList;
        }
    }

    public static Item search(String code) throws SQLException {
        try(Connection con = DriverManager.getConnection(URL, props)){
            String sql = "SELECT * FROM Item WHERE code = ?";

            PreparedStatement pstm = con.prepareStatement(sql);
            pstm.setString(1, code);

            ResultSet rs = pstm.executeQuery();

            if(rs.next()){
                String description = rs.getString(2);
                Double unitPrice = rs.getDouble(3);
                Integer qtyOnHand = rs.getInt(4);

                return new Item(code, description, unitPrice, qtyOnHand);
            }
        }
        return null;
    }

    public static boolean update(Item item) throws SQLException {
        try(Connection con = DriverManager.getConnection(URL, props)){
            String sql = "UPDATE Item SET description = ?, unitPrice = ?, qtyOnHand = ? WHERE code = ?";

            PreparedStatement pstm = con.prepareStatement(sql);
            pstm.setString(1, item.getDescription());
            pstm.setDouble(2, item.getUnitPrice());
            pstm.setInt(3, item.getQtyOnHand());
            pstm.setString(4, item.getCode());

            int affectedRows = pstm.executeUpdate();

            return affectedRows > 0;
        }
    }

    public static boolean delete(String code) throws SQLException {
        try(Connection con = DriverManager.getConnection(URL, props)){
            String sql = "DELETE FROM Item WHERE code = ?";

            PreparedStatement pstm = con.prepareStatement(sql);
            pstm.setString(1, code);

            int affectedRows = pstm.executeUpdate();

            return affectedRows > 0;
        }
    }
}
