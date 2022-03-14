package com.Dylan.Menus;

import com.Dylan.SqlEdits.UpdateCustomers;
import com.Dylan.SqlEdits.UpdateEmployees;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

public class EmployeeMenu {
    public static String EmployeeMenu =
            "Employee menu\n1. Edit by ID\n2. Edit by first name\n3. Delete by ID" +
                    "\n4. Add employee\n5. Show employees\n6. Exit";
    public static boolean isValid = true;
    private static String EID;
    private static String EFN;
    private static String ELN;
    private static String EmployeeFN;
    private static String EmployeeLN;


    public static void employeeMenu(Connection connection) throws SQLException {

        while (isValid) {
            Scanner scanner = new Scanner(System.in);
            System.out.println(EmployeeMenu);
            String input = scanner.nextLine();


            switch (input) {
                case "1":
                    System.out.println("Enter the Employee ID");
                    EID = scanner.nextLine();
                    System.out.println("Enter the new first name");
                    EFN = scanner.nextLine();
                    System.out.println("Enter the new last name");
                    ELN = scanner.nextLine();

                    UpdateEmployees.updateEmployeeById(EID, EFN, ELN, connection);
                    System.out.println("Employee ID: " + EID + "has been updated to: " + EFN + " " + ELN);
                    break;
                case "2":
                    System.out.println("Enter the Employee First name");
                    EFN = scanner.nextLine();
                    System.out.println("Enter the new first name");
                    EmployeeFN = scanner.nextLine();
                    System.out.println("Enter the new last name");
                    EmployeeLN = scanner.nextLine();

                    UpdateEmployees.updateEmployeeByFirst(EFN, EmployeeFN, EmployeeLN, connection);
                    System.out.println(EmployeeFN + " " + "has been changed to: " + EmployeeFN + " " + EmployeeLN);

                    break;
                case "3":
                    System.out.println("Enter the Employee ID");
                    EID = scanner.nextLine();
                    UpdateEmployees.deleteEmployeeById(EID, connection);
                    System.out.println("Employee with ID: " + EID + " has been deleted.");
                    break;
                case "4":
                    System.out.println("Enter the Employee's first name");
                    EFN = scanner.nextLine();
                    System.out.println("Enter the Employee's last name");
                    ELN = scanner.nextLine();
                    UpdateEmployees.addEmployee(EFN, ELN, connection);
                    System.out.println("An employee with the name " + EFN + " " + ELN + " has been added.");
                    break;
                case "5":
                    UpdateEmployees.showEmployees(connection);
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
