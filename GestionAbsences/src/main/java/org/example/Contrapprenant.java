
package org.example;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import org.example.Model.Apprenant;

public class Contrapprenant {

        @FXML
        private Label LabelId;

        @FXML
        private Label labelUser_id;

        @FXML
        private Label labelSpeciality_id;

        @FXML
        private Label labelClasse_id;

        @FXML
        private TableView<Apprenant> tableAbsence;

        @FXML
        private TableColumn<Apprenant, String> colAbs_Just;

        @FXML
        private TableColumn<Apprenant, String> colAbs_non_just;

        @FXML
        private TableColumn<Apprenant, String> colTaux;








}


