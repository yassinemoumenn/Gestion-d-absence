package org.example;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import org.example.DAO.SecretaireDaoImp;
import org.example.Model.ApprenantAbsente;

import javax.swing.*;

public class secretairecontroller implements Initializable {

        @FXML
        private ResourceBundle resources;

        @FXML
        private URL location;



    @FXML
    private TableView<ApprenantAbsente> id_table;
    @FXML
    private TableColumn<ApprenantAbsente, String> id_nom;
    @FXML
    private TableColumn<ApprenantAbsente, String> id_email;
    @FXML
    private TableColumn<ApprenantAbsente, String> id_type;
    @FXML
    private TableColumn<ApprenantAbsente, String>  id_justification;
    @FXML
    private TableColumn<ApprenantAbsente,Integer> id_Students;

    @FXML
    private TextArea text_area;

    @FXML
    private TextField text_nom;

    @FXML
    private TextField text_email;

    @FXML
    private TextField text_type;


    @FXML
    private TextField id;

    @FXML
    private ComboBox test_justification;



    @FXML

    public void initialize(URL url, ResourceBundle rb) {
        // TODO

        try {
            showApprenantsAbsences();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }

    SecretaireDaoImp secretaireDaoImp=new SecretaireDaoImp();


    public ObservableList<ApprenantAbsente> getAllApprenantsAbsence() throws SQLException, ClassNotFoundException{
        SecretaireDaoImp secretaire = new SecretaireDaoImp();

        ObservableList<ApprenantAbsente> apprenantList = secretaire.AfficheAllpprantAbsence();

        return apprenantList;
    }

    public void showApprenantsAbsences() throws SQLException, ClassNotFoundException{

            ObservableList<ApprenantAbsente> list = getAllApprenantsAbsence();

            id_nom.setCellValueFactory(new PropertyValueFactory<ApprenantAbsente, String>("Nometprenom"));
            id_email.setCellValueFactory(new PropertyValueFactory<ApprenantAbsente, String>("Email"));
            id_type.setCellValueFactory(new PropertyValueFactory<ApprenantAbsente, String>("Type_absence"));
            id_justification.setCellValueFactory(new PropertyValueFactory<ApprenantAbsente, String>("lajustification"));
            id_Students.setCellValueFactory(new PropertyValueFactory<ApprenantAbsente, Integer>("id"));

          id_table.setItems(list);


    }

    int index = -1;
    @FXML
    void getSelected (MouseEvent event){
        index = id_table.getSelectionModel().getSelectedIndex();

        if (index <= -1){

            return;
        }
        text_nom.setText(id_nom.getCellData(index).toString());
        text_email.setText(id_email.getCellData(index).toString());
        text_type.setText(id_type.getCellData(index).toString());
        id.setText(id_Students.getCellData(index).toString());


    }

   @FXML
    public void updateAb() throws SQLException, ClassNotFoundException {
        secretaireDaoImp.UpdateJustification(test_justification.getValue().toString(),Integer.parseInt(id.getText()));
        JOptionPane.showMessageDialog(null, "la justification bien modifier");
        showApprenantsAbsences();
    }

    public void update(){

    }


}
