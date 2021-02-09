package org.example;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class App extends Application {
    public static Stage stage;
    @Override
    public void start(Stage stage) throws IOException {
        App.stage = stage;
        Parent root = FXMLLoader.load(getClass().getResource("Formateur.fxml"));
        App.stage.setTitle("Log in");
        App.stage.setScene(new Scene(root));
        App.stage.show();
    }


    public static void main(String[] args) {
        launch();
    }

}