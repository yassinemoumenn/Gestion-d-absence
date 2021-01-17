package org.example.DAO;

import org.example.Model.Apprenant;
import org.example.Model.Formateur;

import java.sql.SQLException;

public interface AdminDao {


    String setApprenent(Apprenant apprenant) throws SQLException;


    String updateApprenent(Apprenant apprenant) throws SQLException;


    String setFormateur(Formateur formateur) throws SQLException;


    String updateFormateur(Formateur formateur) throws SQLException;


}
