package com.Dylan;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SQLiteOutput {

    public static final String EMPLOYEE_SQL = "SELECT * FROM Employees";
    public static final String CUSTOMER_SQL = "SELECT * FROM Customers";
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
        System.out.println("--------------------------------------");
        System.out.printf("%n %10s %10s", "First name", "Last Name");

        while (resultSet.next()) {
            String firstName = resultSet.getString("EFname");
            String lastName = resultSet.getString("ELname");
            System.out.printf("%n %10s %10s", firstName, lastName);
        }
        System.out.println();
        System.out.println("--------------------------------------");
    }

    /***
     * Contains predefined sql column labels defined by a {@link ResultSet}. Method will run a query for
     * Customer first and last names within the Customer table. Upon completion the retrieved data will be
     * output into a table format.
     * @param connection Connection to the database
     * @param sql sql statement to perform query
     * @throws SQLException upon invalid sql statement
     */
    public static void sqliteCustomerOutput(Connection connection, String sql) throws SQLException {
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);

        System.out.println("\nCustomers");
        System.out.println("--------------------------------------");

        System.out.printf("%n %10s %10s", "First name", "Last Name");

        while (resultSet.next()) {
            String firstName = resultSet.getString("CFname");
            String lastName = resultSet.getString("CLname");
            System.out.printf("%n %10s %10s", firstName, lastName);
        }
        System.out.println();
        System.out.println("--------------------------------------");
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
        System.out.println("--------------------------------------");
        System.out.printf("%n %10s %10s", "IID", "Description");

        while (resultSet.next()) {
            String inventoryID = resultSet.getString("IID");
            String inventoryDes = resultSet.getString("IDesc");
            System.out.printf("%n %10s %10s", inventoryID, inventoryDes);
        }
        System.out.println();
        System.out.println("--------------------------------------");
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
            String salesTotal = resultSet.getString("STotal");
            String salesEID = resultSet.getString("EID");
            String salesIID = resultSet.getString("IID");
            String salesCID = resultSet.getString("CID");
            System.out.printf("%n %10s %10s %10s %10s %10s %10s",
                    salesID, salesQTY, salesTotal, salesEID, salesIID, salesCID);
        }
        System.out.println();
        System.out.println("-----------------------------------------------------------------------------------");
    }
}
