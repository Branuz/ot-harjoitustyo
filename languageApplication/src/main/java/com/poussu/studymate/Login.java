package com.poussu.studymate;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class Login {
    @FXML
    private Label wrongLogin;
    @FXML
    private TextField userName;
    @FXML
    private PasswordField password;

    @FXML
    private void onHelloButtonClick() {
        Main m = new Main();

        if(userName.getText().toString().equals("Admin") && password.getText().equals("1234"))System.out.println("Working");

            else if(userName.getText().isEmpty() || password.getText().isEmpty()){
                wrongLogin.setText("Username or password is empty");
                
            } else if(!userName.getText().toString().equals("Admin") || !password.getText().equals("1234")) {
                wrongLogin.setText("Wrong username or password");
            }
    }
}