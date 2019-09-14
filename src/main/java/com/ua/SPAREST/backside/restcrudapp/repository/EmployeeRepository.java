package com.ua.SPAREST.backside.restcrudapp.repository;

import com.ua.SPAREST.backside.restcrudapp.config.SqlExecutor;
import com.ua.SPAREST.backside.restcrudapp.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

@Repository
public class EmployeeRepository {
    @Autowired
    private SqlExecutor sqlExecutor;

    public Employee findByPk(int id) throws SQLException {
        PreparedStatement preparedStatement = sqlExecutor.getConnection().prepareStatement(
                "select * from tblEmployees where empID = ?");
        preparedStatement.setInt(1, id);
        ResultSet resultSet = preparedStatement.executeQuery();
        if (resultSet.next()) {
            return new Employee(resultSet.getInt(1),
                    resultSet.getString(2),
                    resultSet.getBoolean(3),
                    resultSet.getInt(4)
            );
        } else return null;
    }

    public List<Employee> findAllEmployee() throws SQLException {
        PreparedStatement preparedStatement = sqlExecutor.getConnection().prepareStatement("select * from tblEmployees");
        ResultSet resultSet = preparedStatement.executeQuery();
        List<Employee> listEmployee = new ArrayList<>();
        while (resultSet.next()) {
            Employee employee = new Employee(resultSet.getInt(1),
                    resultSet.getString(2),
                    resultSet.getBoolean(3),
                    resultSet.getInt(4)
            );
            listEmployee.add(employee);
        }
        return listEmployee;
    }

    public int editEmployee(Employee employee) throws SQLException {
        PreparedStatement preparedStatement = sqlExecutor.getConnection().prepareStatement(
                "update tblEmployees set empName = ?, empActive = ?, emp_dpID = ? where empID = ?");
        preparedStatement.setInt(4, employee.getId());
        preparedStatement.setString(1, employee.getFirstName());
        preparedStatement.setBoolean(2, employee.isActive());
        preparedStatement.setInt(3, employee.getDepartmentID());
        return preparedStatement.executeUpdate();

    }

    public String createEmployee(Employee employee) throws SQLException {
        PreparedStatement preparedStatement = sqlExecutor.getConnection().prepareStatement(
                "insert into tblEmployees (empName, empActive, emp_dpID) VALUES (?,?,?)");
        preparedStatement.setString(1, employee.getFirstName());
        preparedStatement.setBoolean(2, employee.isActive());
        preparedStatement.setInt(3, employee.getDepartmentID());
        preparedStatement.executeUpdate();
        return "201";
    }

    public String deleteEmployee(Employee employee) throws SQLException {
        PreparedStatement preparedStatement = sqlExecutor.getConnection().prepareStatement(
                "delete from tblEmployees  where empID = ?");
        preparedStatement.setInt(1,employee.getId());
        preparedStatement.executeUpdate();
        return "204";
    }

}

