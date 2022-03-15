package com.Dylan.Menus;

import com.Dylan.SqlUpdates.UpdateEmployees;
import com.Dylan.SqlUpdates.UpdateSales;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

public class SalesMenu {

    private static String SalesMenu =
            "Sales menu\n1. Delete by ID" +
                    "\n2. Add Sale\n3. Show sales\n4. Exit";
    public static boolean isValid = true;
    private static int SID;
    private static int SQTY;
    private static double STotal;
    private static int CID;
    private static int EID;
    private static int IID;


    public static void salesMenu(Connection connection) throws SQLException {

        while (isValid) {
            Scanner scanner = new Scanner(System.in);
            System.out.println(SalesMenu);
            String input = scanner.nextLine();


            switch (input) {
                case "1":
                    System.out.println("Enter the Sale ID");
                    SID = scanner.nextInt();
                    UpdateSales.deleteSaleById(SID, connection);
                    System.out.println("Sale with ID: " + SID + " has been deleted.");
                    break;
                case "2":
                    System.out.println("Enter the sale quantity");
                    SQTY = scanner.nextInt();
                    System.out.println("Enter the sale total");
                    STotal = scanner.nextDouble();
                    System.out.println("Enter the Customer ID");
                    CID = scanner.nextInt();
                    System.out.println("Enter the inventory ID");
                    IID = scanner.nextInt();
                    System.out.println("Enter the employee ID");
                    EID = scanner.nextInt();
                    UpdateSales.addSale(SQTY, STotal, CID, IID, EID, connection);
                    break;
                case "3":
                    UpdateSales.showSales(connection);
                    break;
                case "4":
                    isValid = false;
                    break;
                default:
                    System.out.println("Incorrect entry, please try again!");
                    break;
            }
        }
    }
}
