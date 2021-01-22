package org.example.DAO;

import org.example.MysqlConnect.Connexion;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Objects;

public interface ApprenantDao{
    ResultSet getByUserId(int id) throws SQLException;

}
