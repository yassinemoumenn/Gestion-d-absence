package org.example.DAO;

import org.example.Model.Users;

import java.sql.ResultSet;
import java.sql.SQLException;

public interface UserDao {
    String create(Users user) throws SQLException;

    String deleteById(int id) throws SQLException;


    String update(Users user) throws SQLException;


    ResultSet getByType(String type) throws SQLException;

    ResultSet  getIndex(Users usr) throws SQLException;

    ResultSet getUserById(int id) throws SQLException;


}