package com.ua.SPAREST.backside.restcrudapp.repository;

import com.ua.SPAREST.backside.restcrudapp.config.SqlExecutor;
import com.ua.SPAREST.backside.restcrudapp.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

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
}
