package com.ua.SPAREST.backside.restcrudapp.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@Component
public class SqlExecutor {
    private final Connection connection;

    public SqlExecutor(
            @Value("${spring.datasource.url}") String dbUrl,
            @Value("${spring.datasource.username}") String dbUsername,
            @Value("${spring.datasource.password}") String dbPassword
    ) throws SQLException {
        this.connection = DriverManager.getConnection(dbUrl, dbUsername, dbPassword);
    }

    public Connection getConnection() {
        return connection;
    }
}
