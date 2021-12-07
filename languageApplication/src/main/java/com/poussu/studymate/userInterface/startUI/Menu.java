package com.poussu.studymate.userInterface.startUI;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import com.poussu.studymate.StudyMateUi;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

public class Menu implements Initializable{
    private StudyMateUi m = new StudyMateUi();
    private Login l = new Login();

    @FXML
    Label welcomeLabel;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        welcomeLabel.setText("Welcome "+l.getLoggedUser().getName());
        
    }

    @FXML
    private void logOutButton() throws IOException {
        m.changeScene("login-view.fxml");
    }

    @FXML
    private void mainMenuButton() throws IOException {
        m.changeScene("main-menu.fxml");
    }
    @FXML
    private void dictionaryButton() throws IOException {
        m.changeScene("dictionary-menu.fxml");
    }
    @FXML
    private void wordGameButton() throws IOException {
        m.changeScene("wordGame-menu.fxml");
    }

}
