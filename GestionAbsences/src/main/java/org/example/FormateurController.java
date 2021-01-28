package org.example;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import org.example.DAO.FormateurDaoImp;
import org.example.Model.AffichageStudent;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class FormateurController implements Initializable {

    @FXML
    private TableView<AffichageStudent> TableView;
    @FXML
    private TableColumn<AffichageStudent, String> colfullname;
    @FXML
    private ComboBox type;

    @FXML
    private ComboBox selectApprenant;

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

    public ObservableList<AffichageStudent> getAllApprenants() throws SQLException, ClassNotFoundException{
        FormateurDaoImp formateur=new  FormateurDaoImp();
        ObservableList<AffichageStudent> apprenantList = formateur.AfficheStudentName();
        //selectApprenant.getItems().apprenantList;
        return apprenantList;
    }

    public void showApprenants() throws SQLException, ClassNotFoundException{
        ObservableList<AffichageStudent> list = getAllApprenants();

        colfullname.setCellValueFactory(new PropertyValueFactory<AffichageStudent, String>("full_name"));




        TableView.setItems(list);
    }


    public void typeAbsence(){

        ObservableList typeAbsence = FXCollections.observableArrayList(
                "Present","Demi_journée"
        );

        type.setItems(typeAbsence);


    }

}
