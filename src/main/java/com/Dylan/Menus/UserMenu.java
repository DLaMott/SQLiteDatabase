package com.Dylan.Menus;

import com.Dylan.SqlUpdates.*;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

public class UserMenu {
    /***
     *
     * @param connection a database connection
     * @throws SQLException upon invalid connection and invalid table query
     */
    public static void menu(Connection connection) throws SQLException {

        boolean isValidEntry = true;

        while (isValidEntry) {
            System.out.println("Welcome to the DB Connection tool");
            System.out.println("Please choose fom the following:");
            System.out.println("1. Customer menu" +
                    "\n2. Employee menu" +
                    "\n3. Sale menu" +
                    "\n4. Inventory menu" +
                    "\n5. Show all tables" +
                    "\n6. Show final project menu" +
                    "\n7.Exit");

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
                    FinalMenu.finalMenu(connection);
                    break;
                case "7":
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
