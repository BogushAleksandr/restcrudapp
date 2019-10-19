package com.ua.SPAREST.backside.restcrudapp.controller;

import com.ua.SPAREST.backside.restcrudapp.entity.Department;
import com.ua.SPAREST.backside.restcrudapp.repository.DepartmentsRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.SQLException;
import java.util.List;

@Api(value = "Department Controller", description = "Controller for Test check of department by id and View all departments")
@RestController
@RequestMapping(path = "/department")
public class DepartmentController {

    @Autowired
    private DepartmentsRepository departmentsRepository;

    @ApiOperation(value = "Test check of department by id")
    @GetMapping(path = "/wel")
    public Department welcome() throws SQLException {
        return departmentsRepository.findByPk(2);
    }

    @ApiOperation(value = "View all departments")
    @GetMapping("/all")
    public List<Department> departmentsAll() throws SQLException {
        return departmentsRepository.findAllDepartments();
    }

}
