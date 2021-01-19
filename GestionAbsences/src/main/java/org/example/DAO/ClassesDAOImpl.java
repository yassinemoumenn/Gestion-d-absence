package org.example.DAO;

import org.example.MysqlConnect.Connexion;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Objects;

public class ClassesDAOImpl extends Connexion implements ClassesDAO {
    @Override
    public ResultSet getClasses() throws SQLException {
        try {
            var sql = "SELECT * FROM classes;";
            PreparedStatement stmt = Objects.requireNonNull(connect()).prepareStatement(sql);
            return stmt.executeQuery();
        } catch (Exception e) {
            e.getMessage();
        } finally {
            if (connect() != null) {
                Objects.requireNonNull(connect()).close();
            }
        }
        return null;
    }

    @Override
    public ResultSet getIndexof( String cl) throws SQLException {
        try {
            var sql = "SELECT id FROM classes WHERE classe = ?;";
            PreparedStatement stmt = Objects.requireNonNull(connect()).prepareStatement(sql);
            stmt.setString(1, cl);
            return stmt.executeQuery();
        } catch (Exception e) {
            e.getMessage();
        } finally {
            if (connect() != null) {
                Objects.requireNonNull(connect()).close();
            }
        }
        return null;
    }
}
