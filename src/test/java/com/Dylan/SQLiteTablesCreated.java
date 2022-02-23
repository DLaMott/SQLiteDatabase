package com.Dylan;

import org.junit.jupiter.api.Test;
import java.sql.Connection;
import java.sql.SQLException;


class SQLiteTablesCreated {

    public static final String EMPLOYEE_SQL = "SELECT * FROM Employees";
    public static final String CUSTOMER_SQL = "SELECT * FROM Customers";
    public static final String INVENTORY_SQL = "SELECT * FROM Inventory";
    public static final String SALES_SQL = "SELECT * FROM Sales";

    Connection connection = Connect.connect();

    @Test
    void sqliteEmployeeTable() throws SQLException {
        SQLiteOutput.sqliteEmployeeOutput(connection, EMPLOYEE_SQL);

    }

    @Test
    void sqliteCustomerTable() throws SQLException {
        SQLiteOutput.sqliteCustomerOutput(connection, CUSTOMER_SQL);
    }

    @Test
    void sqliteInventoryTable() throws SQLException {
        SQLiteOutput.sqliteInventoryOutput(connection, INVENTORY_SQL);
    }

    @Test
    void sqliteSalesTable() throws SQLException {
        SQLiteOutput.sqliteSalesOutput(connection, SALES_SQL);
    }
}