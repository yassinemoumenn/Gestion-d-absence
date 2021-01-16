package org.example.DAO;

import java.sql.ResultSet;

public interface UserDao {


    String createFormateur();

    String createCondidate();

    String createSecritaire();


    String deleteFormateurById();

    String deleteCondidateById();

    String deleteSecritaireById();


    String updateFormateurById();

    String updateCondidateById();

    String updateSecritaireById();


    ResultSet getAllFormateur();

    ResultSet getAllCondidate();

    ResultSet getAllSecritaire();

}