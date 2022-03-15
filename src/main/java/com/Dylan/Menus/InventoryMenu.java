package com.Dylan.Menus;

import com.Dylan.SqlUpdates.UpdateEmployees;
import com.Dylan.SqlUpdates.UpdateInventory;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

public class InventoryMenu {

    private static String InventoryMenu =
            "Employee menu\n1. Edit by ID\n2. Delete by ID" +
                    "\n3. Add Inventory Item\n4. Show Inventory\n5. Exit";
    private static boolean isValid = true;
    private static String IID;
    private static String IDesc;
    private static String IPrice;

    public static void inventoryMenu(Connection connection) throws SQLException {

        while (isValid) {
            Scanner scanner = new Scanner(System.in);
            System.out.println(InventoryMenu);
            String input = scanner.nextLine();


            switch (input) {
                case "1":
                    System.out.println("Enter the Inventory ID");
                    IID = scanner.nextLine();
                    System.out.println("Enter the new Item description");
                    IDesc = scanner.nextLine();
                    System.out.println("Enter the new Inventory price");
                    IPrice = scanner.nextLine();

                    UpdateInventory.updateInventoryById(IID, IDesc, IPrice, connection);
                    System.out.println("Inventory ID: " + IID + "has been updated to: " + IDesc + " " + IPrice);
                    break;
                case "2":
                    System.out.println("Enter the Inventory ID");
                    IID = scanner.nextLine();
                    UpdateInventory.deleteInventoryById(IID, connection);
                    System.out.println("Inventory with ID: " + IID + " has been deleted.");
                    break;
                case "3":
                    System.out.println("Enter the Inventory description");
                    IDesc = scanner.nextLine();
                    System.out.println("Enter the Inventory price");
                    IPrice = scanner.nextLine();
                    UpdateInventory.addInventory(IDesc, IPrice, connection);
                    System.out.println("An Inventory with the description " + IDesc + " and price of  "
                            + IPrice + " has been added.");
                    break;
                case "4":
                    UpdateInventory.showInventory(connection);
                    break;
                case "5":
                    isValid = false;
                    break;
                default:
                    System.out.println("Incorrect entry, please try again!");
                    break;
            }
        }
    }
}
