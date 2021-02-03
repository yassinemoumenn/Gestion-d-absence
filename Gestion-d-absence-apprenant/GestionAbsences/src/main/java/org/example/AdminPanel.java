package org.example;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import org.example.DAO.*;
import org.example.Model.Apprenant;
import org.example.Model.Formateur;
import org.example.Model.StudentV2;
import org.example.Model.Users;
import org.example.Service.ServiceApprenant;
import org.example.Service.ServiceClasses;
import org.example.Service.ServiceFormateur;
import org.example.Service.ServiceSecretaire;

import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class AdminPanel implements Initializable {


    public VBox classView;
    public TableView<org.example.Model.classes> classTable;
    public TableColumn class_name;
    public TableColumn class_formateur;

    public static Stage stage;
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

    public VBox updateForm;
    public Button updateBTN;

    public Button updateStudent;
    public ChoiceBox classes;
    public Button updateBT;
    public VBox updateFor;
    public ChoiceBox classi;

    private int window = 1;

    //this 4 function control with table should display
    public void displayStude(MouseEvent mouseEvent) throws SQLException, ClassNotFoundException {
        studentPanel.setVisible(true);
        formateuPanel.setVisible(false);
        secrePanel.setVisible(false);
        classView.setVisible(false);
        window = 1;
        extracted();
    }

    public void displayform(MouseEvent mouseEvent) throws SQLException, ClassNotFoundException {
        studentPanel.setVisible(false);
        formateuPanel.setVisible(true);
        secrePanel.setVisible(false);
        classView.setVisible(false);
        window = 2;
        extracted();
    }

    public void displaySere(MouseEvent mouseEvent) throws SQLException, ClassNotFoundException {
        studentPanel.setVisible(false);
        formateuPanel.setVisible(false);
        secrePanel.setVisible(true);
        classView.setVisible(false);
        window = 3;
        extracted();
    }

    public void displayClasses(MouseEvent mouseEvent) throws SQLException, ClassNotFoundException {
        studentPanel.setVisible(false);
        formateuPanel.setVisible(false);
        secrePanel.setVisible(false);
        classView.setVisible(true);
        window = 4;
        extracted();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        App.stage.close();
        try {
            extracted();
        } catch (SQLException | ClassNotFoundException throwables) {
            System.out.println(throwables.getMessage());
        }
        try {
            setdropdown(classes);
            setdropdown(classi);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void extracted() throws SQLException, ClassNotFoundException {
        if (window == 1) {
            ServiceApprenant usess = new ServiceApprenant();
            usess.display("Apprenant", this.student_name, this.student_email, this.student_class, this.userTable);
        } else if (window == 2) {
            ServiceFormateur usess = new ServiceFormateur();
            usess.display("Formateur", formateur_name, formateur_email, formateur_class, formateurTable, 1);
        } else if (window == 3) {
            ServiceSecretaire usess = new ServiceSecretaire();
            usess.display("Secretaire", sec_name, sec_email, secreTable);
        } else {
            ServiceClasses cl = new ServiceClasses();
            cl.display(class_name, class_formateur, classTable);
        }
    }

    //pop for add new formateur
    public void setNewUserFormateur(MouseEvent mouseEvent) throws IOException {
        popUp("setNewFormateur" , "Ajouter un formateur");
    }

    //pop for add new student
    public void setNewUser(MouseEvent mouseEvent) throws IOException {
        popUp("setNewUser" , "Ajouter un étudent");

    }

    //pop for add new secreteir
    public void setNewSec(MouseEvent mouseEvent) throws IOException {
        popUp("setNewSecretaire" , "Ajouter une secrèteir");

    }

    //pop for add new class
    public void setNewClass(MouseEvent mouseEvent) throws IOException {
        popUp("SetNewClasse" , "Ajouter un classe");
    }

    private void popUp(String pop , String title) throws IOException {
        stage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource(pop + ".fxml"));
        stage.setTitle(title);
        stage.setScene(new Scene(root));
        stage.show();
    }


    public void DeleteUser(MouseEvent mouseEvent) throws SQLException, ClassNotFoundException {
        UserDao deleteUser = new UserDaoImp();
        switch (window) {
            case 1:
                if (!userTable.getSelectionModel().isEmpty())
                    deleteUser.deleteById(userTable.getSelectionModel().getSelectedItem().getId());
            case 2:
                if (!formateurTable.getSelectionModel().isEmpty())
                    deleteUser.deleteById(formateurTable.getSelectionModel().getSelectedItem().getId());
            case 3:
                if (!secreTable.getSelectionModel().isEmpty())
                    deleteUser.deleteById(secreTable.getSelectionModel().getSelectedItem().getId());
        }
        extracted();
    }

    public void UpdateUser(MouseEvent mouseEvent) throws SQLException {
        updateForm.setVisible(true);
        updateBTN.setVisible(false);
    }

    //TODO remove duplicate of this method from SetNewUser file
    private void setdropdown(ChoiceBox classs) throws SQLException {
        ObservableList<String> clas = FXCollections.observableArrayList();
        ClassesDAO data = new ClassesDAOImpl();
        ResultSet the_classes = data.getClasses();
        while (the_classes.next()) {
            clas.add(the_classes.getString("classe"));
        }
        classs.getItems().addAll(clas);
    }

    public void UpdateStudent(MouseEvent mouseEvent) throws SQLException, ClassNotFoundException {
        if (window == 1) {
            updateApprenant(new ClassesDAOImpl());
        } else if (window == 2) {
            updateFormateur(new ClassesDAOImpl());
        }
        extracted();
    }

    public void UpdateForma(MouseEvent mouseEvent) {
        updateBT.setVisible(false);
        updateFor.setVisible(true);
    }


    private void updateFormateur(ClassesDAO id) throws SQLException {
        ResultSet index = id.getIndexof((String) classi.getValue());
        FormateurDao formateur = new FormateurDaoImp();
        if (index.next()) {
            Formateur formateur1 = new Formateur(formateurTable.getSelectionModel().getSelectedItem().getId(), index.getInt("id"));
            formateur.updateFormateur(formateur1);
        }
        updateBT.setVisible(true);
        updateFor.setVisible(false);
    }

    private void updateApprenant(ClassesDAO id) throws SQLException {
        ResultSet index = id.getIndexof((String) classes.getValue());
        ApprenantDao apprenant = new ApprenantDaoImp();
        if (index.next()) {
            Apprenant student = new Apprenant(userTable.getSelectionModel().getSelectedItem().getId(), index.getInt("id"));
            apprenant.updateClass(student);
        }
        updateForm.setVisible(false);
        updateBTN.setVisible(true);
    }


    //this purpese of this function is to delete classes
    public void DeleteClass(MouseEvent mouseEvent) throws SQLException, ClassNotFoundException {
        if (!classTable.getSelectionModel().isEmpty()) {
            ClassesDAO delete = new ClassesDAOImpl();
            delete.deleteById(classTable.getSelectionModel().getSelectedItem().getId());
            extracted();
        }

    }


    public void refresh(MouseEvent mouseEvent) throws SQLException, ClassNotFoundException {
      extracted();
    }

    public void logout(MouseEvent mouseEvent) throws IOException {
        popUp("Login" , "Log in");
        updateBTN.getScene().getWindow().hide();
    }
}



