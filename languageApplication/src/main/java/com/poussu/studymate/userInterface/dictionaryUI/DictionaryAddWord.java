package com.poussu.studymate.userInterface.dictionaryUI;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ResourceBundle;
import com.poussu.studymate.Main;
import com.poussu.studymate.databasehandler.ConnectionManager;
import com.poussu.studymate.databasehandler.DatabaseUpdater;
import com.poussu.studymate.dictionary.Word;
import com.poussu.studymate.userInterface.startUI.Login;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

public class DictionaryAddWord extends DictionaryMenu {
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

    private ObservableList<Word> listItems = FXCollections.observableArrayList();

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
    private void addWord() throws SQLException {
        Connection conn = null;

        try {
        conn = ConnectionManager.getConnection();

        DatabaseUpdater manager = new DatabaseUpdater();
        String[] values = {wordField.getText().toString(), translationField.getText().toString(), l.getLoggedUser().getName(), getWlist().getName()};
        String statement = "INSERT INTO List(word, translation, user, name) VALUES (?,?,?,?)";
        getWlist().getList().add(new Word(wordField.getText().toString(), translationField.getText().toString()));
        manager.databaseInsert(conn, statement, values);
        listItems.add(new Word(wordField.getText().toString(), translationField.getText().toString()));
        words.setCellValueFactory(new PropertyValueFactory<Word, String>("word"));
        translations.setCellValueFactory(new PropertyValueFactory<Word, String>("translation"));
        table.setItems(listItems);


    } catch (Exception e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    }
    }

    public ObservableList<Word> getListItems(){
        return listItems;
    }
}
