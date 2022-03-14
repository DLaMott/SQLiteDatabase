package com.Dylan;

import java.sql.Connection;
import java.sql.SQLException;

public class SQLiteTest {

    public static void main(String[] args){

        try {

            Connection connection = Connect.connect();
            SQLiteTableLoad.createTable(connection, SQLiteTableLoad.EMPLOYEE_TABLE);
            SQLiteTableLoad.createTable(connection, SQLiteTableLoad.INVENTORY_TABLE);
            SQLiteTableLoad.createTable(connection, SQLiteTableLoad.CUSTOMER_TABLE);
            SQLiteTableLoad.createTable(connection, SQLiteTableLoad.SALES_TABLE);
            UserMenu.menu(connection);
        } catch (SQLException e) {
            System.out.println("Error connecting to database");
            e.printStackTrace();
        }


    }
}