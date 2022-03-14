package com.Dylan;

import com.Dylan.Application.Connect;
import org.junit.jupiter.api.Test;
import java.sql.Connection;

import static org.junit.jupiter.api.Assertions.*;

class ConnectTest {
    @Test
    void ConnectionIsMade(){
        Connection connect = Connect.connect();
        assertNotNull(connect);
    }
}