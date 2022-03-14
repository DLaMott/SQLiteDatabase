package com.Dylan.Menus;

import com.Dylan.SqlEdits.UpdateCustomers;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

public class CustomerMenu {

    public static String CustomerMenu = "Customer menu\n1. Edit by ID\n2. Edit by first name\n3. Delete by ID\n4. Add customer\n5. Show customers\n6. Exit";
    public static boolean isValid = true;
    private static String CID;
    private static String CFN;
    private static String CLN;
    private static String CustomerFN;
    private static String CustomerLN;


    public static void customerMenu(Connection connection) throws SQLException {

        while (isValid) {
            Scanner scanner = new Scanner(System.in);
            System.out.println(CustomerMenu);
            String input = scanner.nextLine();


            switch (input) {
                case "1":
                    System.out.println("Enter the Customer ID");
                    CID = scanner.nextLine();
                    System.out.println("Enter the new first name");
                    CFN = scanner.nextLine();
                    System.out.println("Enter the new last name");
                    CLN = scanner.nextLine();

                    UpdateCustomers.updateCustomerById(CID, CFN, CLN, connection);
                    System.out.println("Customer ID: " + CID + "has been updated to: " + CFN + " " + CLN);
                    break;
                case "2":
                    System.out.println("Enter the Customer First name");
                    CFN = scanner.nextLine();
                    System.out.println("Enter the new first name");
                    CustomerFN = scanner.nextLine();
                    System.out.println("Enter the new last name");
                    CustomerLN = scanner.nextLine();

                    UpdateCustomers.updateCustomerByFirst(CFN, CustomerFN, CustomerLN, connection);
                    System.out.println(CustomerFN + " " + "has been changed to: " + CustomerFN + " " + CustomerLN);

                    break;
                case "3":
                    System.out.println("Enter the customer ID");
                    CID = scanner.nextLine();
                    UpdateCustomers.deleteCustomerById(CID, connection);
                    System.out.println("Customer with ID: " + CID + " has been deleted.");
                    break;
                case "4":
                    System.out.println("Enter customer first name");
                    CFN = scanner.nextLine();
                    System.out.println("Enter customer last name");
                    CLN = scanner.nextLine();
                    UpdateCustomers.addCustomer(CFN, CLN, connection);
                    System.out.println("A customer with the name " + CFN + " " + CLN + " has been added.");
                    break;
                case "5":
                    UpdateCustomers.showCustomers(connection);
                    break;
                case "6":
                    isValid = false;
                    break;
                default:
                    System.out.println("Incorrect entry, please try again!");
                    break;
            }
        }
    }
}
