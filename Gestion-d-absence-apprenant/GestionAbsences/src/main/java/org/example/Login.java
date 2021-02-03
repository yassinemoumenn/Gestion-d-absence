package org.example;


import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import org.example.MysqlConnect.Connexion;
import org.example.Service.ServiceUser;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Login {
    public static Stage stage;

    public static int std_id = 0;


    @FXML
    private TextField EmailInput;

    @FXML
    private PasswordField mdpInput;
    @FXML
    private Button LoginButton;

    public void login(MouseEvent mouseEvent) throws SQLException, IOException {

        String email = EmailInput.getText();
        String password = mdpInput.getText();
        Connection conn = Connexion.connect();
        PreparedStatement preparedStatement = conn.prepareStatement("SELECT * FROM `Users` WHERE email= ? && password = ?");
        preparedStatement.setString(1, email);
        preparedStatement.setString(2, ServiceUser.hashPassord(password));
        ResultSet resultSet = preparedStatement.executeQuery();


        if (resultSet.next()) {
            String type = resultSet.getString("email");
            stage = new Stage();
            Parent root;
            stage.setTitle("Gestion d'asbcenses");

            if (resultSet.getString("type").equals("Admin")) {
                root = FXMLLoader.load(getClass().getResource("AdminPanel.fxml"));
                stage.setScene(new Scene(root));
            }
            else if (resultSet.getString("type").equals("Formateur")) {
                root = FXMLLoader.load(getClass().getResource("Formateur.fxml"));
                stage.setScene(new Scene(root));
            }
            else if (resultSet.getString("type").equals("Apprenant")) {
                root = FXMLLoader.load(getClass().getResource("contrapprenant.fxml"));
                stage.setScene(new Scene(root));

                PreparedStatement stmt = conn.prepareStatement("SELECT id FROM `Students` WHERE user_id= ?");
                stmt.setInt(1, resultSet.getInt("id"));
                ResultSet rs = stmt.executeQuery();
                if (rs.next()) {
                    std_id =  rs.getInt("id");
                }
            }
            else if (resultSet.getString("type").equals("Secretaire")) {
                root = FXMLLoader.load(getClass().getResource("secretaire.fxml"));
                stage.setScene(new Scene(root));
            }
            stage.show();
            App.stage.close();
        }
    }
}
