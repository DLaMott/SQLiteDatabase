package com.Dylan;

import com.Dylan.Application.Connect;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.sql.*;


class SQLiteTablesCreated {

    public static final String EMPLOYEE_SQL = "SELECT * FROM Employees";
    public static final String CUSTOMER_SQL = "SELECT * FROM Customers";
    public static final String INVENTORY_SQL = "SELECT * FROM Inventory";
    public static final String SALES_SQL = "SELECT * FROM Sales";

    Connection connection = Connect.connect();


    @Test
    void sqliteEmployeeTable() throws SQLException {
        Statement statement = connection.createStatement();
        ResultSetMetaData resultSet = (ResultSetMetaData) statement.executeQuery(EMPLOYEE_SQL);
        Assertions.assertEquals("Employees", resultSet.getTableName(1));
    }

    @Test
    void sqliteCustomerTable() throws SQLException {
        Statement statement = connection.createStatement();
        ResultSetMetaData resultSet = (ResultSetMetaData) statement.executeQuery(CUSTOMER_SQL);
        Assertions.assertEquals("Customers", resultSet.getTableName(1));
    }

    @Test
    void sqliteInventoryTable() throws SQLException {
        Statement statement = connection.createStatement();
        ResultSetMetaData resultSet = (ResultSetMetaData) statement.executeQuery(INVENTORY_SQL);
        Assertions.assertEquals("Inventory", resultSet.getTableName(1));
    }

    @Test
    void sqliteSalesTable() throws SQLException {
        Statement statement = connection.createStatement();
        ResultSetMetaData resultSet = (ResultSetMetaData) statement.executeQuery(SALES_SQL);
        Assertions.assertEquals("Sales", resultSet.getTableName(1));
    }
}