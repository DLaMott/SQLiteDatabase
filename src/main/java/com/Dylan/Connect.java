package com.Dylan;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/***
 * Required for connecting to a SQLITE database
 */
public class Connect {
    /***
     *
     * @return a {@link Connection} for {@link SQLiteOutput}
     */
    public static Connection connect() {
        Connection conn = null;

        try {
            Class.forName("org.sqlite.JDBC");
            String url = "jdbc:sqlite:project.db";
            conn = DriverManager.getConnection(url);
            if (conn != null) {
                System.out.println("Connection made");
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return conn;
    }
}