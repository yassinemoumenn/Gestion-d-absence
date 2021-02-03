
package org.example;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import org.example.DAO.*;
import org.example.Model.Absences;

import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class Contrapprenant implements Initializable {
    public static int std_id;

    @FXML
    private Label LabelFull_name;

    @FXML
    private Label labelClass_id;
    @FXML
    private TableView<Absences> tableAbsence;

    @FXML
    private TableColumn<Absences, String> colAbs;

    @FXML
    private TableColumn<Absences, String> colAbs_date;

    public ObservableList<Absences> data = FXCollections.observableArrayList();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try {
//            if (Login.std_id != 0) {
            getApprenantInfos(31);
            getStudentsAbsences(31);
//            }

        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }

    }

    private void getStudentsAbsences(int student_id) throws SQLException {
        //get student absences
        AbsencesDAO absences = new AbsencesDAOImpl();
        colAbs.setCellValueFactory(new PropertyValueFactory<>("absence_typ"));
        colAbs_date.setCellValueFactory(new PropertyValueFactory<>("date"));
        tableAbsence.getItems().addAll(absences.getStudenstAbsences(student_id));
    }

    //role : get name the classe of this students
    private void getApprenantInfos(int user_id) throws SQLException, ClassNotFoundException {
        UserDao apprenant = new UserDaoImp();
        //get name of user from Users table
        ResultSet apprenantDetails = apprenant.getUserById(user_id);
        if (apprenantDetails.next()) {
            //get name of the students and display it in the screen
            String name = apprenantDetails.getString(2);
            LabelFull_name.setText(name);
            ApprenantDao apprenantExtraInfos = new ApprenantDaoImp();

            //get id and class_id from Students table
            ResultSet classeDetiales = apprenantExtraInfos.getById(apprenantDetails.getInt(1));

            if (classeDetiales.next()) {
                //git classe info
                int classe_id = classeDetiales.getInt(3);

                ClassesDAO ApprenantsClasse = new ClassesDAOImpl();

                ResultSet classeInfo = ApprenantsClasse.getClassById(classeDetiales.getInt(3));
                if (classeInfo.next()) {
                    labelClass_id.setText(classeInfo.getString("classe"));
                }

            }

        }
    }
}





