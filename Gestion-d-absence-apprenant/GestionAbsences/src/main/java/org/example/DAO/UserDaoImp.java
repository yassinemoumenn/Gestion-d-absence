package org.example.DAO;

import org.example.Model.Users;
import org.example.MysqlConnect.Connexion;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Objects;

import static org.example.MysqlConnect.Connexion.connect;

public class UserDaoImp  implements UserDao{
    // Role: create new user
    //info require: full name, email, password,type(student, formateur or secritier)
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
        }
    }

    // role: delete user by his id
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
        }
    }


    //role : update an user info
    //info can update: email and password
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
        }
    }

    //role: get users by them type
    //types is: Apprenent, Formateur, Secretaire.
    @Override
    public ResultSet getByType(String type) throws SQLException {
        try {
            var sql = "SELECT * FROM Users WHERE type ='" + type + "';";
            PreparedStatement stmt = Objects.requireNonNull(connect()).prepareStatement(sql);
            return stmt.executeQuery();
        } catch (Exception e) {
            e.getMessage();
        }
        return null;
    }

    @Override
    public ResultSet getIndex(Users usr) throws SQLException {
        try {
            var sql = "SELECT * FROM Users WHERE email =?;";
            PreparedStatement stmt = Objects.requireNonNull(connect()).prepareStatement(sql);
            stmt.setString(1, usr.getEmail());
            return stmt.executeQuery();
        } catch (Exception e) {
            e.getMessage();
        }
        return null;
    }

    @Override
    public ResultSet getUserById(int id) throws SQLException {
            try {
                String sql = "SELECT * FROM `Users` WHERE id= ? ";
                PreparedStatement stmt = Objects.requireNonNull(Connexion.connect()).prepareStatement(sql);
                stmt.setInt(1, id);
                return stmt.executeQuery();
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
            return null;
        }

}
