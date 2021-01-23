package org.example;

import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import org.example.DAO.UserDao;
import org.example.DAO.UserDaoImp;
import org.example.Model.StudentV2;
import org.example.Model.Users;
import org.example.Service.ServiceApprenant;
import org.example.Service.ServiceFormateur;
import org.example.Service.ServiceSecretaire;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class AdminPanel implements Initializable {
    public VBox studentPanel;
    public VBox formateuPanel;
    public VBox secrePanel;
    public TableView<StudentV2> userTable;

    public TableColumn student_name;
    public TableColumn student_email;
    public TableColumn student_class;

    public TableColumn formateur_name;
    public TableColumn formateur_email;
    public TableColumn formateur_class;

    public TableView<StudentV2> formateurTable;
    public TableView<Users> secreTable;

    public TableColumn sec_name;
    public TableColumn sec_email;


    private int window = 1;


    public void displayStude(MouseEvent mouseEvent) throws SQLException, ClassNotFoundException {
        studentPanel.setVisible(true);
        formateuPanel.setVisible(false);
        secrePanel.setVisible(false);
        window = 1;
        extracted();

    }

    public void displayform(MouseEvent mouseEvent) throws SQLException, ClassNotFoundException {
        studentPanel.setVisible(false);
        formateuPanel.setVisible(true);
        secrePanel.setVisible(false);
        window = 2;

        extracted();
    }

    public void displaySere(MouseEvent mouseEvent) throws SQLException, ClassNotFoundException {
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

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try {
            extracted();
        } catch (SQLException | ClassNotFoundException throwables) {
            System.out.println(throwables.getMessage());
        }
    }

    private void extracted() throws SQLException, ClassNotFoundException {
        if (window == 1) {
            ServiceApprenant usess = new ServiceApprenant();
            usess.display("Apprenant", student_name, student_email, student_class, userTable);
        } else if (window == 2) {
            ServiceFormateur usess = new ServiceFormateur();
            usess.display("Formateur", formateur_name, formateur_email, formateur_class, formateurTable, 1);
        } else {
            ServiceSecretaire usess = new ServiceSecretaire();
            usess.display("Secretaire", sec_name, sec_email, secreTable);
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


    public void DeleteUser(MouseEvent mouseEvent) throws SQLException, ClassNotFoundException {
        UserDao deleteUser = new UserDaoImp();
        if (window == 1) {
            deleteUser.deleteById(userTable.getSelectionModel().getSelectedItem().getId());
        } else if (window == 2) {
            deleteUser.deleteById(formateurTable.getSelectionModel().getSelectedItem().getId());
        } else {
            deleteUser.deleteById(secreTable.getSelectionModel().getSelectedItem().getId());
        }
        extracted();
    }

}
