package com.poussu.studymate;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;

public class Main extends Application {
    private static Stage stg;

    @Override
    public void start(Stage stage) throws IOException {
        stg = stage;
        stage.setResizable(false);
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("login-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 430, 620);
        stage.setScene(scene);
        stage.show();
    }

    //Changes to a new GUI view
    public void changeScene(String fxml) throws IOException {
        Parent pane = FXMLLoader.load(getClass().getResource(fxml));
        stg.getScene().setRoot(pane);
    }

    public static void main(String[] args) {
        //Prepares the sqlite database before launch
        DataBaseConnection db = new DataBaseConnection();
        String setup = "CREATE TABLE Users (id INTEGER PRIMARY KEY, email TEXT, name TEXT, password TEXT)";
        String listSetup = "CREATE TABLE List (id INTEGER PRIMARY KEY, word TEXT, translation TEXT, user TEXT)";
        db.connect(setup, "CREATE", new String[0]);
        db.connect(listSetup, "CREATE", new String[0]);
        launch();
    }
}