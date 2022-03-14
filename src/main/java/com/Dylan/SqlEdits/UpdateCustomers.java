package com.Dylan.SqlEdits;

import java.sql.*;

public class UpdateCustomers {

    private static final String UPDATE_CUSTOMERS_BY_ID =
            "UPDATE Customers SET CFname = ?," +
                    "CLname = ? WHERE CID = ?";
    private static final String UPDATE_CUSTOMER_BY_FIRSTNAME =
            "UPDATE Customers SET CFname = ?," +
                    " CLname = ? WHERE CFname = ?";
    private static final String DELETE_CUSTOMER_BY_ID =
            "DELETE FROM Customers WHERE CID = ?";
    private static final String ADD_CUSTOMER =
            "INSERT INTO Customers (CFname, CLname) VALUES (?, ?)";
    public static final String CUSTOMER_SQL =
            "SELECT * FROM Customers";


    /***
     * Updates a customer based on their ID.
     * @param CID The customer ID
     * @param CFN Customer's new first name
     * @param CLN Customer's new last name
     * @param connection a database connection
     * @throws SQLException upon invalid customer ID
     */
    public static void updateCustomerById(String CID, String CFN, String CLN, Connection connection) throws SQLException {

        PreparedStatement updateCustomer = connection.prepareStatement(UPDATE_CUSTOMERS_BY_ID);
        updateCustomer.setString(1, CFN);
        updateCustomer.setString(2, CLN);
        updateCustomer.setString(3, CID);

        try {
            updateCustomer.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("Please try again!");
            ex.printStackTrace();
        }

    }

    /***
     * Updates a customer in the Customer database.
     * @param CFN Customer's first name
     * @param NewCFN Customer's new first name
     * @param NewCLN Customer's new last name
     * @param connection A database connection
     * @throws SQLException upon invalid customer name.
     */
    public static void updateCustomerByFirst(String CFN, String NewCFN, String NewCLN, Connection connection) throws SQLException {

        PreparedStatement updateCustomerFirstName = connection.prepareStatement(UPDATE_CUSTOMER_BY_FIRSTNAME);
        updateCustomerFirstName.setString(1, NewCFN);
        updateCustomerFirstName.setString(2, NewCLN);
        updateCustomerFirstName.setString(3, CFN);

        try {
            updateCustomerFirstName.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("Please try again!");
            ex.printStackTrace();
        }

    }

    /***
     * Deletes a customer from the Customers database.
     * @param CID Customer's ID
     * @param connection a database connection
     * @throws SQLException upon invalid customer ID
     */
    public static void deleteCustomerById(String CID, Connection connection) throws SQLException {

        PreparedStatement deleteCustomer = connection.prepareStatement(DELETE_CUSTOMER_BY_ID);
        deleteCustomer.setString(1, CID);

        deleteCustomer.executeUpdate();
        System.out.println("Delete Customer where ID = " + CID);
    }

    public static void addCustomer(String customerFN, String customerLN, Connection connection) throws SQLException {
        PreparedStatement addCustomers = connection.prepareStatement(ADD_CUSTOMER);
        addCustomers.setString(1, customerFN);
        addCustomers.setString(2, customerLN);

        addCustomers.executeUpdate();
        System.out.println("A customer has been added with th name: " + customerFN + " " + customerLN);

    }

    /***
     * Contains predefined sql column labels defined by a {@link ResultSet}. Method will run a query for
     * Customer first and last names within the Customer table. Upon completion the retrieved data will be
     * output into a table format.
     * @param connection Connection to the database
     * @throws SQLException upon invalid sql statement
     */
    public static void showCustomers(Connection connection) throws SQLException {
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(CUSTOMER_SQL);

        System.out.println("\nCustomers");
        System.out.println("-----------------------------------------------------------------------------------");

        System.out.printf("%n %20s %20s %20s", "First name", "Last Name", "CustomerID");

        while (resultSet.next()) {
            String firstName = resultSet.getString("CFname");
            String lastName = resultSet.getString("CLname");
            String CID = resultSet.getString("CID");
            System.out.printf("%n %20s %20s %20s", firstName, lastName, CID);
        }
        System.out.println();
        System.out.println("-----------------------------------------------------------------------------------");
    }
}
