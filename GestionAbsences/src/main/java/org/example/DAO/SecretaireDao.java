package org.example.DAO;

import org.example.Model.Users;

import java.sql.ResultSet;
import java.sql.SQLException;

public interface SecretaireDao {
    ResultSet get_By_id(int id) throws SQLException;


    ResultSet getAll() throws SQLException;

    String set(Users users) throws SQLException;

    String set() throws SQLException;
}
