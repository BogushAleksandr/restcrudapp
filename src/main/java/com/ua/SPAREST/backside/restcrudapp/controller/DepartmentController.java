package com.ua.SPAREST.backside.restcrudapp.controller;

import com.ua.SPAREST.backside.restcrudapp.entity.Department;
import com.ua.SPAREST.backside.restcrudapp.repository.DepartmentsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.SQLException;
import java.util.List;

@RestController
@RequestMapping(path = "/hel")
public class DepartmentController {

    @Autowired
    private DepartmentsRepository departmentsRepository;

    @GetMapping(path = "/wel")
    public Department welcome() throws SQLException {
        return departmentsRepository.findByPk(2);
    }

    @GetMapping("/all")
    public List<Department> departmentsAll() throws SQLException {
        return departmentsRepository.findAllDepartments();
    }

}
