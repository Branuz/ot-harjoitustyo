package com.poussu.studymate.userInterface.dictionaryUI;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;
import com.poussu.studymate.StudyMateUi;
import com.poussu.studymate.databasehandler.ConnectionManager;
import com.poussu.studymate.databasehandler.DatabaseUpdater;
import com.poussu.studymate.dictionary.Word;
import com.poussu.studymate.trophies.AllTrophies;
import com.poussu.studymate.userInterface.startUI.Login;
import com.poussu.studymate.wordgame.WordGame;

import javafx.animation.PauseTransition;
import javafx.beans.binding.Bindings;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.StackPane;
import javafx.util.Duration;

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

    @FXML
    StackPane trophyPopper;

    private ObservableList<Word> listItems = FXCollections.observableArrayList();

    private StudyMateUi m = new StudyMateUi();
    private Login l = new Login();
    private DictionaryMenu menu = new DictionaryMenu();

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        DatabaseUpdater manager = new DatabaseUpdater();
        Connection conn;

        AllTrophies trophies = new AllTrophies();
        if(!trophies.getCompletedTrophies().contains("firstList")) {
            showTrophyPopUp();
        }

        try {
            conn = ConnectionManager.getConnection();
            String trophyStatement = "INSERT INTO Trophies(trophy, user) VALUES (?,?)";
            String[] trophyValueStrings = {"firstList", l.getLoggedUser().getName()};
            manager.databaseInsert(conn, trophyStatement, trophyValueStrings);
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        WordGame game = new WordGame();
        if(menu.getEditList()!=null){
            setWlist(menu.getEditList());
            ArrayList<String> list = new ArrayList<>();
            list.add(menu.getEditList());
            ArrayList<Word> wordList =  game.randomWordList(list);
            getWlist().getList().addAll(wordList);
            listItems.addAll(wordList);
            words.setCellValueFactory(new PropertyValueFactory<Word, String>("word"));
            translations.setCellValueFactory(new PropertyValueFactory<Word, String>("translation"));
            table.setItems(listItems);

        }
        cellEditorSettings();
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
    private void achievementButton() throws IOException{
        m.changeScene("achievements.fxml");
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
        
       if(listItems.size() == 20) {
           AllTrophies trophies = new AllTrophies();
           if(!trophies.getCompletedTrophies().contains("listOfTwentyWords")) {
               showTrophyPopUp();
           }
           conn = ConnectionManager.getConnection();
           String trophyStatement = "INSERT INTO Trophies(trophy, user) VALUES (?,?)";
           String[] trophyValueStrings = {"listOfTwentyWords", l.getLoggedUser().getName()};
           manager.databaseInsert(conn, trophyStatement, trophyValueStrings);
       } 

        wordField.setText("");
        translationField.setText("");

    } catch (Exception e) {
        e.printStackTrace();
    }
    }

    public ObservableList<Word> getListItems() {
        return listItems;
    }


    private void cellEditorSettings(){
        table.setRowFactory(lv -> {

            TableRow<Word> cell = new TableRow<>();
            ContextMenu contextMenu = new ContextMenu();

            MenuItem deleteItem = new MenuItem();
            deleteItem.textProperty().bind(Bindings.format("Delete"));
            deleteItem.setOnAction(event -> {
                Connection conn;

                try {
                    conn = ConnectionManager.getConnection();
                    DatabaseUpdater db = new DatabaseUpdater();
                    String statement = "DELETE FROM List WHERE word = ? AND translation = ? AND user = ?";
                    String[] userPara= {cell.getItem().getWord(), cell.getItem().getTranslation(), l.getLoggedUser().getName()};

                    db.databaseInsert(conn, statement, userPara);
                    table.getItems().remove(cell.getItem());
            } catch (Exception e) {
                e.printStackTrace();
            }
            });
            
            contextMenu.getItems().addAll(deleteItem);

            cell.emptyProperty().addListener((obs, wasEmpty, isNowEmpty) -> {
                if (isNowEmpty) {
                    cell.setContextMenu(null);
                } else {
                    cell.setContextMenu(contextMenu);
                }
            });
            return cell ;
        });
    }

    private void showTrophyPopUp() {
        trophyPopper.setVisible(true);
        PauseTransition visiblePause = new PauseTransition(Duration.seconds(5));
        visiblePause.setOnFinished(event -> trophyPopper.setVisible(false));
        visiblePause.play();
    }
}
