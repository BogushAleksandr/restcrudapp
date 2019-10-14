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

    @PostMapping("/createEmployee")
    public Employee createEmployee(@RequestBody Employee employee) throws SQLException {
        System.out.println(employee.getFirstName());

        return employeeRepository.createEmployee(employee);
    }

    @DeleteMapping("/deleteEmployee")
    public Employee deleteEmployee(@RequestParam int id) throws SQLException {
        return employeeRepository.deleteEmployee(id);
    }

    @GetMapping("/search")
    public List<Employee> searchEmployee(@RequestParam String name) {
        if (name.isBlank()) {
            return null;
        } else
            return employeeRepository.searchNameEmployee(name);
    }

}
