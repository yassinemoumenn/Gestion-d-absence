package org.example.DAO;

import org.example.Model.Formateur;
import org.example.MysqlConnect.Connexion;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Objects;

import static org.example.MysqlConnect.Connexion.connect;

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
        } finally {
            if (Connexion.connect() != null) {
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
    public void updateFormateur(Formateur formateur) throws SQLException {
        try {
            var sql = "UPDATE Teachers SET `classe_id`= ? WHERE user_id = ?";
            PreparedStatement stmt = Objects.requireNonNull(connect()).prepareStatement(sql);
            stmt.setInt(1, formateur.getClass_id());
            stmt.setInt(2, formateur.getUser_id());
            stmt.executeUpdate();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            if (connect() != null) {
                Objects.requireNonNull(connect()).close();
            }
        }
    }
}
