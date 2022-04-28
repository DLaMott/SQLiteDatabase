package com.Dylan.SqlUpdates;

import java.sql.*;

public class UpdateEmployees {

    private static final String UPDATE_EMPLOYEE_BY_ID =
            "UPDATE Employees SET EFname = ?," +
                    "ELname = ? WHERE EID = ?";
    private static final String UPDATE_EMPLOYEE_BY_FIRSTNAME =
            "UPDATE Employees SET EFname = ?," +
                    " ELname = ? WHERE EFname = ?";
    private static final String DELETE_EMPLOYEE_BY_ID =
            "DELETE FROM Employees WHERE EID = ?";
    private static final String ADD_EMPLOYEE =
            "INSERT INTO Employees (EFname, ELname) VALUES (?, ?)";
    public static final String SHOW_EMPLOYEE =
            "SELECT * FROM Employees";


    /***
     * Updates an Employee based on their ID.
     * @param EID The Employee ID
     * @param EFN Employee's new first name
     * @param ELN Employee's new last name
     * @param connection a database connection
     * @throws SQLException upon invalid Employee ID
     */
    public static void updateEmployeeById(String EID, String EFN, String ELN, Connection connection) throws SQLException {

        PreparedStatement updateEmployee = connection.prepareStatement(UPDATE_EMPLOYEE_BY_ID);
        updateEmployee.setString(1, EFN);
        updateEmployee.setString(2, ELN);
        updateEmployee.setString(3, EID);

        try {
            updateEmployee.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("Please try again!");
            ex.printStackTrace();
        }
    }

    /***
     * Updates an Employee in the Employees database.
     * @param EFN Employee's first name
     * @param newEFN Employee's new first name
     * @param newELN Employee's new last name
     * @param connection A database connection
     * @throws SQLException upon invalid Employee name.
     */
    public static void updateEmployeeByFirst(String EFN, String newEFN, String newELN, Connection connection) throws SQLException {

        PreparedStatement updateEmployeeFirstName = connection.prepareStatement(UPDATE_EMPLOYEE_BY_FIRSTNAME);
        updateEmployeeFirstName.setString(1, newEFN);
        updateEmployeeFirstName.setString(2, newELN);
        updateEmployeeFirstName.setString(3, EFN);

        try {
            updateEmployeeFirstName.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("Please try again!");
            ex.printStackTrace();
        }
    }

    /***
     * Deletes an employee from the Employees database.
     * @param EID Employee's ID
     * @param connection a database connection
     * @throws SQLException upon invalid employee ID
     */
    public static void deleteEmployeeById(String EID, Connection connection) throws SQLException {

        PreparedStatement deleteEmployee = connection.prepareStatement(DELETE_EMPLOYEE_BY_ID);
        deleteEmployee.setString(1, EID);
        deleteEmployee.executeUpdate();
    }

    public static void addEmployee(String employeeFN, String employeeLN, Connection connection) throws SQLException {
        PreparedStatement addEmployees = connection.prepareStatement(ADD_EMPLOYEE);
        addEmployees.setString(1, employeeFN);
        addEmployees.setString(2, employeeLN);
        addEmployees.executeUpdate();
    }

    /***
     * Contains predefined sql column labels defined by a {@link ResultSet}. Method will run a query for
     * Employee first and last names within the Employees table. Upon completion the retrieved data will be
     * output into a table format.
     * @param connection Connection to the database
     * @throws SQLException upon invalid sql statement
     */
    public static void showEmployees(Connection connection) throws SQLException {
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(SHOW_EMPLOYEE);

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
    public static void showEmployeesLastName(Connection connection) throws SQLException {
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(SHOW_EMPLOYEE);

        System.out.println("\nEmployees by last name");
        System.out.println("-----------------------------------------------------------------------------------");

        System.out.printf("%n %20s %20s", "EmployeeID", "LastName");

        while (resultSet.next()) {
            String EID = resultSet.getString("EID");
            String lastName = resultSet.getString("ELname");
            System.out.printf("%n %20s %20s", EID, lastName);
        }
        System.out.println();
        System.out.println("-----------------------------------------------------------------------------------");
    }
}

