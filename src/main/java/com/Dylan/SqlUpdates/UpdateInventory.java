package com.Dylan.SqlUpdates;

import java.sql.*;
import java.text.DecimalFormat;

public class UpdateInventory {

    private static final String UPDATE_INVENTORY_BY_ID =
            "UPDATE Inventory SET IDesc = ?," +
                    "IPrice = ? WHERE IID = ?";
    private static final String DELETE_INVENTORY_BY_ID =
            "DELETE FROM Inventory WHERE IID = ?";
    private static final String ADD_INVENTORY =
            "INSERT INTO Inventory (IDesc, IPrice) VALUES (?, ?)";
    public static final String SHOW_INVENTORY =
            "SELECT * FROM Inventory";
    public static final String SHOW_DOUBLE_SOLD_INVENTORY =
            "SELECT Inventory.IDesc, Inventory.IPrice, Inventory.IID FROM Inventory" +
                    " JOIN Sales ON Inventory.IID = Sales.IID WHERE Sales.SQty >= 2";

    /***
     * Updates an Inventory based on the ID.
     * @param IID The Inventory ID
     * @param IDesc Inventory new description
     * @param IPrice Inventory new price
     * @param connection a database connection
     * @throws SQLException upon invalid inventory ID
     */
    public static void updateInventoryById(String IID, String IDesc, String IPrice, Connection connection) throws SQLException {

        PreparedStatement updateInventory = connection.prepareStatement(UPDATE_INVENTORY_BY_ID);
        updateInventory.setString(1, IDesc);
        updateInventory.setString(2, IPrice);
        updateInventory.setString(3, IID);

        try {
            updateInventory.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("Please try again!");
            ex.printStackTrace();
        }
    }

    /***
     * Deletes an inventory from the Inventory database.
     * @param IID Employee's ID
     * @param connection a database connection
     * @throws SQLException upon invalid inventory ID
     */
    public static void deleteInventoryById(String IID, Connection connection) throws SQLException {

        PreparedStatement deleteInventory = connection.prepareStatement(DELETE_INVENTORY_BY_ID);
        deleteInventory.setString(1, IID);
        deleteInventory.executeUpdate();
    }

    /***
     *
     * @param IDesc Inventory description
     * @param IPrice Inventory price
     * @param connection
     * @throws SQLException On Table not found
     */
    public static void addInventory(String IDesc, String IPrice, Connection connection) throws SQLException {
        PreparedStatement addInventoryItem = connection.prepareStatement(ADD_INVENTORY);
        addInventoryItem.setString(1, IDesc);
        addInventoryItem.setString(2, IPrice);
        addInventoryItem.executeUpdate();

    }

    /***
     * Contains predefined sql column labels defined by a {@link ResultSet}. Method will run a query for
     * Inventories within the Inventory table. Upon completion the retrieved data will be
     * output into a table format.
     * @param connection Connection to the database
     * @throws SQLException upon invalid sql statement
     */
    public static void showInventory(Connection connection) throws SQLException {
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(SHOW_INVENTORY);

        System.out.println("\nInventory");
        System.out.println("-----------------------------------------------------------------------------------");
        System.out.printf("%n %20s %20s %20s", "IID", "Description", "Price");

        while (resultSet.next()) {
            String inventoryID = resultSet.getString("IID");
            String inventoryDes = resultSet.getString("IDesc");
            double inventoryPrice = resultSet.getDouble("IPrice");
            String price = DecimalFormat.getCurrencyInstance().format(inventoryPrice);

            System.out.printf("%n %20s %20s %20s", inventoryID, inventoryDes, price);
        }
        System.out.println();
        System.out.println("-----------------------------------------------------------------------------------");
    }

    public static void showInventorySoldTwice(Connection connection) throws SQLException{
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(SHOW_DOUBLE_SOLD_INVENTORY);

        System.out.println("-----------------------------------------------------------------------------------");

        while (resultSet.next()){

            String inventoryDes = resultSet.getString("IDesc");
            double inventoryPrice = resultSet.getDouble("IPrice");
            String price = DecimalFormat.getCurrencyInstance().format(inventoryPrice);
            System.out.printf("%n %20s %20s", inventoryDes, price);
        }
        System.out.println();
        System.out.println("-----------------------------------------------------------------------------------");
    }
    public static void showInventoryDescriptions(Connection connection) throws SQLException{
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(SHOW_INVENTORY);

        System.out.println("-----------------------------------------------------------------------------------");
        while (resultSet.next()){

            String inventoryDes = resultSet.getString("IDesc");
            System.out.printf("%n %20s", inventoryDes);
        }
        System.out.println();
        System.out.println("-----------------------------------------------------------------------------------");
    }
}
