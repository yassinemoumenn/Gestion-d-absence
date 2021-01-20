package org.example.DAO;

//import DAO.AdminDao;
import org.example.DAO.UserDao;
import org.example.Model.Apprenant;

import org.example.MysqlConnect.Connexion;

import org.example.Model.Secretaire;
import org.example.MysqlConnect.Connexion;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Objects;

public abstract class SecretaireDaoImp extends Connexion implements SecretaireDao {


    @Override
    public ResultSet get_By_id(int id) throws SQLException {
        try {
            String sql = "SELECT * FROM Users WHERE  id = ?;";
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
            return stmt.executeQuery("SELECT * FROM Users;");
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
    public String set() throws SQLException {
        try {
            String sql = "INSERT INTO students (`Student_id`,`absence_id`,`absence_type`) VALUES (?,?);";
            PreparedStatement stmt = Objects.requireNonNull(connect()).prepareStatement(sql);
            stmt.setInt(1, Apprenant.getId());
            stmt.setString(2, Apprenant.getUser_id());
            stmt.setString(3, Apprenant.getClass_id());

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





