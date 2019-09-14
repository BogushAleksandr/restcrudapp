package com.ua.SPAREST.backside.restcrudapp.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.sql.SQLException;

@Configuration
public class AppConfig {
    @Bean
    public SqlExecutor sqlExecutor() throws SQLException, ClassNotFoundException {
        return new SqlExecutor();
    }
}
