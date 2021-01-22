package org.example.DAO;

import org.example.Model.Apprenant;
import org.example.MysqlConnect.Connexion;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Objects;


public class ApprenantDaoImp implements ApprenantDao {


    @Override
    public ResultSet getById(int id) throws ClassNotFoundException, SQLException {
        try {
            String sql = "SELECT * FROM `Students` WHERE user_id= ? ";
            PreparedStatement stmt = Objects.requireNonNull(Connexion.connect()).prepareStatement(sql);
            stmt.setInt(1, id);
            System.out.printf("Done");
            return stmt.executeQuery();
        } catch (SQLException e) {
            System.out.printf("Not Done");
        }finally {
            if(Connexion.connect() != null){
                Connexion.connect().close();
            }
        }
        return null;
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

