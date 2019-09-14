package com.ua.SPAREST.backside.restcrudapp.controller;

import com.ua.SPAREST.backside.restcrudapp.entity.Employee;
import com.ua.SPAREST.backside.restcrudapp.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;

@RestController
@RequestMapping(path = "/emp")
public class EmployeeController {
    @Autowired
    private EmployeeRepository employeeRepository;

    @GetMapping("/{id}")
    public Employee employee(@PathVariable int id) throws SQLException {
        return employeeRepository.findByPk(id);
    }

    @GetMapping("/allEmployee")
    public List<Employee> employeeAll() throws SQLException {
        return employeeRepository.findAllEmployee();
    }
    @PutMapping("/editEmployee")
    public int editEmployee(@RequestBody Employee employee) throws SQLException {
        return employeeRepository.editEmployee(employee);
    }


}
