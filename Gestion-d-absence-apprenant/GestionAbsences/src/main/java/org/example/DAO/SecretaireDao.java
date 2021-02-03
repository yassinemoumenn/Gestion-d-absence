package org.example.DAO;

import javafx.collections.ObservableList;
import org.example.Model.ApprenantAbsente;
import org.example.Model.Secretaire;

import java.sql.SQLException;
import java.util.List;

public interface SecretaireDao {

    public List<Secretaire> getAll() throws ClassNotFoundException, SQLException;

    public Secretaire getById(int id) throws ClassNotFoundException, SQLException;

    public Secretaire sauveSecretaire(String full_name,String email, String password) throws ClassNotFoundException, SQLException;

    public void updateSecretaire(int id,String full_name, String email, String password)throws ClassNotFoundException, SQLException;

    public void deleteById(int id_user) throws ClassNotFoundException, SQLException;

    public void UpdateJustification(String justification,int id);

    public ObservableList<ApprenantAbsente> AfficheAllpprantAbsence();
}