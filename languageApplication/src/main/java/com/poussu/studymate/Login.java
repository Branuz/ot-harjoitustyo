package com.poussu.studymate;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class Login {
    @FXML
    private Label welcomeText;
    @FXML
    private TextField userName;
    @FXML
    private PasswordField password;

    @FXML
    protected void onHelloButtonClick() {
        if(userName.getText().toString().equals("Admin") && password.getText().equals("1234")) System.out.println("working");
    }
}