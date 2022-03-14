package com.Dylan;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

public class UserMenu {

    public static void menu(Connection connection) throws SQLException {

        boolean isValidEntry = true;

        while (isValidEntry) {
            System.out.println("Welcome to the DB Connection tool");
            System.out.println("Please choose fom the following:");
            System.out.println("1. Edit Customers\n2. Edit Employees\n3. Edit Sales\n4. Edit Inventory\n5. Show all tables \n6. Exit");

            Scanner scanner = new Scanner(System.in);
            String idk = scanner.nextLine();

            switch (idk) {
                case "1":
                    CustomerMenu.customerMenu(connection);
                    break;
                case "2":
                    System.out.println("Employees");
                    break;
                case "3":
                    System.out.println("Sales");
                    break;
                case "4":
                    System.out.println("Inventory");
                    break;
                case "5":
                    SQLiteOutput.sqliteEmployeeOutput(connection, SQLiteOutput.EMPLOYEE_SQL);
                    UpdateCustomers.showCustomers(connection);
                    SQLiteOutput.sqliteInventoryOutput(connection, SQLiteOutput.INVENTORY_SQL);
                    SQLiteOutput.sqliteSalesOutput(connection, SQLiteOutput.SALES_SQL);
                    break;
                case "6":
                    System.out.println("Good bye!");
                    connection.close();
                    scanner.close();
                    isValidEntry = false;
                    break;
                default:
                    System.out.println("Incorrect entry please try again.");
                    System.out.println();
                    break;

            }
        }
    }
}
