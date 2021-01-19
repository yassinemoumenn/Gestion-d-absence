package org.example;


import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;

public class AdminPanel {


    public VBox studentPanel;
    public VBox formateuPanel;
    public VBox secrePanel;


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
}
