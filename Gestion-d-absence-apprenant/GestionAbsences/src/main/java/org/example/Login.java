package org.example;


import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import org.example.MysqlConnect.Connexion;

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

    public void login(MouseEvent mouseEvent) throws SQLException {

        String email = EmailInput.getText() ;
        String password = mdpInput.getText();
        Connection conn = Connexion.connect();
        PreparedStatement preparedStatement = conn.prepareStatement("SELECT * FROM `users` WHERE email= ? && password = ?");
        preparedStatement.setString(1, email);
        preparedStatement.setString(2, password);

        ResultSet resultSet = preparedStatement.executeQuery();


        if
        (resultSet.next()) {
            String type = resultSet.getString("email");
            System.out.println(email);
            System.out.println(password);
            switch (resultSet.getString("type")) {
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

        }
    }
}
