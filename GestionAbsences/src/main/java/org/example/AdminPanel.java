package org.example;


import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
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
import org.example.DAO.UserDao;
import org.example.DAO.UserDaoImp;
import org.example.Model.Users;
import org.example.Service.ServiceApprenant;

import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class AdminPanel implements Initializable {


    public VBox studentPanel;
    public VBox formateuPanel;
    public VBox secrePanel;
    public TableView<Users> userTable;
    public TableColumn<? extends Object, ? extends Object> student_id;
    public TableColumn<? extends Object, ? extends Object> student_name;
    public TableColumn<? extends Object, ? extends Object> student_email;
    public TableColumn<? extends Object, ? extends Object> student_class;


    public void displayStude(MouseEvent mouseEvent) {
        studentPanel.setVisible(true);
        formateuPanel.setVisible(false);
        secrePanel.setVisible(false);


    }

    public void displayform(MouseEvent mouseEvent) {
        studentPanel.setVisible(false);
        formateuPanel.setVisible(true);
        secrePanel.setVisible(false);


    }

    public void displaySere(MouseEvent mouseEvent) {
        studentPanel.setVisible(false);
        formateuPanel.setVisible(false);
        secrePanel.setVisible(true);
    }

    public void setNewUser(MouseEvent mouseEvent) throws IOException {
        Stage stage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("setNewUser.fxml"));
        stage.setTitle("Ajouté nevaeu utilisateur");
        stage.setScene(new Scene(root));
        stage.show();
    }


    private void dislpayAprrenats() throws SQLException {

        ServiceApprenant usess = new ServiceApprenant();
        student_id.setCellValueFactory(new PropertyValueFactory<>("id"));
        student_name.setCellValueFactory(new PropertyValueFactory<>("full_name"));
        student_email.setCellValueFactory(new PropertyValueFactory<>("email"));
        //TODO display class insted of type
        student_class.setCellValueFactory(new PropertyValueFactory<>("type"));
        userTable.setItems(usess.collectApprenants());
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try {
            dislpayAprrenats();
        } catch (SQLException throwables) {
            System.out.println(throwables.getMessage());
        }
    }
}
