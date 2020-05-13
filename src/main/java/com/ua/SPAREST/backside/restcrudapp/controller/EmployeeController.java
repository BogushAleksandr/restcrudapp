package com.ua.SPAREST.backside.restcrudapp.controller;

import com.ua.SPAREST.backside.restcrudapp.entity.Employee;
import com.ua.SPAREST.backside.restcrudapp.repository.EmployeeRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;

@Api(value = "Employee Controller", description = "Controller for Employee")
@RestController
@RequestMapping(path = "/emp")
public class EmployeeController {
    private final EmployeeRepository employeeRepository;

    public EmployeeController(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @ApiOperation(value = "Check of employee by id")
    @GetMapping("/{id}")
    public Employee employee(@PathVariable int id) throws SQLException {
        return employeeRepository.findByPk(id);
    }

    @ApiOperation(value = "View all employee")
    @GetMapping("/allEmployee")
    public List<Employee> employeeAll(@RequestParam int page, @RequestParam int pageSize) throws SQLException {
        return employeeRepository.findAllEmployee(page, pageSize);
    }

    @ApiOperation(value = "Edit employee")
    @PutMapping("/editEmployee")
    public int editEmployee(@RequestBody Employee employee) throws SQLException {
        return employeeRepository.editEmployee(employee);
    }

    @ApiOperation(value = "Create Employee")
    @PostMapping("/createEmployee")
    public Employee createEmployee(@RequestBody Employee employee) throws SQLException {
        return employeeRepository.createEmployee(employee);
    }

    @ApiOperation(value = "Delete Employee")
    @DeleteMapping("/deleteEmployee")
    public Employee deleteEmployee(@RequestParam int id) throws SQLException {
        return employeeRepository.deleteEmployee(id);
    }

    @ApiOperation(value = "Search Employee")
    @GetMapping("/search")
    public List<Employee> searchEmployee(@RequestParam String name) {
        if (name.isEmpty()) {
            return null;
        } else
            return employeeRepository.searchNameEmployee(name);
    }

}
