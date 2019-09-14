package com.ua.SPAREST.backside.restcrudapp.controller;

import com.ua.SPAREST.backside.restcrudapp.entity.Employee;
import com.ua.SPAREST.backside.restcrudapp.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.SQLException;

@RestController
@RequestMapping(path = "/emp")
public class EmployeeController {
    @Autowired
    private EmployeeRepository employeeRepository;

    @GetMapping
    public Employee employee() throws SQLException {
        return employeeRepository.findByPk(4);
    }
}
