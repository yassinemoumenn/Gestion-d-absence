package org.example.DAO;

import java.sql.ResultSet;
import java.sql.SQLException;

public interface FormateurDao {
    ResultSet get_By_id(int id) throws SQLException;

    ResultSet getAll() throws SQLException;

    // String setApprenent(Apprenant apprenant) throws SQLException;

//    String setAbsence(Absences absences) throws SQLException;

    String setFormateur(String email,String password) throws SQLException;

    String updateFormateur(String email,String password) throws SQLException;

//    public ObservableList<AffichageStudent>AfficheStudentName();
}
