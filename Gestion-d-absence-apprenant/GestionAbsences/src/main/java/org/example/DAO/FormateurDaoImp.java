package org.example.DAO;

import org.example.MysqlConnect.Connexion;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Objects;

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
        }finally {
            if(Connexion.connect() != null){
                Connexion.connect().close();
            }
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
    public String updateFormateur(String email, String password) throws SQLException {
        return null;
    }
}
