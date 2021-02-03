package org.example.DAO;

import org.example.Model.Apprenant;
import org.example.MysqlConnect.Connexion;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Objects;

import static org.example.MysqlConnect.Connexion.connect;


public class ApprenantDaoImp implements ApprenantDao {


    @Override
    public ResultSet getById(int id) throws ClassNotFoundException, SQLException {
        try {
            String sql = "SELECT * FROM `Students` WHERE user_id = ?";
            PreparedStatement stmt = Objects.requireNonNull(Connexion.connect()).prepareStatement(sql);
            stmt.setInt(1, id);
            return stmt.executeQuery();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    @Override
    public void updateClass(Apprenant apprenant) throws SQLException {
        try {
            var sql = "UPDATE Students SET `classe_id`= ? WHERE user_id = ?";
            PreparedStatement stmt = Objects.requireNonNull(connect()).prepareStatement(sql);
            stmt.setInt(1, apprenant.getClass_id());
            stmt.setInt(2, apprenant.getUser_id());
            stmt.executeUpdate();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public String setApprenant(Apprenant apprenant) throws SQLException {
        return null;
    }

    @Override
    public List<Apprenant> getAll() throws ClassNotFoundException, SQLException {
        return null;
    }

    @Override
    public String getBySpeciality(String speciality) throws ClassNotFoundException, SQLException {
        return null;
    }


}

