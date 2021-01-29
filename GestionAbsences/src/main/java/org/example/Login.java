package org.example;


import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import org.example.MysqlConnect.Connexion;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Login{

    @FXML
    private TextField EmailInput;

    @FXML
    private PasswordField mdpInput;

    @FXML
    private Button LoginButton;

    @FXML
    private void login() throws IOException, SQLException {



        String email = EmailInput.getText();
        String mdp = mdpInput.getText();
        Connection conn = Connexion.connect();
        PreparedStatement preparedStatement = conn.prepareStatement("SELECT * FROM `users` WHERE email= ? && password = ?");
        preparedStatement.setString(1, email);
        preparedStatement.setString(2, mdp);

        ResultSet resultSet = preparedStatement.executeQuery();
        if (resultSet.next()){
            switch (resultSet.getString("type")){
                case "Admin":
                    App.setRoot("admin");
                    break;
                case "Secretaire":
                    App.setRoot("secretaire");
                    break;
                case "Formateur":
                    App.setRoot("formateur");
                    break;
                case "Apprenant":
                    App.setRoot("Apprenant");
                    break;

            }

}}
}
