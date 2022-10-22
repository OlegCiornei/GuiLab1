package com.company.services;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionService {

    public static Connection getConnection() {
        try {
            return DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "amogus", "aboba");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
