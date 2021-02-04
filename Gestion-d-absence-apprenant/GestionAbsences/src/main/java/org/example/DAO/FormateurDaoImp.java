package org.example.DAO;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.example.Model.Absence_type;
import org.example.Model.AffichageStudent;
import org.example.Model.Formateur;
import org.example.MysqlConnect.Connexion;

import java.sql.*;
import java.util.Objects;

public  class FormateurDaoImp extends Connexion implements FormateurDao{

    Statement statement=null;

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

    public void UpdateAbsence(int student_id, int absence_type) {
        try{
            String requete= "select * from Absences where Student_id = ?";
            PreparedStatement statement = Objects.requireNonNull(Connexion.connect()).prepareStatement(requete);
            statement.setInt(1, student_id);
            ResultSet rs = statement.executeQuery();
            boolean exists = false;
            while (rs.next()) {
                exists = true;
            }
            if (exists) {
                String rq = "update Absences set Absence_type = ? where Student_id = ?";
                PreparedStatement st = Objects.requireNonNull(connect()).prepareStatement(rq);
                st.setInt(2, student_id);

                st.setInt(1, absence_type);

                st.executeUpdate();
            } else {
                String rq = "INSERT INTO `Absences`( `Student_id`, `date`, `Absence_type`) VALUES (?,NOW(),?)";
                PreparedStatement st = Objects.requireNonNull(connect()).prepareStatement(rq);
                st.setInt(1, student_id);
                st.setInt(2, absence_type);

                st.execute();
            }

        }
        catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }

    @Override
    public ObservableList<Absence_type> GetTypes() {
        ObservableList<Absence_type> AbsencesTypes= FXCollections.observableArrayList();
        try {
            String requete= "SELECT  id , `type` AS type_ab FROM Absence_type";
            PreparedStatement statement = Objects.requireNonNull(Connexion.connect()).prepareStatement(requete);
            ResultSet rs = statement.executeQuery();
            Absence_type type;
            while (rs.next()) {
                type = new Absence_type (rs.getInt("id"),rs.getString("type_ab")) ;
                AbsencesTypes.add(type);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return AbsencesTypes;
    }

    @Override
    public ObservableList<AffichageStudent> AfficheStudentName() {
        ObservableList<AffichageStudent> AbsenceStudents = FXCollections.observableArrayList();
        try {
            String requete= "SELECT DISTINCT s.id, u.full_name, COALESCE(t.type, 'Present') AS type_ab FROM Users u INNER JOIN Students s ON u.id = s.user_id left JOIN Absences a ON s.id = a.student_id left JOIN Absence_type t ON t.id = a.absence_type INNER JOIN Teachers ts ON ts.classe_id =s.classe_id WHERE u.type = 'Apprenant'";
            PreparedStatement statement = Objects.requireNonNull(Connexion.connect()).prepareStatement(requete);
            ResultSet rs = statement.executeQuery();
            AffichageStudent affichageStudent;
            while (rs.next()) {
                System.out.println(rs.getString("full_name"));
                System.out.println(rs.getString("type_ab"));
                affichageStudent = new AffichageStudent(rs.getInt("id") ,rs.getString("full_name"),rs.getString("type_ab"));
                AbsenceStudents.add(affichageStudent);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return AbsenceStudents;
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
}