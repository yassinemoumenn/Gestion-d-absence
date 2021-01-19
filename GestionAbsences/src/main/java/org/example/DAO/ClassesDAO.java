package org.example.DAO;

import java.sql.ResultSet;
import java.sql.SQLException;

public interface ClassesDAO {

    ResultSet getClasses() throws SQLException;
    ResultSet getIndexof(String cl) throws SQLException;
}
