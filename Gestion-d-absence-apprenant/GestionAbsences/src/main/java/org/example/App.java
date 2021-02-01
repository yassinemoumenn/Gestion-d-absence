package org.example;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * JavaFX App
 */
public class App extends Application {

    private static Scene scene;

    public static void setRoot(String secretaire) {

    }

    @Override
    public void start(Stage stage) throws IOException {

//        Parent root = FXMLLoader.load(getClass().getResource("contrapprenant.fxml"));
//Parent root = FXMLLoader.load(getClass().getResource("AdminPanel.fxml"));
        /*    Parent root = FXMLLoader.load(getClass().getResource("Login.fxml"));*/
        Parent root = FXMLLoader.load(getClass().getResource("Formateur.fxml"));

        stage.setTitle("Gestion d'asbcenses");
        stage.setScene(new Scene(root));

        stage.show();
    }


    public static void main(String[] args) {
        launch();
    }

}