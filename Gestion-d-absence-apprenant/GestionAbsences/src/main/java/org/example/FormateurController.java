package org.example;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import org.example.DAO.FormateurDaoImp;
import org.example.Model.Absences;
import org.example.Model.AffichageStudent;


import javax.swing.*;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class FormateurController implements Initializable {

    @FXML
    private TableView<AffichageStudent> TableView;
    @FXML
    private TableColumn<AffichageStudent, String> colfullname;
    @FXML
     private  TableColumn <AffichageStudent, String> ab;
    @FXML
    private ComboBox type;
    @FXML
    private TextField textName;

    @FXML
    private Button insert;
   

    public FormateurController() {
    }

    @FXML

    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        typeAbsence();
        try {
            showApprenants();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }

    FormateurDaoImp formateurDaoImp = new FormateurDaoImp();

    public ObservableList<AffichageStudent> getAllApprenants() throws SQLException, ClassNotFoundException {
        FormateurDaoImp formateur = new FormateurDaoImp();
        ObservableList<AffichageStudent> apprenantList = formateur.AfficheStudentName();
        //selectApprenant.getItems().apprenantList;
        return apprenantList;
    }

    public void showApprenants() throws SQLException, ClassNotFoundException {
        ObservableList<AffichageStudent> list = getAllApprenants();

        colfullname.setCellValueFactory(new PropertyValueFactory<AffichageStudent, String>("full_name"));
        ab.setCellValueFactory(new PropertyValueFactory<AffichageStudent, String>("type_ab"));


        TableView.setItems(list);
        //TableView.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
        //TableView.getSelectionModel().setCellSelectionEnabled(true);

    }


    public void typeAbsence() {

        ObservableList typeAbsence = FXCollections.observableArrayList(
                "Absent", "Demi_journée"
        );

        type.setItems(typeAbsence);


    }

    int index = -1;

    public void clickColumn(MouseEvent mouseEvent) {
        index = TableView.getSelectionModel().getSelectedIndex();


        if (index <= -1) {

            return;
        }
        textName.setText(colfullname.getCellData(index).toString());
        type.setValue(ab.getCellData(index).toString());



    }

    public void addbtn(ActionEvent actionEvent) {
        FormateurDaoImp formateurDaoImp1 = new FormateurDaoImp();
        //String student = textName.getText();
        String typeab = (String)type.getValue();
        System.out.println(typeab);
       // Absences absences = new Absences(typeab);
        //formateurDaoImp1.setAbsence(absences);


    }

}






