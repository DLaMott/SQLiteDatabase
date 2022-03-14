package com.Dylan.SqlEdits;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class SQLiteTableLoad {

    public static final String EMPLOYEE_TABLE = "CREATE TABLE IF NOT EXISTS Employees ("
            + "EID INTEGER PRIMARY KEY AUTOINCREMENT,"
            + " EFname TEXT,"
            + " ELname TEXT)";

    public static final String INVENTORY_TABLE = "CREATE TABLE IF NOT EXISTS Inventory ("
            + "IID INTEGER PRIMARY KEY AUTOINCREMENT," + " IDesc TEXT,"
            + " IPrice DECIMAL(10,2))";
    public static final String CUSTOMER_TABLE = "CREATE TABLE IF NOT EXISTS Customers ("
            + "CID INTEGER PRIMARY KEY AUTOINCREMENT,"
            + " CFname TEXT,"
            + " CLname TEXT)";
    public static final String SALES_TABLE = "CREATE TABLE IF NOT EXISTS Sales ("
            + "SID INTEGER PRIMARY KEY AUTOINCREMENT,"
            + " SQty INTEGER,"
            + " STotal DECIMAL(10,2),"
            + " CID INTEGER,"
            + " IID INTEGER,"
            + " EID INTEGER, "
            + " FOREIGN KEY(IID) REFERENCES Inventory(IID),"
            + " FOREIGN KEY(EID) REFERENCES Employees(EID),"
            + " FOREIGN KEY(CID) REFERENCES Customers(CID))";

    /***
     * Method intended to create SQlite tables.
     * @param connection connection source to the database
     * @param sql sql statement
     * @throws SQLException upon invalid sql and or no database connection
     */
    public static void createTable(Connection connection, String sql) throws SQLException {
        Statement statement = connection.createStatement();
        statement.executeUpdate(sql);
    }
}
