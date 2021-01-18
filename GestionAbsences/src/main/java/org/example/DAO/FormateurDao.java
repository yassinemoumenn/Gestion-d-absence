package org.example.DAO;

import org.example.Model.Formateur;
import org.example.Model.Apprenant;
import org.example.Model.Users;
import java.sql.ResultSet;
import java.sql.SQLException;

public interface FormateurDao {

    ResultSet get_By_id(int id) throws SQLException;


    ResultSet getAll() throws SQLException;

    int set(Formateur Formateur) throws SQLException;



}
