package com.company.services;

import com.company.model.entities.Role;
import com.company.model.entities.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import static com.company.services.ConnectionService.getConnection;
import static java.util.Objects.nonNull;

public class UserService {

    public User getUser(final String userName, final String password) throws SQLException {
        final Connection connection = getConnection();

        final String sql = "Select email, password, role from t_users where email=? and password=?";
        final PreparedStatement loginStatement = connection.prepareStatement(sql);

        loginStatement.setString(1, userName);
        loginStatement.setString(2, password);
        final ResultSet resultSet = loginStatement.executeQuery();

        return nonNull(resultSet) ? extractUser(resultSet) : null;
    }

    private User extractUser(final ResultSet resultSet) throws SQLException {
        if (resultSet.next()) {
            return User.builder()
                    .userName(resultSet.getString(1))
                    .password(resultSet.getString(2))
                    .role(Role.valueOf(resultSet.getString(3)))
                    .build();
        }
        return null;
    }
}
