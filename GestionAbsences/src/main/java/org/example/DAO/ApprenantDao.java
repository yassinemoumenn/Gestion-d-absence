package org.example.DAO;

<<<<<<< HEAD
import org.example.Model.Apprenant;
import org.example.Model.Users;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public interface ApprenantDao {

    public String setApprenant(Apprenant apprenant) throws SQLException;

    List<Apprenant> getAll() throws ClassNotFoundException, SQLException;

   String getBySpeciality(String speciality) throws ClassNotFoundException, SQLException;

    Long getById(Long id) throws ClassNotFoundException, SQLException;










=======
import org.example.MysqlConnect.Connexion;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Objects;

public interface ApprenantDao{
    ResultSet getByUserId(int id) throws SQLException;
>>>>>>> administrateur


}
