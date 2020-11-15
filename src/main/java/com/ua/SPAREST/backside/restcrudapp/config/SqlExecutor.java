package com.ua.SPAREST.backside.restcrudapp.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @author Bogush Aleksandr
 * @version 1.0
 * @since 15-11-2020
 */

@Component
public class SqlExecutor {
    private Connection connection;

    public SqlExecutor(
            @Value("${spring.datasource.url}") String dbUrl,
            @Value("${spring.datasource.username}") String dbUsername,
            @Value("${spring.datasource.password}") String dbPassword
    ) throws SQLException {
        try {
            this.connection = DriverManager.getConnection(dbUrl, dbUsername, dbPassword);
        }catch (SQLException ex){

           ex.getMessage();
        }
    }

    public Connection getConnection() {
        return connection;
    }
}
