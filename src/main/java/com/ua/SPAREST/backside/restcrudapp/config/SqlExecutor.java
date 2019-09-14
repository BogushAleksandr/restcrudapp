package com.ua.SPAREST.backside.restcrudapp.config;

import java.sql.*;

public class SqlExecutor {

    private String dbUrl = "jdbc:mysql://localhost:3306/ukeesstask?serverTimezone=Europe/Kiev";
    private String dbUsername = "root";
    private String dbPassword = "217!KaSGo!971";

    private final Connection connection;

    public SqlExecutor() throws ClassNotFoundException, SQLException {
        this.connection = DriverManager.getConnection(dbUrl, dbUsername, dbPassword);
    }

    public Connection getConnection() {
        return connection;
    }
}
