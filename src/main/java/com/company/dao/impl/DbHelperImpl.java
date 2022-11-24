package com.company.dao.impl;

import com.company.dao.DbHelper;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DbHelperImpl implements DbHelper {
        String url = "jdbc:postgresql://localhost:5432/app_db";
        String user = "postgres";
        String password = "231366skl";
        @Override
        public PreparedStatement getConnection(String sql) {
            try {
                Connection connection= DriverManager.getConnection(url,user,password);
                return connection.prepareStatement(sql);

            } catch (SQLException e) {
                throw new RuntimeException(e.getMessage());
            }
        }
    }

