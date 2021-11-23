package com.poussu.studymate;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class Login {
    private Main m = new Main();
    @FXML
    private Label wrongLogin;
    @FXML
    private TextField userName;
    @FXML
    private PasswordField password;
    @FXML
    private void onLoginButtonClick() throws IOException {

        if(userName.getText().toString().equals("Admin") && password.getText().equals("1234")){
            m.changeScene("main-menu.fxml");
        }
            else if(userName.getText().isEmpty() || password.getText().isEmpty()){
                wrongLogin.setText("Username or password is empty");

            } else if(!userName.getText().toString().equals("Admin") || !password.getText().equals("1234")) {
                wrongLogin.setText("Wrong username or password");
            }
    }

    @FXML
    private void onCreateAccountButtonClick() throws IOException {
        m.changeScene("newUser-menu.fxml");
    }
}