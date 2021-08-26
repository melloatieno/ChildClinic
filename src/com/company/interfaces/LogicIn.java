package com.company.interfaces;


import java.sql.ResultSet;
import java.sql.SQLException;

public interface LogicIn <T>{
    boolean add(T t) throws SQLException;
    boolean update(T t, int bookId) throws SQLException;

    abstract ResultSet read(T t) throws SQLException;
    abstract boolean delete(T t) throws SQLException;
    abstract ResultSet search(String sql) throws SQLException;

    public abstract ResultSet displayAll() throws SQLException;
}
