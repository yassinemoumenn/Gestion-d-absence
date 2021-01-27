package org.example.DAO;

import org.example.Model.classes;
import org.example.MysqlConnect.Connexion;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Objects;

public class ClassesDAOImpl implements ClassesDAO {
    @Override
    public ResultSet getClasses() throws SQLException {
        try {
            var sql = "SELECT * FROM classes;";
            PreparedStatement stmt = Objects.requireNonNull(Connexion.connect()).prepareStatement(sql);
            return stmt.executeQuery();
        } catch (Exception e) {
            e.getMessage();
        } finally {
            if (Connexion.connect() != null) {
                Objects.requireNonNull(Connexion.connect()).close();
            }
        }
        return null;
    }

    @Override
    public ResultSet getIndexof(String cl) throws SQLException {
        try {
            var sql = "SELECT id FROM classes WHERE classe = ?;";
            PreparedStatement stmt = Objects.requireNonNull(Connexion.connect()).prepareStatement(sql);
            stmt.setString(1, cl);
            return stmt.executeQuery();
        } catch (Exception e) {
            e.getMessage();
        } finally {
            if (Connexion.connect() != null) {
                Objects.requireNonNull(Connexion.connect()).close();
            }
        }
        return null;
    }

    @Override
    public ResultSet getClassById(int id) throws SQLException {
        try {
            var sql = "SELECT classe FROM classes WHERE id = ?;";
            PreparedStatement stmt = Objects.requireNonNull(Connexion.connect()).prepareStatement(sql);
            stmt.setInt(1, id);
            return stmt.executeQuery();
        } catch (Exception e) {
            e.getMessage();
        }
        return null;
    }

    @Override
    public String setClass(classes classes) throws SQLException {
        try {
            String sql = "INSERT INTO `classes`(`classe`) VALUES (?);";
            PreparedStatement stmt = Objects.requireNonNull(Connexion.connect()).prepareStatement(sql);
            stmt.setString(1, classes.getClasse());
            stmt.executeUpdate();
            return "done";
        } catch (SQLException throwables) {
            return throwables.getMessage();
        }


    }

    //because the id od the table is a PK and we use it loke a FK
    // we can't delete or update any row inside this table

//    @Override
//    public void deleteById(int id) throws SQLException {
//        try {
//            var sql = "DELETE FROM classes WHERE id =?;";
//            PreparedStatement stmt = Objects.requireNonNull(connect()).prepareStatement(sql);
//            stmt.setInt(1, id);
//            stmt.executeUpdate();
//
//        } catch (Exception e) {
//            System.out.println(e.getMessage());
//        } finally {
//            if (connect() != null) {
//                Objects.requireNonNull(connect()).close();
//            }
//        }
//    }
}
