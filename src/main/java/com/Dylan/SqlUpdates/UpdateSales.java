package com.Dylan.SqlUpdates;

import java.sql.*;
import java.text.DecimalFormat;

public class UpdateSales {

    private static final String DELETE_SALE_BY_ID =
            "DELETE FROM Sales WHERE IID = ?";
    private static final String ADD_SALE =
            "INSERT INTO Sales (SQty, STotal, CID, IID, EID) VALUES (?, ?, ?, ?, ?)";
    public static final String SHOW_SALES =
            "SELECT * FROM Sales";

    /***
     * Deletes a sale from the sales database.
     * @param SID Sale ID
     * @param connection a database connection
     * @throws SQLException upon invalid inventory ID
     */
    public static void deleteSaleById(int SID, Connection connection) throws SQLException {

        PreparedStatement deleteSale = connection.prepareStatement(DELETE_SALE_BY_ID);
        deleteSale.setInt(1, SID);
        deleteSale.executeUpdate();
    }


    public static void addSale(int SQty, Double STotal, int CID, int IID, int EID, Connection connection) throws SQLException {
        PreparedStatement addSalesItem = connection.prepareStatement(ADD_SALE);
        addSalesItem.setInt(1, SQty);
        addSalesItem.setDouble(2, STotal);
        addSalesItem.setInt(3, CID);
        addSalesItem.setInt(4, IID);
        addSalesItem.setInt(5, EID);
        addSalesItem.executeUpdate();

    }

    /***
     * Contains predefined sql column labels defined by a {@link ResultSet}. Method will run a query for
     * Inventories within the Inventory table. Upon completion the retrieved data will be
     * output into a table format.
     * @param connection Connection to the database
     * @throws SQLException upon invalid sql statement
     */
    public static void showSales(Connection connection) throws SQLException {
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(SHOW_SALES);

        System.out.println("\nSales");
        System.out.println("-----------------------------------------------------------------------------------");
        System.out.printf("%n %10s %10s %10s %10s %10s %10s", "SID", "Quantity", "Total", "EID", "IID", "CID");

        while (resultSet.next()) {
            String salesID = resultSet.getString("SID");
            String salesQTY = resultSet.getString("SQty");
            double salesTotal = resultSet.getDouble("STotal");
            String price = DecimalFormat.getCurrencyInstance().format(salesTotal);
            String salesEID = resultSet.getString("EID");
            String salesIID = resultSet.getString("IID");
            String salesCID = resultSet.getString("CID");
            System.out.printf("%n %10s %10s %10s %10s %10s %10s",
                    salesID, salesQTY, price, salesEID, salesIID, salesCID);
        }
        System.out.println();
        System.out.println("-----------------------------------------------------------------------------------");
    }
}
