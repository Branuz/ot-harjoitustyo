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

    
    /** 
     * Starting view and the main stage of the application
     * @param stage stage of the application
     * @throws IOException
     */
    @Override
    public void start(Stage stage) throws IOException {
        stg = stage;
        stage.setResizable(false);
        FXMLLoader fxmlLoader = new FXMLLoader(StudyMateUi.class.getResource("login-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 430, 620);
        stage.setScene(scene);
        stage.show();
    }

    
    /** 
     * Changes into a new GUI view with a given fxml location
     * @param fxml the location for the next interface
     * @throws IOException
     */
    //Changes to a new GUI view
    public void changeScene(String fxml) throws IOException {
        Parent pane = FXMLLoader.load(getClass().getResource(fxml));
        stg.getScene().setRoot(pane);
    }

    
    /** 
     * Prepares the sqlite database before launch and launches the javafx application.
     * @param args
     * @throws Exception
     */
    public static void starterMain(String[] args) throws Exception {
        conn = ConnectionManager.getConnection();
        DatabaseUpdater db = new DatabaseUpdater();
        String setup = "CREATE TABLE  IF NOT EXISTS  Users (id INTEGER PRIMARY KEY, email TEXT, name TEXT, password TEXT);";
        String listSetup = "CREATE TABLE   IF NOT EXISTS  List (id INTEGER PRIMARY KEY, word TEXT, translation TEXT, user TEXT, name TEXT);";
        String trophySetup = "CREATE TABLE   IF NOT EXISTS  Trophies (id INTEGER PRIMARY KEY, trophy TEXT, user TEXT);";
        db.databaseCreate(conn, setup);
        conn = ConnectionManager.getConnection();
        db.databaseCreate(conn, listSetup);
        conn = ConnectionManager.getConnection();
        db.databaseCreate(conn, trophySetup);
        launch();
    }
}