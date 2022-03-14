package com.Dylan;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

public class UserMenu {

    public static void menu(Connection connection) throws SQLException {
        System.out.println("Welcome to the DB Connection tool");
        System.out.println("Please choose fom the following:");
        System.out.println("1.Edit\n2.Delete\n3.New Entry\n4. Show all tables \n5. Exit");


        boolean isValid = true;

        while (isValid){

            Scanner scanner = new Scanner(System.in);
            String idk = scanner.nextLine();

            switch (idk){
                case "1":
                    System.out.println("It works");
                    menu(connection);
                    break;
                case "2":
                    System.out.println("2 Works");
                    menu(connection);
                    break;
                case "3":
                    System.out.println("3 works!");
                    break;
                case "4":
                    SQLiteOutput.sqliteEmployeeOutput(connection, SQLiteOutput.EMPLOYEE_SQL);
                    SQLiteOutput.sqliteCustomerOutput(connection, SQLiteOutput.CUSTOMER_SQL);
                    SQLiteOutput.sqliteInventoryOutput(connection, SQLiteOutput.INVENTORY_SQL);
                    SQLiteOutput.sqliteSalesOutput(connection, SQLiteOutput.SALES_SQL);
                    UserMenu.menu(connection);
                    break;
                default:
                    System.out.println("Good bye!");
                    isValid = false;
                    scanner.close();
                    break;

            }
        }
    }
}
