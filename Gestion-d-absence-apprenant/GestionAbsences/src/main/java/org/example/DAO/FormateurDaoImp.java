package org.example.DAO;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.example.Model.AffichageStudent;
import org.example.Model.Formateur;
import org.example.MysqlConnect.Connexion;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Objects;

import static org.example.MysqlConnect.Connexion.connect;

public class FormateurDaoImp implements FormateurDao {

    @Override
    public ResultSet get_By_id(int id) throws SQLException {
        try {
            String sql = "SELECT * FROM `Teachers` WHERE user_id= ? ";
            PreparedStatement stmt = Objects.requireNonNull(Connexion.connect()).prepareStatement(sql);
            stmt.setInt(1, id);
            System.out.println("Done");
            return stmt.executeQuery();
        } catch (SQLException e) {
            System.out.printf("Not Done");
        }
        return null;
    }

    @Override
    public ResultSet getAll() throws SQLException {
        return null;
    }

    @Override
    public String setFormateur(String email, String password) throws SQLException {
        return null;
    }

    @Override
    public void updateFormateur(Formateur formateur) throws SQLException {
        try {
            var sql = "UPDATE Teachers SET `classe_id`= ? WHERE user_id = ?";
            PreparedStatement stmt = Objects.requireNonNull(connect()).prepareStatement(sql);
            stmt.setInt(1, formateur.getClass_id());
            stmt.setInt(2, formateur.getUser_id());
            stmt.executeUpdate();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }


    @Override
    public ObservableList<AffichageStudent> AfficheStudentName() {
        ObservableList<AffichageStudent> AbsenceStudents= FXCollections.observableArrayList();
        try {
            String requete= "SELECT u.full_name, t.type FROM Users u INNER JOIN Students s ON u.id = s.user_id INNER JOIN Absences a ON s.id = a.Student_id INNER JOIN Absence_type t ON t.id = a.Absence_type WHERE u.type = 'Apprenant'";
            PreparedStatement statement = Objects.requireNonNull(Connexion.connect()).prepareStatement(requete);
            ResultSet rs = statement.executeQuery();
            AffichageStudent affichageStudent;
            while (rs.next()) {
                affichageStudent = new AffichageStudent(rs.getString("full_name"),rs.getString("type"));
                AbsenceStudents.add(affichageStudent);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return AbsenceStudents;
    }

}
