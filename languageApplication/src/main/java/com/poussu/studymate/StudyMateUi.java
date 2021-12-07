package com.poussu.studymate;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;
import java.sql.Connection;

import com.poussu.studymate.databasehandler.ConnectionManager;
import com.poussu.studymate.databasehandler.DatabaseUpdater;

public class StudyMateUi extends Application {
    private static Stage stg;
    private static Connection conn = null;

    @Override
    public void start(Stage stage) throws IOException {
        stg = stage;
        stage.setResizable(false);
        FXMLLoader fxmlLoader = new FXMLLoader(StudyMateUi.class.getResource("login-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 430, 620);
        stage.setScene(scene);
        stage.show();
    }

    //Changes to a new GUI view
    public void changeScene(String fxml) throws IOException {
        Parent pane = FXMLLoader.load(getClass().getResource(fxml));
        stg.getScene().setRoot(pane);
    }

    public static void main(String[] args) throws Exception {
        conn = ConnectionManager.getConnection();
       // Prepares the sqlite database before launch
        DatabaseUpdater db = new DatabaseUpdater();
        String setup = "CREATE TABLE Users (id INTEGER PRIMARY KEY, email TEXT, name TEXT, password TEXT);";
        String listSetup = "CREATE TABLE List (id INTEGER PRIMARY KEY, word TEXT, translation TEXT, user TEXT, name TEXT);";
        db.databaseCreate(conn, setup);
        conn = ConnectionManager.getConnection();
        db.databaseCreate(conn, listSetup);
        launch();
    }
}