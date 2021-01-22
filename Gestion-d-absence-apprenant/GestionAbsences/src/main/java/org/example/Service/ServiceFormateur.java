package org.example.Service;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import org.example.DAO.*;
import org.example.Model.StudentV2;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ServiceFormateur {
    private ObservableList<StudentV2> collectFormateur(String type) throws SQLException, ClassNotFoundException {
        ObservableList<StudentV2> users = FXCollections.observableArrayList();
        UserDao dataSet = new UserDaoImp();
        ResultSet rs = dataSet.getByType(type);
        while (rs.next()) {
            //TODO call the method to get Formateur info
            FormateurDao formateur = new FormateurDaoImp();
            ResultSet apprenant = formateur.get_By_id(rs.getInt(1));

            if (apprenant.next()) {
                ClassesDAO clas = new ClassesDAOImpl();
                ResultSet cla = clas.getClassById(apprenant.getInt("classe_id"));
                if (cla.next()) {
                    StudentV2 usr = new StudentV2(rs.getInt(1), rs.getString("full_name"), rs.getString("email"), cla.getString("classe"));
                    users.add(usr);
                }
            }
        }
        return users;
    }
    public void display(String type, TableColumn name, TableColumn email, TableColumn c, TableView<StudentV2> table, int id) throws SQLException, ClassNotFoundException {
        name.setCellValueFactory(new PropertyValueFactory<>("full_name"));
        email.setCellValueFactory(new PropertyValueFactory<>("email"));
        c.setCellValueFactory(new PropertyValueFactory<>("classe"));
        table.setItems(this.collectFormateur(type));
        System.out.println(id);
    }

}
