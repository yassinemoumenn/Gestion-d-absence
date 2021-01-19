package org.example;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import org.example.DAO.*;
import org.example.Model.Apprenant;
import org.example.Model.Users;

import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class SetNewUser implements Initializable {
    public TextField userName;
    public PasswordField password;
    public ChoiceBox<String> dropDown_classes;
    public TextField email;
    ObservableList<String> classes = FXCollections.observableArrayList();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try {
            setDropDown();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }


    private void setDropDown() throws SQLException {

        ClassesDAO data = new ClassesDAOImpl();
        ResultSet the_classes = data.getClasses();
        while (the_classes.next()) {
            classes.add(the_classes.getString("classe"));
        }
        dropDown_classes.getItems().addAll(classes);
    }

    public void setUser(MouseEvent mouseEvent) throws SQLException {
        ClassesDAO id = new ClassesDAOImpl();
        ResultSet index = id.getIndexof(dropDown_classes.getValue());
        /* TODO fix the whiles problem */
        while (index.next()) {
            UserDao usr = new UserDaoImp();
            Users nUser = new Users(userName.getText(), email.getText(), password.getText(), "Apprenant");
            usr.create(nUser);
            ResultSet user_id = usr.getIndex(nUser);
            while (user_id.next()) {
                AdminDao setApro = new AdminDaoImp();
                System.out.println(setApro.setApprenent(new Apprenant(user_id.getInt("id"), index.getInt("id"))));
            }
        }
    }

}



















