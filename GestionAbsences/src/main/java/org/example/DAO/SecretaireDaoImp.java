package org.example.DAO;

import org.example.Model.Secretaire;
import org.example.MysqlConnect.Connexion;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class SecretaireDaoImp implements SecretaireDao {

    Statement statement=null;
    @Override
    public List<Secretaire> getAll() throws ClassNotFoundException, SQLException {

        List<Secretaire> secretaires= new ArrayList<Secretaire>();


        statement = Connexion.getMyConnexion().createStatement();
        System.out.println("creation de l'objet Statement");

        //4- selectionner la table secretaire
        ResultSet resultat;
        String requete = "Select * From user";

        resultat = statement.executeQuery(requete);

        while (resultat.next()) {
            int id = resultat.getInt("id_user");
            String email=resultat.getString("mail");
            String password=resultat.getString("password");


            // Creer l'objet Personne
            Secretaire s = new Secretaire(id,email,password);
            secretaires.add(s);
        }

        return secretaires;
    }

    @Override
    public Secretaire getById(int id) throws ClassNotFoundException, SQLException {
        return null;
    }

    @Override
    public Secretaire sauveSecretaire(String email, String password) throws ClassNotFoundException, SQLException {
        return null;
    }

    @Override
    public int updateSecretaire(int id,String email, String password) throws ClassNotFoundException, SQLException {
        return 0;
    }

    @Override
    public int deleteById(int id) {
        return 0;
    }
}
