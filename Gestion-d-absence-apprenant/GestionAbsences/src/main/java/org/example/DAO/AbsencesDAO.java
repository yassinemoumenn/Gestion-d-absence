package org.example.DAO;

import javafx.collections.ObservableList;
import org.example.Model.Absences;

import java.sql.SQLException;

public interface AbsencesDAO {

    ObservableList<Absences> getStudenstAbsences(int student_id) throws SQLException;
}
