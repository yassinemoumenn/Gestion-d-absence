package org.example;

import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import org.example.DAO.ClassesDAO;
import org.example.DAO.ClassesDAOImpl;
import org.example.Model.classes;

import java.sql.SQLException;

public class SetNewClasse {
    public Label msgField;
    public TextField Name;


    public void SetNewClass(MouseEvent mouseEvent) throws SQLException {
        if (!Name.getText().equals("")){
            ClassesDAO setNewClass = new ClassesDAOImpl();
            System.out.println(setNewClass.setClass(new classes(Name.getText())));
            AdminPanel.stage.close();
        }else{
            msgField.setVisible(true);
            msgField.setText("Veuillez vérifier vos informations !");
        }
    }
}
