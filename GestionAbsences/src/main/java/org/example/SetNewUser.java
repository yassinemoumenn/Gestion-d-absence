package org.example;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

import java.net.URL;
import java.util.ResourceBundle;

public class SetNewUser implements Initializable {
    public TextField userName;
    public PasswordField password;
    public ChoiceBox<String>  dropDown_classes;
    public TextField email;

    ObservableList<String> classes = FXCollections.observableArrayList();
//    ObservableList<String> specialitys = FXCollections.observableArrayList();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        setDropDown();
    }


    private void setDropDown() {


        String c1 = "BLACK HOLE";
        String c2 = "COPE OF COFE";

        classes.addAll(c1, c2);
        dropDown_classes.getItems().addAll(classes);
    }

    public void setUser(MouseEvent mouseEvent) {
        System.out.println(userName.getText() + " : "+ password.getText() + " : " + email.getText()+ " : " + dropDown_classes.getValue());

    }
}
