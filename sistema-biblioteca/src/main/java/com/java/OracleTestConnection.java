package com.java;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class OracleTestConnection {
    public static void main(String[] args) {
        String jdbcUrl = "jdbc:oracle:thin:@localhost:1521:XE";
        String user = "sys as sysdba";
        String password = "pass1234";

        try (Connection conn = DriverManager.getConnection(jdbcUrl, user, password)) {
            System.out.println("se conecto");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}