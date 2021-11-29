package com.poussu.studymate;

import java.io.IOException;

import javafx.fxml.FXML;

public class Menu {
    private Main m = new Main();
    
    @FXML
    private void logOutButton() throws IOException{
        m.changeScene("login-view.fxml");
    }

    @FXML
    private void mainMenuButton() throws IOException{
        m.changeScene("main-menu.fxml");
    }
    @FXML
    private void dictionaryButton() throws IOException{
        m.changeScene("dictionary-menu.fxml");
    }
}
