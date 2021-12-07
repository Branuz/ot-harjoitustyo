package com.poussu.studymate.userInterface.startUI;

import java.io.IOException;
import java.sql.*;
import com.poussu.studymate.Main;
import com.poussu.studymate.dataBaseHandler.UserManager;
import com.poussu.studymate.userData.User;

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

    private static User loggedUser;
    @FXML
    private void onLoginButtonClick() throws Exception {
        
        if (userName.getText().isEmpty() || password.getText().isEmpty()) {
            wrongLogin.setText("Username or password is empty");
        } 

        if (checkLoginDetails(userName.getText().toString(), password.getText().toString())) {
            m.changeScene("main-menu.fxml");
        
        }else {
            wrongLogin.setText("Wrong username or password");
        }
    }

    //Confirms that the login information matches database.
    public boolean checkLoginDetails(String username, String pw) throws SQLException {
        UserManager manager = new UserManager();
        User user = manager.getLoggedUser(username, pw);
        if(user.getName()!=null && user.getPassword()!=null){
            loggedUser = user;
            return true;
        }else{
            return false;
        }
    }

    @FXML
    private void onCreateAccountButtonClick() throws IOException {
        m.changeScene("newUser-menu.fxml");
    }

    public User getLoggedUser() {
        return loggedUser;
    }
}