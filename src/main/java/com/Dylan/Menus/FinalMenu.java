package com.Dylan.Menus;

import com.Dylan.SqlUpdates.UpdateCustomers;
import com.Dylan.SqlUpdates.UpdateEmployees;
import com.Dylan.SqlUpdates.UpdateInventory;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

public class FinalMenu {
    private static final String FINAL_MENU =
                    "Final Project" +
                    "\n1. Show inventory that has been sold twice" +
                    "\n2. Show all customers by first and last name" +
                    "\n3. Show inventory descriptions" +
                    "\n4. Show employee ID and last name only" +
                    "\n5. Exit";
    public static boolean isValid = true;

    public static void finalMenu(Connection connection) throws SQLException {

        if (!isValid){
            isValid = true;
        }

        while(isValid){
            Scanner scanner = new Scanner(System.in);
            System.out.println(FINAL_MENU);
            String input = scanner.nextLine();

            switch (input){
                case "1":
                    UpdateInventory.showInventorySoldTwice(connection);
                    break;
                case "2":
                    UpdateCustomers.showCustomersNames(connection);
                    break;
                case "3":
                    UpdateInventory.showInventoryDescriptions(connection);
                    break;
                case "4":
                    UpdateEmployees.showEmployeesLastName(connection);
                    break;
                case "5":
                    isValid = false;
                    break;
                default:
                    System.out.println("Incorrect entry please try again!");
                    break;
            }
        }
    }
}
