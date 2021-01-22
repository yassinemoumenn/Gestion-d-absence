package org.example.DAO;

import org.example.MysqlConnect.Connexion;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Objects;

public class ApprenantDaoImp extends Connexion  implements ApprenantDao{

    //temporary function
    public ResultSet getByUserId(int id) throws SQLException {
        try {
            var sql = "SELECT * FROM Students WHERE user_id = ?;";
            PreparedStatement stmt = Objects.requireNonNull(connect()).prepareStatement(sql);
            stmt.setInt(1, id);

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
