package org.example.DAO;

import org.example.Model.Apprenant;
import org.example.Model.Formateur;
import org.example.MysqlConnect.Connexion;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Objects;


public class AdminDaoImp extends Connexion implements AdminDao{

    @Override
    public String setApprenent(Apprenant apprenant) throws SQLException {
        try {
            var sql = "INSERT INTO `Students` (`user_id`, `classe_id`, `speciality_id`) VALUES(?,?,?)";
            PreparedStatement stmt = Objects.requireNonNull(connect()).prepareStatement(sql);
            stmt.setInt(1, apprenant.getUser_id());
            stmt.setInt(2, apprenant.getClass_id());
            stmt.setInt(3, apprenant.getSpeciality_id());
            stmt.executeUpdate();
            return "Done!";
        } catch (SQLException e) {
            return e.getMessage();
        }finally {
            if(connect() != null){
                connect().close();
            }
        }
    }

    @Override
    public String updateApprenent(Apprenant apprenant) throws SQLException {
        try {
            var sql = "UPDATE Students SET `classe_id` = ?, `speciality_id`= ? WHERE id = ?";
            PreparedStatement stmt = Objects.requireNonNull(connect()).prepareStatement(sql);
            stmt.setInt(1, apprenant.getClass_id());
            stmt.setInt(2, apprenant.getSpeciality_id());
            stmt.setInt(3, apprenant.getId());
            stmt.executeUpdate();
            return "Done!";
        } catch (Exception e) {
            return e.getMessage();
        }finally {
            if(connect() != null){
                Objects.requireNonNull(connect()).close();
            }
        }
    }

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
        }finally {
            if(connect() != null){
                connect().close();
            }
        }
    }

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
        }finally {
            if(connect() != null){
                Objects.requireNonNull(connect()).close();
            }
        }
    }
}
