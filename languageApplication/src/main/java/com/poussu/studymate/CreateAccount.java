package com.poussu.studymate;

import java.io.IOException;
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

        boolean emailCheck = checkIfEmptyTextField(email);
        boolean userNameCheck = checkIfEmptyTextField(userName);
        boolean passwordCheck =  checkIfEmptyPasswordField(password);
        boolean matchingPasswords = checkIfMatchingPasswords(password, passwordReEnter);
        boolean passwordReCheck = checkIfEmptyPasswordField(passwordReEnter);

        if(emailCheck && userNameCheck && passwordCheck && passwordReCheck && matchingPasswords){
            DataBaseConnection db = new DataBaseConnection();
            db.connect();
            m.changeScene("login-view.fxml");
        }
    }

    
    private boolean checkIfEmptyTextField(TextField text){
        if(text.getText().isEmpty()){
            text.setStyle(styleError);
            return false;
        }else{
            text.setStyle(style);
            return true;
        }
    }

    
    private boolean checkIfEmptyPasswordField(PasswordField pw){
        if(pw.getText().isEmpty()){
            pw.setStyle(styleError);
            return false;
        }else{
            pw.setStyle(style);
            return true;
        }
    }

    private boolean checkIfMatchingPasswords(PasswordField pw, PasswordField pwRe){
        if(pw.getText().equals(pwRe.getText())){
            pwLabel1.setText("");
            pwLabel2.setText("");
            return true;
        }else{
            pwLabel1.setText("Passwords don't match");
            pwLabel2.setText("Passwords don't match");
            return false;
        }
    }

    
}
