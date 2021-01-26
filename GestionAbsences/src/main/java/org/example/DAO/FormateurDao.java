package org.example.DAO;

import javafx.collections.ObservableList;
import org.example.Model.*;
import java.sql.ResultSet;
import java.sql.SQLException;


public interface FormateurDao {

    ResultSet get_By_id(int id) throws SQLException;

    ResultSet getAll() throws SQLException;


    String setAbsence(Absences absences) throws SQLException;

    public ObservableList<AffichageStudent>AfficheStudentName();
}
