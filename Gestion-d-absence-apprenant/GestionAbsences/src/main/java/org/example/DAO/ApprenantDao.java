package org.example.DAO;

import org.example.Model.Apprenant;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public interface ApprenantDao {

    String setApprenant(Apprenant apprenant) throws SQLException;

    List<Apprenant> getAll() throws ClassNotFoundException, SQLException;

    String getBySpeciality(String speciality) throws ClassNotFoundException, SQLException;

    ResultSet getById(int id) throws ClassNotFoundException, SQLException;

    void updateClass(Apprenant apprenant) throws  SQLException;


}
