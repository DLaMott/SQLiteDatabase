package com.Dylan.Application;

import com.Dylan.Menus.UserMenu;

import java.sql.Connection;
import java.sql.SQLException;

public class SQLiteMain {

    public static void main(String[] args) {

        Connection connection = Connect.connect();

        try {
            UserMenu.menu(connection);

        } catch (SQLException e) {
            System.out.println("Error connecting to database");
            e.printStackTrace();
        }
    }
}