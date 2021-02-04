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
import org.example.Model.Absence_type;
import org.example.Model.Absences;
import org.example.Model.AffichageStudent;


import javax.swing.*;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;

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

    private int currentTypeIndex = 0;
    @FXML

    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        type.setOnAction((event) -> {
            int selectedIndex = type.getSelectionModel().getSelectedIndex();
            currentTypeIndex = selectedIndex;
        });


        try {
            typeAbsence();
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

    private ObservableList<AffichageStudent> students;

    public void showApprenants() throws SQLException, ClassNotFoundException {
        ObservableList<AffichageStudent> list = getAllApprenants();

        colfullname.setCellValueFactory(new PropertyValueFactory<AffichageStudent, String>("full_name"));
        ab.setCellValueFactory(new PropertyValueFactory<AffichageStudent, String>("type_ab"));


        TableView.setItems(list);

        students = list;

    }


    ObservableList<Absence_type> types;
    public void typeAbsence() throws SQLException, ClassNotFoundException {

        FormateurDaoImp formateur = new FormateurDaoImp();
        ObservableList<Absence_type> typesList = formateur.GetTypes();
        types = typesList;

        type.setItems(typesList.stream().map(absence_type -> absence_type.getType_ab()).collect(Collectors.collectingAndThen(toList(), l -> FXCollections.observableArrayList(l))));

    }

    int index = -1;

    private AffichageStudent currentStudent;

    public void clickColumn(MouseEvent mouseEvent) {
        index = TableView.getSelectionModel().getSelectedIndex();

        if (index <= -1) {

            return;
        }
        currentStudent = students.get(index);

        textName.setText(colfullname.getCellData(index).toString());
        type.setValue(ab.getCellData(index).toString());

    }

    public void addbtn(ActionEvent actionEvent) {
        FormateurDaoImp formateurDaoImp1 = new FormateurDaoImp();
        String typeab = (String)type.getValue();
        System.out.println(typeab);
        Absence_type type = types.get(currentTypeIndex);
         formateurDaoImp.UpdateAbsence(currentStudent.getId(), type.getId());
         try {
             showApprenants();
         } catch (Exception e)
        {

        }
    }

}






