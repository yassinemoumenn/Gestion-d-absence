package org.example.DAO;

import org.example.Model.Formateur;
import org.example.MysqlConnect.Connexion;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Objects;

public abstract class FormateurDaoImp extends Connexion implements FormateurDao {


    @Override
    public ResultSet get_By_id(int id) throws SQLException {
        try {
            String sql = "SELECT * FROM `Teachers` WHERE id  = ?;";
            PreparedStatement stmt = Objects.requireNonNull(connect()).prepareStatement(sql);
            stmt.setInt(1,id);
            return stmt.executeQuery();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }finally {
            if(connect() != null){
                Objects.requireNonNull(connect()).close();
            }
        }
        return null;
    }

    @Override
    public ResultSet getAll() throws SQLException {
        try {
            Statement stmt = Objects.requireNonNull(connect()).createStatement();
            return stmt.executeQuery("SELECT * FROM Teachers");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }finally {
            if(connect() != null){
                Objects.requireNonNull(connect()).close();
            }
        }
        return null;
    }

    @Override
    public String set(Formateur Formateur) throws SQLException {
        try {
            String sql = "INSERT INTO Teachers (`id`, `user_id`,`classe_id`) VALUES (?,?);";
            PreparedStatement stmt = Objects.requireNonNull(connect()).prepareStatement(sql);
            stmt.setInt(1, Formateur.getId());
            stmt.setInt(2, Formateur.getUser_id());
            stmt.setInt(3, Formateur.getClass_id());
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
