package org.example.DAO;


import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.example.Model.Absences;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Objects;

import static org.example.MysqlConnect.Connexion.connect;

public class AbsencesDAOImpl implements AbsencesDAO {
    @Override
    public ObservableList<Absences> getStudenstAbsences(int student_id) throws SQLException {
        ObservableList<Absences> absences = FXCollections.observableArrayList();
        try {
            String sql = "SELECT a.date, t.type FROM `Absences` a LEFT JOIN  Absence_type t ON a.Absence_type = t.id WHERE Student_id =?";
            PreparedStatement stmt = Objects.requireNonNull(connect()).prepareStatement(sql);
            stmt.setInt(1, student_id);
            ResultSet abs = stmt.executeQuery();
            while (abs.next()) {
                System.out.println(abs.getDate("date").toString() +" " + abs.getString("type"));
                absences.add(new Absences(abs.getDate("date").toString(), abs.getString("type")));
            }
            return absences;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return null;
    }
}
