package com.coherentsolutions.utils;

import java.sql.*;

public class DBUtility {
    protected Connection connection;
    private static final String URL = "jdbc:h2:mem:test";
    private static final String USERNAME = "nk";
    private static final String PASSWORD = "nk";


    public DBUtility() {
        try {
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    protected ResultSet executeQuery(String query) {
        ResultSet resultSet = null;
        try {
            Statement statement = connection.createStatement();
            resultSet = statement.executeQuery(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resultSet;
    }

    protected void executeUpdate(String query) {
        try {
            Statement statement = connection.createStatement();
            statement.executeUpdate(query);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}