package com.poussu.studymate.userInterface.startUI;

import java.io.IOException;
import java.sql.Connection;
import com.poussu.studymate.Main;
import com.poussu.studymate.dataBaseHandler.ConnectionManager;
import com.poussu.studymate.dataBaseHandler.DatabaseUpdater;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class CreateAccount {
    private String style = "-fx-background-color: #34445e; ; -fx-text-fill: #FFFFFF";
    private String styleError = "-fx-border-color: red; -fx-background-color: #34445e; -fx-text-fill: #FFFFFF";
    @FXML
    private TextField email;
    @FXML
    private TextField userName;
    @FXML
    private PasswordField password;
    @FXML
    private PasswordField passwordReEnter;
    @FXML
    private Label pwLabel1;
    @FXML
    private Label pwLabel2;

    @FXML
    private void onCreateAccountClick() throws IOException {
        Main m = new Main();

        //Checking if everything is filled correctly.
        boolean emailCheck = checkIfEmptyTextField(email);
        boolean userNameCheck = checkIfEmptyTextField(userName);
        boolean passwordCheck =  checkIfEmptyPasswordField(password);
        boolean matchingPasswords = checkIfMatchingPasswords(password, passwordReEnter);
        boolean passwordReCheck = checkIfEmptyPasswordField(passwordReEnter);
        
        //Connecting to db and changing to login view.
        if (emailCheck && userNameCheck && passwordCheck && passwordReCheck && matchingPasswords) {
            Connection conn = null;
            DatabaseUpdater db = new DatabaseUpdater();
            try {
                conn = ConnectionManager.getConnection();
                String input = "INSERT INTO Users(email, name, password) VALUES (?,?,?)";
                String[] values = {email.getText().toString(), userName.getText().toString(), password.getText().toString()};
                db.databaseInsert(conn, input, values);
                m.changeScene("login-view.fxml");
                

            } catch (Exception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }

    //Used to check for empty text fields
    private boolean checkIfEmptyTextField(TextField text) {
        if (text.getText().isEmpty()) {
            text.setStyle(styleError);
            return false;
        } else {
            text.setStyle(style);
            return true;
        }
    }

    //Used to check for empty password fields
    private boolean checkIfEmptyPasswordField(PasswordField pw) {
        if (pw.getText().isEmpty()) {
            pw.setStyle(styleError);
            return false;
        } else {
            pw.setStyle(style);
            return true;
        }
    }

    //Used to check for matching password inputs
    private boolean checkIfMatchingPasswords(PasswordField pw, PasswordField pwRe) {
        if (pw.getText().equals(pwRe.getText())) {
            pwLabel1.setText("");
            pwLabel2.setText("");
            return true;
        } else {
            pwLabel1.setText("Passwords don't match");
            pwLabel2.setText("Passwords don't match");
            return false;
        }
    }
}
