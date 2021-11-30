package com.poussu.studymate.dictionaryUI;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import com.poussu.studymate.DataBaseConnection;
import com.poussu.studymate.Main;
import com.poussu.studymate.startUI.Login;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

public class DictionaryAddWord  implements Initializable {
    @FXML
    private TextField wordField;
    @FXML
    private TextField translationField;
    @FXML
    private TableView<Word> table;
    @FXML
    private TableColumn<Word, String> words;
    @FXML
    private TableColumn<Word, String> translations;

    ObservableList<Word> listItems = FXCollections.observableArrayList();

    private Main m = new Main();
    private Login l = new Login();

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        //To be made
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
    private void doneButton() throws IOException {
        m.changeScene("dictionary-menu.fxml");
    }

    @FXML
    private void addWord() {
     /*   DataBaseConnection db = new DataBaseConnection();
        String input = "INSERT INTO List(word, translation, user) VALUES (?,?,?)";
        String[] values = {wordField.getText().toString(), translationField.getText().toString(), l.getLoggedUser()};
        db.connect(input, "INSERT", values);*/

        listItems.add(new Word(wordField.getText().toString(), translationField.getText().toString()));
        words.setCellValueFactory(new PropertyValueFactory<Word, String>("word"));
        translations.setCellValueFactory(new PropertyValueFactory<Word, String>("translation"));
        table.setItems(listItems);

    }
}
