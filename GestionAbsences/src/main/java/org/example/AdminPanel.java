package org.example;

import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import org.example.Model.Users;
import org.example.Service.ServiceApprenant;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class AdminPanel implements Initializable {
    public VBox studentPanel;
    public VBox formateuPanel;
    public VBox secrePanel;
    public TableView<Users> userTable;
    public TableColumn student_id;
    public TableColumn student_name;
    public TableColumn student_email;
    public TableColumn student_class;
    public TableColumn formateur_id;
    public TableColumn formateur_name;
    public TableColumn formateur_email;
    public TableColumn formateur_class;
    public TableView formateurTable;
    public TableView secreTable;

    public TableColumn sec_id;
    public TableColumn sec_name;
    public TableColumn sec_email;
    public TableColumn formateur_class1;

    private int window = 1;


    public void displayStude(MouseEvent mouseEvent) throws SQLException {
        studentPanel.setVisible(true);
        formateuPanel.setVisible(false);
        secrePanel.setVisible(false);
        window = 1;
        extracted();

    }

    public void displayform(MouseEvent mouseEvent) throws SQLException {
        studentPanel.setVisible(false);
        formateuPanel.setVisible(true);
        secrePanel.setVisible(false);
        window = 2;

        extracted();
    }

    public void displaySere(MouseEvent mouseEvent) throws SQLException {
        studentPanel.setVisible(false);
        formateuPanel.setVisible(false);
        secrePanel.setVisible(true);
        window = 3;
        extracted();
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    private void display(String type, TableColumn id, TableColumn name, TableColumn email, TableColumn c, TableView<Users> table) throws SQLException {
        ServiceApprenant usess = new ServiceApprenant();
        id.setCellValueFactory(new PropertyValueFactory<>("id"));
        name.setCellValueFactory(new PropertyValueFactory<>("full_name"));
        email.setCellValueFactory(new PropertyValueFactory<>("email"));
        //TODO display class insted of type
        c.setCellValueFactory(new PropertyValueFactory<>("type"));
        table.setItems(usess.collectApprenants(type));
    }
    private void display(String type, TableColumn id, TableColumn name, TableColumn email,TableView<Users> table) throws SQLException {
        ServiceApprenant usess = new ServiceApprenant();
        id.setCellValueFactory(new PropertyValueFactory<>("id"));
        name.setCellValueFactory(new PropertyValueFactory<>("full_name"));
        email.setCellValueFactory(new PropertyValueFactory<>("email"));
        table.setItems(usess.collectApprenants(type));
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try {
            extracted();
        } catch (SQLException throwables) {
            System.out.println(throwables.getMessage());
        }
    }

    private void extracted() throws SQLException {
        if (window == 1){
            display("Apprenant", student_id,student_name,student_email,student_class,userTable);
        }else if (window == 2){
            display("Formateur", formateur_id,formateur_name,formateur_email,formateur_class, formateurTable);
        }else {
            display("Secretaire", sec_id,sec_name,sec_email,secreTable);
        }
    }

    //pop for add new formateur
    public void setNewUserFormateur(MouseEvent mouseEvent) throws IOException {
        popUp("setNewFormateur");
    }

    //pop for add new student
    public void setNewUser(MouseEvent mouseEvent) throws IOException {
        popUp("setNewUser");

    }

    public void setNewSec(MouseEvent mouseEvent) throws IOException {
        popUp("setNewSecretaire");

    }
    private void popUp(String pop) throws IOException {
        Stage stage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource(pop + ".fxml"));
        stage.setTitle("Ajouté nevaeu utilisateur");
        stage.setScene(new Scene(root));
        stage.show();
    }


}
