package com.ua.SPAREST.backside.restcrudapp;

import com.ua.SPAREST.backside.restcrudapp.config.AppConfig;
import com.ua.SPAREST.backside.restcrudapp.config.SqlExecutor;
import com.ua.SPAREST.backside.restcrudapp.entity.Department;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import java.sql.SQLException;

@Import({AppConfig.class})
@SpringBootApplication
public class Main {

	public static void main(String[] args) {
		SpringApplication.run(Main.class, args);
	}

}
