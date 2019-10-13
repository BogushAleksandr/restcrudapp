package com.ua.SPAREST.backside.restcrudapp.repository;

import com.ua.SPAREST.backside.restcrudapp.config.SqlExecutor;
import com.ua.SPAREST.backside.restcrudapp.entity.Department;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

@Repository
public class DepartmentsRepository {

    @Autowired
    private SqlExecutor sqlExecutor;

    public Department findByPk(int pk) throws SQLException {
        Statement stmt = sqlExecutor.getConnection().createStatement();
        PreparedStatement preparedStatement = sqlExecutor.getConnection().prepareStatement(
                "select * from tblDepartments where dpID = ?");
        preparedStatement.setInt(1, pk);

        ResultSet resultSet = preparedStatement.executeQuery();
        if (resultSet.next()) {
            int entityId = resultSet.getInt(1);
            String entityName = resultSet.getString(2);
            return new Department(entityId, entityName);
        }
       return null;
    }

    public List<Department> findAllDepartments() throws SQLException {
        PreparedStatement preparedStatement = sqlExecutor.getConnection().prepareStatement("select * from tblDepartments");
        ResultSet resultSet = preparedStatement.executeQuery();
        List<Department> listDepartments = new ArrayList<>();
        while (resultSet.next()) {
            Department department = new Department(resultSet.getInt(1),resultSet.getString(2));
            listDepartments.add(department);
        }
        return listDepartments;
    }
}
