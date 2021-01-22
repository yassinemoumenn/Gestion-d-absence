package org.example.DAO;

import org.example.Model.Apprenant;
import org.example.Model.Formateur;
import org.example.MysqlConnect.Connexion;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Objects;

import static org.example.MysqlConnect.Connexion.connect;

public class AdminDaoImp  implements AdminDao{

    //role : get an user id (type student) and ref it to and class and sprciality
    @Override
    public String setApprenent(Apprenant apprenant) throws SQLException {
        try {
            var sql = "INSERT INTO `Students` (`user_id`, `classe_id`) VALUES(?,?);";
            PreparedStatement stmt = Objects.requireNonNull(connect()).prepareStatement(sql);
            stmt.setInt(1, apprenant.getUser_id());
            stmt.setInt(2, apprenant.getClass_id());
            stmt.executeUpdate();
            return "Done!";
        } catch (SQLException e) {
            return e.getMessage();
        } finally {
            if (connect() != null) {
                connect().close();
            }
        }
    }

    //Role: update class of an user type student
    @Override
    public String updateApprenent(Apprenant apprenant) throws SQLException {
        try {
            var sql = "UPDATE Students SET `classe_id` = ? WHERE id = ?";
            PreparedStatement stmt = Objects.requireNonNull(connect()).prepareStatement(sql);
            stmt.setInt(1, apprenant.getClass_id());
            stmt.setInt(2, apprenant.getId());
            stmt.executeUpdate();
            return "Done!";
        } catch (Exception e) {
            return e.getMessage();
        } finally {
            if (connect() != null) {
                Objects.requireNonNull(connect()).close();
            }
        }
    }

    //Role: get an user id (type : Formature) and ref in into a class
    @Override
    public String setFormateur(Formateur formateur) throws SQLException {
        try {
            var sql = "INSERT INTO `Teachers` (`user_id`, `classe_id`) VALUES(?,?)";
            PreparedStatement stmt = Objects.requireNonNull(connect()).prepareStatement(sql);
            stmt.setInt(1, formateur.getUser_id());
            stmt.setInt(2, formateur.getClass_id());
            stmt.executeUpdate();
            return "Done!";
        } catch (SQLException e) {
            return e.getMessage();
        } finally {
            if (connect() != null) {
                connect().close();
            }
        }
    }

    //Role: update class of an user type Formateur
    @Override
    public String updateFormateur(Formateur formateur) throws SQLException {
        try {
            var sql = "UPDATE Teachers SET `classe_id` = ? WHERE id = ?";
            PreparedStatement stmt = Objects.requireNonNull(connect()).prepareStatement(sql);
            stmt.setInt(1, formateur.getClass_id());
            stmt.setInt(2, formateur.getId());
            stmt.executeUpdate();
            return "Done!";
        } catch (Exception e) {
            return e.getMessage();
        } finally {
            if (connect() != null) {
                Objects.requireNonNull(connect()).close();
            }
        }
    }
}
