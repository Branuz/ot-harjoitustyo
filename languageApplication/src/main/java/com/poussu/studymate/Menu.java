package com.poussu.studymate;

import java.io.IOException;

import javafx.fxml.FXML;

public class Menu {
    
    @FXML
    private void logOutButton() throws IOException{
        Main m = new Main();
        m.changeScene("login-view.fxml");
    }
}
