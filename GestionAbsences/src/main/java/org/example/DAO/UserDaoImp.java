package org.example.DAO;

import org.example.Model.Users;
import org.example.MysqlConnect.Connexion;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Objects;

public class UserDaoImp extends Connexion implements UserDao{

    @Override
    public String create(Users user) throws SQLException {
        try {
            var sql = "INSERT INTO `Users`( `full_name`, `email`, `password`, `type`) VALUES (?,?,?,?);";
            PreparedStatement stmt = Objects.requireNonNull(connect()).prepareStatement(sql);
            stmt.setString(1, user.getFull_name());
            stmt.setString(2, user.getEmail());
            stmt.setString(3, user.getPassword());
            stmt.setString(4, user.getType());
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
    public String deleteById(int id) throws SQLException {
        try {
            var sql = "DELETE FROM Users WHERE id =?;";
            PreparedStatement stmt = Objects.requireNonNull(connect()).prepareStatement(sql);
            stmt.setInt(1, id);
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
    public String update(Users user) throws SQLException {
        try {
            var sql = "UPDATE Users SET `password`= ?, `email` = ? WHERE id = ?";
            PreparedStatement stmt = Objects.requireNonNull(connect()).prepareStatement(sql);
            stmt.setString(1, user.getPassword());
            stmt.setString(2, user.getEmail());
            stmt.setInt(3, user.getId());
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
    public ResultSet getByType(String type) throws SQLException {
        try {
            var sql = "SELECT * FROM Users WHERE type ='"+ type +"';";
            PreparedStatement stmt = Objects.requireNonNull(connect()).prepareStatement(sql);
            return stmt.executeQuery();
        } catch (Exception e) {
            e.getMessage();
        }finally {
            if(connect() != null){
                Objects.requireNonNull(connect()).close();
            }
        }
        return null;
    }

}
