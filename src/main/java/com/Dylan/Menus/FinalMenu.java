package com.Dylan.Menus;

import java.sql.Connection;
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

    public static void finalMenu(Connection connection){

        if (!isValid){
            isValid = true;
        }

        while(isValid){
            Scanner scanner = new Scanner(System.in);
            System.out.println(FINAL_MENU);
            String input = scanner.nextLine();

            switch (input){
                case "1":
                    break;
                case "2":
                    break;
                case "3":
                    break;
                case "4":
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
