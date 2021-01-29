
package org.example;

import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import org.example.DAO.ApprenantDao;
import org.example.DAO.ApprenantDaoImp;
import org.example.Model.Apprenant;
import org.example.MysqlConnect.Connexion;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class Contrapprenant   {

    @FXML
    private Label LabelFull_name;

    @FXML
    private Label labelClass_id;
    @FXML
    private TableView<Apprenant> tableAbsence;

    @FXML
    private TableColumn<Apprenant, String> colAbs;

    @FXML
    private TableColumn<Apprenant, String> colAbs_date;

    public ObservableList<Apprenant> data = FXCollections.observableArrayList();

    @FXML
    public void getbyId(){





    }}





