package com.Dylan;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import static com.Dylan.SqlUpdates.UpdateCustomers.CUSTOMER_SQL;

class SQLiteFunctions {
    Connection connection = Connect.connect();

    @Test
    void canReadFromTheDB() throws SQLException {
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(CUSTOMER_SQL);
        resultSet.getString("CLname");
        Assertions.assertEquals("knows", resultSet.getString("CLname"));
    }
}
