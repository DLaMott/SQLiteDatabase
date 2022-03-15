package com.Dylan.Menus;

import com.Dylan.SqlUpdates.*;

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
            String selection = scanner.nextLine();

            switch (selection) {
                case "1":
                    CustomerMenu.customerMenu(connection);
                    break;
                case "2":
                   EmployeeMenu.employeeMenu(connection);
                    break;
                case "3":
                    SalesMenu.salesMenu(connection);
                    break;
                case "4":
                    InventoryMenu.inventoryMenu(connection);
                    break;
                case "5":
                    UpdateEmployees.showEmployees(connection);
                    UpdateCustomers.showCustomers(connection);
                    UpdateInventory.showInventory(connection);
                    UpdateSales.showSales(connection);
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
