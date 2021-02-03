package org.example.DAO;

import org.example.Model.classes;

import java.sql.ResultSet;
import java.sql.SQLException;

public interface ClassesDAO {

    ResultSet getClasses() throws SQLException;
    ResultSet getIndexof(String cl) throws SQLException;
    ResultSet getClassById(int id) throws   SQLException;
    void deleteById(int id) throws SQLException;
    String setClass(classes classes) throws SQLException;
}
