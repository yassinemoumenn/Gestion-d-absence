package org.example.Service;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import org.example.DAO.ClassesDAO;
import org.example.DAO.ClassesDAOImpl;
import org.example.Model.classes;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ServiceClasses {

    //get all the classes from the DB
    private ObservableList<classes> collectClasses() throws SQLException {
        ObservableList<classes> classses = FXCollections.observableArrayList();
        ClassesDAO getClss = new ClassesDAOImpl();
        ResultSet rs = getClss.getClasses();
        while (rs.next()) {
            classes newClass = new classes(rs.getInt("id"), rs.getString("classe"));
            classses.add(newClass);
        }
        return classses;
    }

    //display the classes in the TableView
    public void display(TableColumn name, TableColumn email, TableView<classes> table) throws SQLException, ClassNotFoundException {
        name.setCellValueFactory(new PropertyValueFactory<>("id"));
        email.setCellValueFactory(new PropertyValueFactory<>("classe"));
        table.setItems(this.collectClasses());
    }
}
