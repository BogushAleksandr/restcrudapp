package com.ua.SPAREST.backside.restcrudapp.config;

import com.ua.SPAREST.backside.restcrudapp.entity.Department;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;

import java.sql.*;
import java.util.List;

public class SqlExecutor {

    @Value("${spring.datasource.url}")
    private String dbUrl = "jdbc:mysql://localhost:3306/ukeesstask?serverTimezone=Europe/Kiev";
    @Value("${spring.datasource.username}")
    private String dbUsername = "root";
    @Value("${spring.datasource.password}")
    private String dbPassword = "217!KaSGo!971";

    private final Connection connection;

    public SqlExecutor() throws ClassNotFoundException, SQLException {
        this.connection = DriverManager.getConnection(dbUrl, dbUsername, dbPassword);
    }

    public Connection getConnection() {
        return connection;
    }
}
