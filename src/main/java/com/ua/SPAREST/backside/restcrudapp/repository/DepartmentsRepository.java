package com.ua.SPAREST.backside.restcrudapp.repository;

import com.ua.SPAREST.backside.restcrudapp.config.SqlExecutor;
import com.ua.SPAREST.backside.restcrudapp.entity.Department;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Bogush Aleksandr
 * @version 1.0
 * @since 15-11-2020
 */

@Repository
public class DepartmentsRepository {

    private final SqlExecutor sqlExecutor;

    public DepartmentsRepository(SqlExecutor sqlExecutor) {
        this.sqlExecutor = sqlExecutor;
    }

    public Department findByPk(int pk) throws SQLException {
        try {
            Statement stmt = sqlExecutor.getConnection().createStatement();
            PreparedStatement preparedStatement = sqlExecutor.getConnection().prepareStatement(
                    "select tD.dpID, tD.dpName from tblDepartments tD where dpID = ?");
            preparedStatement.setInt(1, pk);

            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                int entityId = resultSet.getInt(1);
                String entityName = resultSet.getString(2);
                preparedStatement.close();
                return new Department(entityId, entityName);
            }
        } catch (SQLException e) {
            e.getMessage();
        }
        return null;
    }

    public List<Department> findAllDepartments() throws SQLException {
        try {
            PreparedStatement preparedStatement = sqlExecutor.getConnection().prepareStatement(
                    "select tD.dpID, tD.dpName from tblDepartments tD order by tD.dpID");
            ResultSet resultSet = preparedStatement.executeQuery();
            List<Department> listDepartments = new ArrayList<>();
            while (resultSet.next()) {
                Department department = new Department(resultSet.getInt(1), resultSet.getString(2));
                listDepartments.add(department);
            }
            preparedStatement.close();
            return listDepartments;
        } catch (SQLException e) {
            e.getMessage();
        }
        return null;
    }
}
