package com.ua.SPAREST.backside.restcrudapp.repository;

import com.ua.SPAREST.backside.restcrudapp.config.SqlExecutor;
import com.ua.SPAREST.backside.restcrudapp.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class EmployeeRepository {
    @Autowired
    private SqlExecutor sqlExecutor;


    public Employee findByPk(int id) throws SQLException {
        return resultId(id);
    }

    public List<Employee> findAllEmployee() throws SQLException {
        PreparedStatement preparedStatement = sqlExecutor.getConnection().prepareStatement(
                "select * from tblEmployees");
        try {
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
        } catch (SQLException e) {
            e.getMessage();
        } finally {
            preparedStatement.close();
        }
        return null;
    }

    public int editEmployee(Employee employee) throws SQLException {
        PreparedStatement preparedStatement = sqlExecutor.getConnection().prepareStatement(
                "update tblEmployees set empName = ?, empActive = ?, emp_dpID = ? where empID = ?");
        try {
            preparedStatement.setInt(4, employee.getId());
            preparedStatement.setString(1, employee.getFirstName());
            preparedStatement.setBoolean(2, employee.isActive());
            preparedStatement.setInt(3, employee.getDepartmentID());
            return preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.getMessage();
        } finally {
            preparedStatement.close();
        }
        return 0;
    }


    public String createEmployee(Employee employee) throws SQLException {
        PreparedStatement preparedStatement = sqlExecutor.getConnection().prepareStatement(
                "insert into tblEmployees (empName, empActive, emp_dpID) VALUES (?,?,?)");
        try {
            preparedStatement.setString(1, employee.getFirstName());
            preparedStatement.setBoolean(2, employee.isActive());
            preparedStatement.setInt(3, employee.getDepartmentID());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.getMessage();
        } finally {
            preparedStatement.close();
        }
        return "201";
    }

    public String deleteEmployee(Employee employee) throws SQLException {
        PreparedStatement preparedStatement = sqlExecutor.getConnection().prepareStatement(
                "delete from tblEmployees  where empID = ?");
        try {
            preparedStatement.setInt(1, employee.getId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.getMessage();
        } finally {
            preparedStatement.close();
        }
        return "204";
    }

    public List<Employee> searchNameEmployee(String name){
        try {
            return resultSearchEmployee(name);
        } catch (SQLException e) {
            e.getMessage();
        }

        return null;
    }

    private Employee resultId(int id) throws SQLException {
        PreparedStatement preparedStatement = sqlExecutor.getConnection().prepareStatement(
                "select * from tblEmployees where empID = ?");
        preparedStatement.setInt(1, id);
        try {
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                return new Employee(resultSet.getInt(1),
                        resultSet.getString(2),
                        resultSet.getBoolean(3),
                        resultSet.getInt(4)
                );
            }

        } catch (SQLException e) {
            e.getMessage();
        } finally {
            preparedStatement.close();
        }
        return null;
    }

    private List<Employee> resultSearchEmployee(String name) throws SQLException {
        List<Employee> listEmployee = new ArrayList<>();

        PreparedStatement preparedStatement = sqlExecutor.getConnection().prepareStatement(
                "select * from tblEmployees where empName like ?");

        preparedStatement.setString(1, name + '%');
        try {
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Employee employee = new Employee(resultSet.getInt(1),
                        resultSet.getString(2),
                        resultSet.getBoolean(3),
                        resultSet.getInt(4)
                );
                listEmployee.add(employee);
            }
            return listEmployee;

        } catch (SQLException e) {
            e.getMessage();
        } finally {
            preparedStatement.close();
        }
        return null;
    }


}

