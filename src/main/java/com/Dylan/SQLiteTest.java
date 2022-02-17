package com.Dylan;

import java.sql.Connection;
import java.sql.SQLException;

public class SQLiteTest {

    public static void main(String[] args) {

        try {

            Connection connection = Connect.connect();
            SQLiteTableLoad.createTable(connection, SQLiteTableLoad.EMPLOYEE_TABLE);
            SQLiteTableLoad.createTable(connection, SQLiteTableLoad.INVENTORY_TABLE);
            SQLiteTableLoad.createTable(connection, SQLiteTableLoad.CUSTOMER_TABLE);
            SQLiteTableLoad.createTable(connection, SQLiteTableLoad.SALES_TABLE);
            SQLiteOutput.sqliteEmployeeOutput(connection, SQLiteOutput.EMPLOYEE_SQL);
            SQLiteOutput.sqliteCustomerOutput(connection, SQLiteOutput.CUSTOMER_SQL);
            SQLiteOutput.sqliteInventoryOutput(connection, SQLiteOutput.INVENTORY_SQL);
            SQLiteOutput.sqliteSalesOutput(connection, SQLiteOutput.SALES_SQL);

        } catch (SQLException e) {
            System.out.println("Error connecting to database");
            e.printStackTrace();
        }


    }
}