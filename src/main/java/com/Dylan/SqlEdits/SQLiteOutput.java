package com.Dylan.SqlEdits;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DecimalFormat;

public class SQLiteOutput {

    public static final String EMPLOYEE_SQL = "SELECT * FROM Employees";
    public static final String INVENTORY_SQL = "SELECT * FROM Inventory";
    public static final String SALES_SQL = "SELECT * FROM Sales";


    /***
     * Contains predefined sql column labels defined by a {@link ResultSet}. Method will run a query for
     * Employee first and last names within the Employee table. Upon completion the retrieved data will be
     * output into a table format.
     * @param connection Connection to the database
     * @param sql sql statement to perform query
     * @throws SQLException upon invalid sql statement
     */
    public static void sqliteEmployeeOutput(Connection connection, String sql) throws SQLException {
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);

        System.out.println("\nEmployees");
        System.out.println("-----------------------------------------------------------------------------------");
        System.out.printf("%n %20s %20s %20s", "First name", "Last Name", "EmployeeID");

        while (resultSet.next()) {
            String firstName = resultSet.getString("EFname");
            String lastName = resultSet.getString("ELname");
            String EID = resultSet.getString("EID");
            System.out.printf("%n %20s %20s %20s", firstName, lastName, EID);
        }
        System.out.println();
        System.out.println("-----------------------------------------------------------------------------------");
    }

    /***
     * Contains predefined sql column labels defined by a {@link ResultSet}. Method will run a query for
     * Inventory ID and Inventory descriptions within the Inventory table. Upon completion
     * the retrieved data will be output into a table format.
     * @param connection Connection to the database
     * @param sql sql statement to perform query
     * @throws SQLException upon invalid sql statement
     */
    public static void sqliteInventoryOutput(Connection connection, String sql) throws SQLException {
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);

        System.out.println("\nInventory");
        System.out.println("-----------------------------------------------------------------------------------");
        System.out.printf("%n %20s %20s %20s", "IID", "Description", "Price");

        while (resultSet.next()) {
            String inventoryID = resultSet.getString("IID");
            String inventoryDes = resultSet.getString("IDesc");
            int inventoryPrice = resultSet.getInt("IPrice");
            String price = DecimalFormat.getCurrencyInstance().format(inventoryPrice);

            System.out.printf("%n %20s %20s %20s", inventoryID, inventoryDes, price);
        }
        System.out.println();
        System.out.println("-----------------------------------------------------------------------------------");
    }

    /***
     * Contains predefined sql column labels defined by a {@link ResultSet}. Method will run a query for
     * sales ID, sales quantity, and sales total descriptions within the Sales table. Upon completion
     * the retrieved data will be output into a table format.
     * @param connection Connection to the database
     * @param sql sql statement to perform query
     * @throws SQLException upon invalid sql statement
     */
    public static void sqliteSalesOutput(Connection connection, String sql) throws SQLException {
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);

        System.out.println("\nSales");
        System.out.println("-----------------------------------------------------------------------------------");
        System.out.printf("%n %10s %10s %10s %10s %10s %10s", "SID", "Quantity", "Total", "EID", "IID", "CID");

        while (resultSet.next()) {
            String salesID = resultSet.getString("SID");
            String salesQTY = resultSet.getString("SQty");
            int salesTotal = resultSet.getInt("STotal");
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
