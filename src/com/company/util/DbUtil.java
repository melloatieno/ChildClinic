package com.company.util;

import java.sql.*;

public class DbUtil {
    //Open connection
    //Execute a query (read/ write)
    //Close connection
    final String className = "com.mysql.jdbc.Driver";
    private Connection connection;
    private Statement statement;

    final String url = "jdbc:mysql://localhost:3306/clinic";
    final String root = "root";
    final String password = "";

    public DbUtil() throws ClassNotFoundException, SQLException {
        Class.forName(className);
        connection = DriverManager.getConnection(url,root,password);
    }
    public ResultSet readData(String query) throws SQLException {
        statement = connection.createStatement();
        return statement.executeQuery(query);
    }
    public int create(String sql) throws SQLException {
        return statement.executeUpdate(sql);
    }
    public int writeData(String query) throws SQLException {
        statement = connection.createStatement();
        return statement.executeUpdate(query);
    }
    public boolean update(String sql) throws SQLException {
        return (statement.executeUpdate(sql) == 0)?false:true;
    }
    public boolean delete(String sql) throws SQLException {
        return (statement.executeUpdate(sql) == 0)?false:true;
    }
    public void closeConnection () throws SQLException {
        statement.close();
        connection.close();
    }

}
