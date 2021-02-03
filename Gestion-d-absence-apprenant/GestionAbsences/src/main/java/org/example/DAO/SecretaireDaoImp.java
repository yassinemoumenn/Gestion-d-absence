package org.example.DAO;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.example.Model.ApprenantAbsente;
import org.example.Model.Secretaire;
import org.example.MysqlConnect.Connexion;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;



public class SecretaireDaoImp  extends Connexion implements SecretaireDao{

    Statement statement=null;



    @Override
    public List<Secretaire> getAll() throws ClassNotFoundException, SQLException {
        return null;
    }

    @Override
    public Secretaire getById(int id) throws ClassNotFoundException, SQLException {
        return null;
    }

    @Override
    public Secretaire sauveSecretaire(String full_name, String email, String password) throws ClassNotFoundException, SQLException {
        return null;
    }

    @Override
    public void updateSecretaire(int id, String full_name, String email, String password) throws ClassNotFoundException, SQLException {

    }

    @Override
    public void deleteById(int id_user) throws ClassNotFoundException, SQLException {

    }

    @Override
    public void UpdateJustification(String justification,int id) {

        Connection conn = null;
        try{
            String requete = "Update absences set jistification= ? where Student_id = ?";
            PreparedStatement statement =  Objects.requireNonNull(connect()).prepareStatement(requete);

            statement.setString(1, justification);
            statement.setInt(2, id);
            statement.executeUpdate();
        }
        catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            }catch (SQLException e){
                e.printStackTrace();
            }
        }

    }

    @Override
    public ObservableList<ApprenantAbsente> AfficheAllpprantAbsence() {
        ObservableList<ApprenantAbsente> ApprenantsAbsentes= FXCollections.observableArrayList();
        Connection conn = null;
        try {
            String requete= "select full_name,email,type_ab,jistification,Student_id from users,absence_type,absences,students where users.id=students.user_id and students.id=absences.Student_id and absence_type.id=absences.Absence_type";
            PreparedStatement statement = Objects.requireNonNull(connect()).prepareStatement(requete);
            ResultSet rs = statement.executeQuery();
            ApprenantAbsente apprenantAbsente;
            while (rs.next()) {
                apprenantAbsente = new  ApprenantAbsente(rs.getString("full_name"),rs.getString("email"),rs.getString("type_ab"),rs.getString("jistification"),rs.getInt("Student_id"));
                ApprenantsAbsentes.add(apprenantAbsente);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return ApprenantsAbsentes;
    }
}




