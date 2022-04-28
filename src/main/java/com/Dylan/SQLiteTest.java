package com.Dylan;

import com.Dylan.Menus.UserMenu;
import com.Dylan.SqlUpdates.SQLiteTableLoad;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

public class SQLiteTest {

    public static void main(String[] args) {

        Connection connection = Connect.connect();

        try {

            SQLiteTableLoad.createTable(connection, SQLiteTableLoad.EMPLOYEE_TABLE);
            SQLiteTableLoad.createTable(connection, SQLiteTableLoad.SALES_TABLE);
            SQLiteTableLoad.createTable(connection, SQLiteTableLoad.CUSTOMER_TABLE);
            SQLiteTableLoad.createTable(connection, SQLiteTableLoad.INVENTORY_TABLE);
            UserMenu.menu(connection);

        } catch (SQLException e) {
            System.out.println("Error connecting to database");
            e.printStackTrace();
        }
    }
}