package org.example.DAO;

import org.example.Model.Secretaire;

import java.sql.SQLException;
import java.util.List;

public interface SecretaireDao {

    public List<Secretaire> getAll() throws ClassNotFoundException, SQLException;

    public Secretaire getById(int id) throws ClassNotFoundException, SQLException;

    public Secretaire sauveSecretaire(String email, String password) throws ClassNotFoundException, SQLException;

    public int updateSecretaire(int id, String email, String password) throws ClassNotFoundException, SQLException;

    public int deleteById(int id);
}