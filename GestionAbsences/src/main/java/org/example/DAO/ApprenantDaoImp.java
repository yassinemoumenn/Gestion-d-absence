package org.example.DAO;

<<<<<<< HEAD
import org.example.Model.Apprenant;
import org.example.MysqlConnect.Connexion;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.Objects;


public class ApprenantDaoImp implements ApprenantDao {


    @Override
    public Long getById(Long id) throws ClassNotFoundException, SQLException {
        try {
            String sql = "SELECT * FROM `users` WHERE id= ?  ";


            PreparedStatement stmt = Objects.requireNonNull(Connexion.connect()).prepareStatement(sql);
            stmt.executeQuery();
            System.out.printf("Done");
            return id;
        } catch (SQLException e) {
            System.out.printf("Not Done");
        }finally {
            if(Connexion.connect() != null){
                Connexion.connect().close();
            }
        }
        return id;
    }
    @Override
    public String setApprenant(Apprenant apprenant) throws SQLException {
        return null;
    }

    @Override
    public List<Apprenant> getAll() throws ClassNotFoundException, SQLException {
        return null;
    }

    @Override
    public String getBySpeciality(String speciality) throws ClassNotFoundException, SQLException {
        return null;
    }


}

=======
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
>>>>>>> administrateur
