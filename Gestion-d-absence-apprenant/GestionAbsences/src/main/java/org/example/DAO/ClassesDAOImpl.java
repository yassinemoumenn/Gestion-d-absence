package org.example.DAO;

import org.example.MysqlConnect.Connexion;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Objects;

public class ClassesDAOImpl  implements ClassesDAO {
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
    public ResultSet getIndexof( String cl) throws SQLException {
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
        } finally {
            if (Connexion.connect() != null) {
                Objects.requireNonNull(Connexion.connect()).close();
            }
        }
        return null;
    }
}
